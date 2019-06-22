package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import com.simbirsoft.taxi_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;

    @Override
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Driver> getAllSorted() {
        return repository.findAll(sortByLastNameAndFirstNameAndPatronymic());
    }

    @Override
    public Driver findOneById(Long id) throws EntityNotFoundException {
        Optional<Driver> candidate = repository.findById(id);
        return candidate.orElseThrow(
                () -> new EntityNotFoundException("Auto with id = " + id + " not found"));
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

    private Sort sortByLastNameAndFirstNameAndPatronymic() {
        return new Sort(Sort.Direction.ASC, "lastName")
                .and(new Sort(Sort.Direction.ASC, "firstName"))
                .and(new Sort(Sort.Direction.ASC, "patronymic"));
    }
}
