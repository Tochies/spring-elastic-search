package com.tochie.springelasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
public class Article {

    @Id
    private String Id;

    private  String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authorList;
}
