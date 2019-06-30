package com.carrental.service;

import com.carrental.common.dto.UserDto;
import com.carrental.persistence.entity.User;
import com.carrental.persistence.repository.RoleRepository;
import com.carrental.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser(UserDto userDto) {
        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());

        User user = new User(userDto.getName(), userDto.getLastName(), userDto.getEmail(), encodedPassword);
        user.addRole(roleRepository.getOne(2L));
        userRepository.save(user);
    }
}
