package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;

public class UserConverter {


   public UserEntity convertDTOToEntity(UserDTO userDTO)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setName(userDTO.getName());
       /userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());

        return userEntity;
    }

   public UserDTO convertEntityToDTO(UserEntity userEntity )
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setName(userEntity.getName());
        //userDTO.setPassword(userEntity.getPassword());
        userDTO.setPhone(userEntity.getPhone());

        return userDTO;
    }


}
