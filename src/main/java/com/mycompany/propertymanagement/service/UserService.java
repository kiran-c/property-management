package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO userLogin(String email, String password);
}
