package com.simbirsoft.taxi_service.dao;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
//@Repository
public class DriverSerchDao {

    private final EntityManager entityManager;

    @Autowired
    public DriverSerchDao(EntityManagerFactory factory) {
        entityManager = factory.createEntityManager();
    }
//    public DriverSerchDao(EntityManager em) {
//        entityManager = em;
//    }
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
        String[] keywords = searchTerm.split(" ");
        StringBuffer queryStringBuffer = new StringBuffer();
        for (String keyword : keywords)  {
            queryStringBuffer.append(keyword+"~2|");
        }
        queryStringBuffer.deleteCharAt(queryStringBuffer.length()-1);
        System.out.println(queryStringBuffer.toString());//todo AAAAAAAAAAAAAA
        Query luceneQuery = queryBuilder
                .simpleQueryString()
                .onFields("firstName","lastName","patronymic","phoneNumber")
                .matching(queryStringBuffer.toString())
                .createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Driver.class);

        List<Driver> BaseballCardList = null;
        try {
            BaseballCardList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
        }
        return BaseballCardList;
    }
}
