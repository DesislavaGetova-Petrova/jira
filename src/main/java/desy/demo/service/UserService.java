package desy.demo.service;

import desy.demo.model.service.UserServiceModel;

public interface UserService {
    void login(UserServiceModel user);
    UserServiceModel findUserByEmailAndPassword(String email, String password);
    UserServiceModel register(UserServiceModel userServiceModel);
}
