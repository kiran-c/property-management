package com.mycompany.propertymanagement.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String name;

    @NotNull(message = "this filed is mandatory")
    @NotEmpty(message = "Not be Empty")
    private String email;

    @Size(min = 10 , message = "should be 10 digits")
    private Long phone;
    @Size(min = 5, max = 10)
    private String password;

}
