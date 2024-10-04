package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import web.config.DBConfig;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.persistence.EntityManager;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        User user = new User();
        user.setName("qda");
        user.setLastName("ada");
        user.setAge((byte)25);
        userService.saveUser(user);

    }
}
