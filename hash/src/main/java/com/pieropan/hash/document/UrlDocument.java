package com.pieropan.hash.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("url")
public class UrlDocument {

    @Id
    private String hash;

    @Field(name = "url_longa")
    private String urlLonga;

    @Field(name = "data_atribuicao")
    private LocalDateTime dataAtribuicao;

    public UrlDocument(String hash) {
        this.hash = hash;
    }
}