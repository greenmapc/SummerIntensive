package com.simbirsoft.taxi_service.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Aspect
@Component
public class EntityActionLoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(EntityActionLoggingAspect.class);

<<<<<<< HEAD:TaxiService/src/backend/java/com/simbirsoft/taxi_service/aop/EntityActionLoggingAspect.java
    @AfterThrowing(pointcut = "execution(* com.simbirsoft.taxi_service.service.impl.AutoServiceImpl.findOneById(..))",
                   throwing = "exception")
=======
    @AfterThrowing(pointcut = "execution(* com.simbirsoft.taxi_service.service.impl.DriverServiceImpl.findOneById(..))",
            throwing = "exception")
>>>>>>> enjoypls:TaxiService/src/backend/java/com/simbirsoft/taxi_service/aop/UserLoggingAspect.java
    public void failedFindingAutoById(EntityNotFoundException exception) {
        logger.error(exception.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* com.simbirsoft.taxi_service.service.impl.DriverServiceImpl.findOneById(..))",
                   throwing = "exception")
    public void failedFindingDriverById(EntityNotFoundException exception) {
        logger.error(exception.getMessage());
    }
}