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
   public  ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
        PropertyDTO dto  =  propertyService.saveProperty(propertyDTO);



        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/property")
    public  ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList =  propertyService.getAllProperties();


        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PutMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO productDTO, @PathVariable("propertyId") Long productId)
    {
         PropertyDTO dto =  propertyService.updateProperty(productDTO, productId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PatchMapping("/property/property_desc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO productDTO, @PathVariable("propertyId") Long productId)
    {
        PropertyDTO propertyDTO =  propertyService.updateProperty_desc(productDTO, productId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }

    @DeleteMapping("/property/{productId}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long propertyId)
    {
        propertyService.deleteProperty(propertyId);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
