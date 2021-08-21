package com.tochie.springelasticsearch.repository;

import com.tochie.springelasticsearch.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    Page<Article> findByAuthorsName(String name, Pageable pageable);

    @Query("{\\\"bool\\\": {\\\"must\\\": [{\\\"match\\\": {\\\"authors.name\\\": \\\"?0\\\"}}]}}")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
}
