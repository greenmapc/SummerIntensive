package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.dao.DriverSearchDao;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.repository.filters.DriverFilter;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import com.simbirsoft.taxi_service.util.comparator.DriverFullNameComparator;
import com.simbirsoft.taxi_service.util.condition.ConditionParser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;
    private final DriverFullNameComparator driverFullNameComparator;
    private final ConditionParser conditionParser;
    private final DriverSearchDao driverSearchDao;
    private final UserService userService;

    private static final int pageSize = 12;

    @Override
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Driver> getAllSorted() {
        List<Driver> result = repository.findAll();
        result.sort(driverFullNameComparator);
        return result;
    }

    @Override
    public List<Driver> getAllWithoutRentSorted() {
        List<Driver> result = repository.findAllWithoutRent();
        result.sort(driverFullNameComparator);
        return result;
    }

    @Override
    public List<Driver> getAllWithRentSorted() {
        List<Driver> result = repository.findAllWithRent();
        result.sort(driverFullNameComparator);
        return result;
    }

    @Override
    public Driver findOneById(Long id) throws EntityNotFoundException {
        Optional<Driver> candidate = repository.findById(id);
        return candidate.orElseThrow(
                () -> new EntityNotFoundException("Auto with id = " + id + " not found"));
    }

    @Override
    public Driver createDriver(DriverForm form, User user) {
        Driver driver = Driver.builder()
                .actualAddress(form.getActualAddress())
                .blackList(false)
                .dateOfLicenseExpiry(form.getDateOfDriverLicenseExpiry())
                .dateOfLicenseIssue(form.getDateOfDriverLicenseIssue())
                .dateOfPassportIssue(form.getDateOfPassportIssue())
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
                .telegramLogin(form.getTelegramLogin().isEmpty() ? null : form.getTelegramLogin())
                .birthDate(form.getBirthDate())
                .build();

        userService.addAction(user, OperatorActionEnum.CREATE_DRIVER);

        return repository.save(driver);
    }

    @Override
    public Driver updateInfo(Driver driver, DriverForm form) {
        driver.setActualAddress(form.getActualAddress());
        driver.setResidenceAddress(form.getResidenceAddress());
        driver.setBlackList(form.isBlackList());
        driver.setFirstName(form.getFirstName());
        driver.setLastName(form.getLastName());
        driver.setPatronymic(form.getPatronymic());
        driver.setDriversLicenseSeries(form.getDriversLicenseSeries());
        driver.setDriversLicenseNumber(form.getDriversLicenseNumber());
        driver.setDateOfLicenseIssue(form.getDateOfDriverLicenseIssue());
        driver.setDateOfLicenseExpiry(form.getDateOfDriverLicenseExpiry());
        driver.setPassportSeries(form.getPassportSeries());
        driver.setPassportNumber(form.getPassportNumber());
        driver.setPlaceOfPassportIssue(form.getPlaceOfPassportIssue());
        driver.setDateOfPassportIssue(form.getDateOfPassportIssue());
        driver.setPhoneNumber(form.getPhoneNumber());
        driver.setTelegramLogin(form.getTelegramLogin());
        driver.setBirthDate(form.getBirthDate());
        driver.setRating(form.getRating());
        return repository.save(driver);
    }



    @Override
    public Page<Driver> getPage(Integer number, String[] conditionsList) {
        if (number == null || number < 1) {
            number = 1;
        }
        if (conditionsList==null || conditionsList.length == 0) {
            return repository.findAll(PageRequest.of(number - 1,pageSize)); //-1 because start point for user is 1
        }
        List<Condition> conditions = conditionParser.getConditions(Arrays.asList(conditionsList));
        DriverFilter driverFilter = new DriverFilter(conditions);
        return repository.findAll(driverFilter.getComplexSpecification(),PageRequest.of(number - 1,pageSize, Sort.by("id").descending()));
    }

    @Override
    public List<Driver> search(String searchString) {
        return driverSearchDao.fuzzySearch(searchString.toLowerCase());
    }

}
