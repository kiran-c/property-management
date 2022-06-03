package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

     @Autowired
     PropertyService propertyService;

    @GetMapping("/greet")
    public String sayHello()
    {
        return "Hello...!";
    }


    @PostMapping("/property")
   public  ResponseEntity saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
       PropertyDTO propertyDTO =  propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/property")
    public  ResponseEntity getAllProperties()
    {
        List<PropertyDTO> propertyList =  propertyService.getAllProperties();

        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("/property/{propertyId}")
    public ResponseEntity updateProperty(@RequestBody PropertyDTO productDTO, @PathVariable("propertyId") Long productId)
    {
        PropertyDTO propertyDTO =  propertyService.updateProduct(productDTO, productId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;
    }

    @PatchMapping("/property/property_desc/{propertyId}")
    public ResponseEntity updateProperty_Description(@RequestBody PropertyDTO productDTO, @PathVariable("propertyId") Long productId)
    {
        PropertyDTO propertyDTO =  propertyService.updateProperty_desc(productDTO, productId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("/property/{productId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId)
    {
        propertyService.deleteProperty(propertyId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        return responseEntity;
    }


}
