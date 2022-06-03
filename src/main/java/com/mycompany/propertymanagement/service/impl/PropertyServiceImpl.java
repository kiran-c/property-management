package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.controller.PropertyController;
import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO)
    {
       PropertyEntity pe = propertyConverter.entityToDTOConverter(propertyDTO);

       pe =  propertyRepository.save(pe);

       propertyDTO = propertyConverter.entityToDTOConverter(pe);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> propertyList = (List<PropertyEntity>) propertyRepository.findAll();

        List<PropertyDTO> dtoList = new ArrayList<>();

        for (PropertyEntity property : propertyList)
        {
           PropertyDTO dto =  propertyConverter.entityToDTOConverter(property);

           dtoList.add(dto);

           return dtoList;

        }
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);

        PropertyDTO dto = null;
        if(optEnt.isPresent())
        {
           PropertyEntity propertyEntity = optEnt.get();


            propertyEntity.setName(propertyDTO.getName());
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setEmail(propertyDTO.getEmail());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setPrice(propertyDTO.getPrice());

           dto =  propertyConverter.entityToDTOConverter(propertyEntity);


            propertyRepository.save(propertyEntity);

        }

        return dto;
    }

    @Override
    public PropertyDTO updateProperty_desc(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);

        PropertyDTO dto = null;

        if(optEn.isPresent())
        {
            PropertyEntity entity = optEn.get();

            entity.setDescription(propertyDTO.getDescription());

           dto =  propertyConverter.entityToDTOConverter(entity);

            propertyRepository.save(entity);

        }
        return dto;
    }

    @Override
    public PropertyDTO updateProperty_price(PropertyDTO propertyDTO, Long propertyId) {
        return null;
    }

    @Override
    public void deleteProperty(Long propertyId) {

        propertyRepository.deleteById(propertyId);

        return null;
    }


}
