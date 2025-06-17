package com.pieropan.hash.job;

import com.pieropan.hash.document.UrlDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class GeradorHashJob {

    private final MongoTemplate mongoTemplate;

    @Value("${quantidade.minima.requerida}")
    private long QUANTIDADE_MINIMA_REQUERIDA;

    // Obter todos os hashs que existem para distinguir dos que foram gerados é uma solução ruim
    // Validar um por um com mongoTemplate.upsert(query, update, UrlDocument.class) também é ruim por fazer N chamadas ao banco
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void gerar() {
        Query query = new Query().addCriteria(Criteria.where("dataAtribuicao").is(null));
        long disponiveis = mongoTemplate.count(query, UrlDocument.class);

        boolean precisoGerarCarga = disponiveis < QUANTIDADE_MINIMA_REQUERIDA;
        List<String> hashs = new ArrayList<>();

        if (precisoGerarCarga) {

            for (int i = 0; i < QUANTIDADE_MINIMA_REQUERIDA; i++) {
                byte[] r = new byte[4];
                new Random().nextBytes(r);
                String base64 = Base64.getEncoder().encodeToString(r);
                hashs.add(base64.substring(0, 6));
            }

            List<UrlDocument> documents = hashs.stream().distinct().map(UrlDocument::new).toList();
            salvaRegistros(documents);
        }
    }

    private void salvaRegistros(List<UrlDocument> documents) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, UrlDocument.class);

        for (UrlDocument doc : documents) {
            Query query = new Query(Criteria.where("_id").is(doc.getHash()));
            Update update = new Update().setOnInsert("hash", doc.getHash());

            bulkOps.upsert(query, update);
        }

        bulkOps.execute();
    }
}