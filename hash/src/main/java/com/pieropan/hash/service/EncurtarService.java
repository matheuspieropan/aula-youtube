package com.pieropan.hash.service;

import com.pieropan.hash.controller.dto.EncurtarRequestDTO;
import com.pieropan.hash.document.UrlDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class EncurtarService {

    private final MongoTemplate mongoTemplate;

    @Cacheable(value = "urlLonga", key = "#encurtarRequestDTO.urlLonga()")
    public String encurtar(EncurtarRequestDTO encurtarRequestDTO) {
        String path = "localhost:8080/%s";
        UrlDocument existente = obterDocumentoSeJaExistir(encurtarRequestDTO.urlLonga());

        if (existente != null) {
            return (String.format(path, existente.getHash()));
        }

        UrlDocument document = criarDocumento(encurtarRequestDTO);

        return (String.format(path, document.getHash()));
    }

    private UrlDocument criarDocumento(EncurtarRequestDTO encurtarRequestDTO) {
        Query query = new Query(Criteria.where("dataAtribuicao").is(null));

        Update update = montarUpdate(encurtarRequestDTO);

        FindAndModifyOptions options = new FindAndModifyOptions().
                returnNew(true).
                upsert(false);

        return mongoTemplate.findAndModify(query, update, options, UrlDocument.class);
    }

    private UrlDocument obterDocumentoSeJaExistir(String urlLonga) {
        return mongoTemplate.findOne(
                new Query(Criteria.where("urlLonga").is(urlLonga)), UrlDocument.class
        );
    }

    private Update montarUpdate(EncurtarRequestDTO encurtarRequestDTO) {
        Update update = new Update();
        update.set("dataAtribuicao", LocalDateTime.now());
        update.set("urlLonga", encurtarRequestDTO.urlLonga());

        return update;
    }

    @Cacheable(value = "hash", key = "#hash")
    public String obterUrlLonga(String hash) {
        Query query = new Query(Criteria.where("hash").is(hash));
        UrlDocument document = mongoTemplate.findOne(query, UrlDocument.class);

        return document.getUrlLonga();
    }
}