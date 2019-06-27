package com.simbirsoft.taxi_service.dao;

import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.util.search.SearchRequestParser;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

public class DriverSearchDao {

    private final EntityManager entityManager;

    @Autowired
    public DriverSearchDao(EntityManagerFactory factory) {
        entityManager = factory.createEntityManager();
    }

    @Transactional
    public void initializeHibernateSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer(Driver.class).startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Driver> fuzzySearch(String searchTerm) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Driver.class)
                .get();
        String simpleQueryString = SearchRequestParser.getSimpleQueryString(searchTerm);
        Query luceneQuery = queryBuilder
                .simpleQueryString()
                .onFields("firstName", "lastName", "patronymic", "phoneNumber")
                .matching(simpleQueryString)
                .createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Driver.class);
        List<Driver> result = null;
        try {
            result = jpaQuery.getResultList();
        } catch (NoResultException ignored) {
        }
        return result;
    }
}
