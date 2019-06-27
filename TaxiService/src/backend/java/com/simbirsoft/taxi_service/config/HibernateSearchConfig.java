package com.simbirsoft.taxi_service.config;

import com.simbirsoft.taxi_service.dao.DriverSerchDao;
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
    public DriverSerchDao driverSerchDao() {
        DriverSerchDao driverSearchDap = new DriverSerchDao(entityManager.getEntityManagerFactory());
        driverSearchDap.initializeHibernateSearch();
        return driverSearchDap;
    }
}

