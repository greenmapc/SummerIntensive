package com.simbirsoft.taxi_service.config;

import com.simbirsoft.taxi_service.dao.AutoSearchDao;
import com.simbirsoft.taxi_service.dao.DriverSearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfig {

    @Autowired
    private EntityManager entityManager;

    @Bean
    public DriverSearchDao driverSerchDao() {
        DriverSearchDao driverSearchDap = new DriverSearchDao(entityManager.getEntityManagerFactory());
        driverSearchDap.initializeHibernateSearch();
        return driverSearchDap;
    }
    @Bean
    public AutoSearchDao autoSearchDao() {
        AutoSearchDao autoSearchDao = new AutoSearchDao(entityManager.getEntityManagerFactory());
        autoSearchDao.initializeHibernateSearch();
        return autoSearchDao;
    }
}

