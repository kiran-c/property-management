package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exceptions.BusinessException;
import com.mycompany.propertymanagement.exceptions.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO)
    {

       Optional<UserEntity> userEn =  userRepository.findByEmail(userDTO.getEmail());

       if(userEn.isPresent())
       {

           List<ErrorModel> errorModelList = new ArrayList<>();
           ErrorModel errmodel = new ErrorModel();
           errmodel.setMessage("the Account with this email is already Exist");
           errmodel.setError("DUPLICATE_EMAIL_FND");

           errorModelList.add(errmodel);

           throw new BusinessException(errorModelList);
       }


        UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);

        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO userLogin(String email, String password) {

        Optional<UserEntity> optEn = userRepository.findByEmailAndPassword(email, password);

        UserDTO userDTO = null;

        if(optEn.isPresent())
        {
            userDTO = userConverter.convertEntityToDTO(optEn.get());

        }
        else{

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel model = new ErrorModel();
            model.setError("INVALID_LOGIN");
            model.setMessage("Incorrectt UserName or Passowrd...!");

            throw new BusinessException(errorModelList);

        }

        return userDTO;
    }
}
