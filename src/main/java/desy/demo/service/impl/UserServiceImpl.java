package desy.demo.service.impl;

import desy.demo.model.entity.User;
import desy.demo.model.service.UserServiceModel;
import desy.demo.repository.UserRepository;
import desy.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @Override
    public void login(UserServiceModel user) {
    }

    @Override
    public UserServiceModel findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user=this.modelMapper.map(userServiceModel, User.class);
        return this.modelMapper.map(this.userRepository.saveAndFlush(user),UserServiceModel.class);
    }

    @Override
    public String getUserName(UserServiceModel user) {
             return user.getUsername();
    }

    @Override
    public User findUserByName(String userName) {
        return userRepository.findByUsername(userName).orElse(null);
    }
}
