package com.simbirsoft.taxi_service.dao;

import com.simbirsoft.taxi_service.model.Auto;
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

public class AutoSearchDao {
    private final EntityManager entityManager;

    @Autowired
    public AutoSearchDao(EntityManagerFactory factory) {
        entityManager = factory.createEntityManager();
    }

    @Transactional
    public void initializeHibernateSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer(Auto.class).startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public List<Auto> fuzzySearch(String searchTerm) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Auto.class)
                .get();
        String simpleQueryString = SearchRequestParser.getSimpleQueryString(searchTerm);
        Query luceneQuery = queryBuilder
                .simpleQueryString()
                .onFields("brand","model","gosNumber","vinNumber")
                .matching(simpleQueryString)
                .createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Auto.class);
        List<Auto> result = null;
        try {
            result = jpaQuery.getResultList();
        } catch (NoResultException ignored) {
        }
        return result;
    }
}
