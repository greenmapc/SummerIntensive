package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.service.impl.EmailServiceImpl;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @MockBean
    private EmailServiceImpl emailService;

    private User user;

    @Before
    public void setUp() {
        user = userService.findOneById(2L);
    }

    @Test
    public void createOperator() {
        User user = createTestUser("test");
        user = userService.createOperator(UserForm.createFromUser(user));

        Assert.assertNotNull(user.getId());
        userRepository.delete(user);
    }

    @Test
    public void addAction() {
        OperatorAction operatorAction = userService.addAction(user, OperatorActionEnum.CREATE_AUTO);
        Assert.assertNotNull(operatorAction.getId());
    }

    @Test
    public void updateInfo() {
        User user = createTestUser("test");
        UserForm userForm = UserForm.createFromUser(user);
        userForm.setEmail("test2@mail.ru");
        userForm.setFirstName("test1");
        userForm.setLastName("test1");
        userForm.setPatronymic("test3");
        userForm.setNewPassword("qwerty007");
        userForm.setNewPassword2("qwerty007");

        user = userService.updateInfo(user, userForm);
        Assert.assertEquals(user, userService.findOneById(user.getId()));
        userRepository.delete(user);
    }

    @Test
    public void findOneById() {
        User testUser = createTestUser("test");
        testUser = userService.createOperator(UserForm.createFromUser(testUser));

        Assert.assertEquals(testUser, userService.findOneById(testUser.getId()));
        userRepository.delete(testUser);
    }

    private User createTestUser(String mail) {
        User user = new User();
        user.setEmail(mail + "@mail.ru");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPatronymic("Test");
        user.setPassword("qwerty");

        Set<Roles> rolesSet = new HashSet<>();
        rolesSet.add(Roles.OPERATOR);
        user.setRoles(rolesSet);

        return user;
    }
}