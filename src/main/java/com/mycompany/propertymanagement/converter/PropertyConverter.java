package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity DTOtoEntityConverter(PropertyDTO propertyDTO)
    {
        PropertyEntity pe = new PropertyEntity();
        pe.setName(propertyDTO.getName());
        pe.setTitle(propertyDTO.getTitle());
        pe.setEmail(propertyDTO.getEmail());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }


    public PropertyDTO entityToDTOConverter(PropertyEntity propertyEntity)
    {
        PropertyDTO dto = new PropertyDTO();
        dto.setName(propertyEntity.getName());
        dto.setTitle(propertyEntity.getTitle());
        dto.setEmail(propertyEntity.getEmail());
        dto.setDescription(propertyEntity.getDescription());
        dto.setPrice(propertyEntity.getPrice());

        return dto;
    }
}
