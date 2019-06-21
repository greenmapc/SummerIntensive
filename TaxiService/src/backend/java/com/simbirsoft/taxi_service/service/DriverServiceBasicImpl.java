package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceBasicImpl implements DriverService {
    private DriverRepository repository;

    @Autowired
    public DriverServiceBasicImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @Override
    public Driver getOne(Long id) {
        Optional<Driver> candidate = repository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void createDriver(DriverForm form) {
        Driver driver = Driver.builder()
                .actualAddress(form.getActualAddress())
                .blackList(false)
                .dateOfLicenseExpiry(new java.sql.Date(form.getDateOfDriverLicenseExpiry().getTime()))
                .dateOfLicenseIssue(new java.sql.Date(form.getDateOfDriverLicenseIssue().getTime()))
                .dateOfPassportIssue(new java.sql.Date(form.getDateOfPassportIssue().getTime()))
                .driversLicenseNumber(form.getDriversLicenseNumber())
                .driversLicenseSeries(form.getDriversLicenseSeries())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .patronymic(form.getPatronymic())
                .passportNumber(form.getPassportNumber())
                .passportSeries(form.getPassportSeries())
                .phoneNumber(form.getPhoneNumber())
                .placeOfPassportIssue(form.getPlaceOfPassportIssue())
                .rating(0)
                .residenceAddress(form.getResidenceAddress())
                .telegramLogin(form.getTelegramLogin())
                .build();
        repository.save(driver);
    }
}
