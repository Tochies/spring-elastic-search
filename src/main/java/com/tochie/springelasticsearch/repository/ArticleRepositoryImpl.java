package com.tochie.springelasticsearch.repository;

import com.tochie.springelasticsearch.config.ElasticConfiguration;
import com.tochie.springelasticsearch.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;

public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    ElasticConfiguration elasticConfiguration;

    ElasticsearchOperations elasticsearchTemplate = elasticConfiguration.elasticsearchOperations();


    @Override
    public Page<Article> findByAuthorsName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Article> searchSimilar(Article article, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Article> findAll(Sort sort) {
        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(regexpQuery("title", ".*data.*"))
                .build();

        SearchHits<Article> articles = elasticsearchTemplate.search(searchQuery, Article.class, IndexCoordinates.of("blog"));
        return articles.stream().collect(Collectors.toList());
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Article> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Article> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Article> findAll() {
        return null;
    }

    @Override
    public Iterable<Article> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Article> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
