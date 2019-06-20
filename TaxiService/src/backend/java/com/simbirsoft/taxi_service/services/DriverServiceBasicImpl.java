package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.DriverForm;
import com.simbirsoft.taxi_service.models.Auto;
import com.simbirsoft.taxi_service.models.Driver;
import com.simbirsoft.taxi_service.repositories.DriverRepository;
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
                .dateOfDriverLicenseExpiry(new java.sql.Date(form.getDateOfDriverLicenseExpiry().getTime()))
                .dateOfDriverLicenseIssue(new java.sql.Date(form.getDateOfDriverLicenseIssue().getTime()))
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
