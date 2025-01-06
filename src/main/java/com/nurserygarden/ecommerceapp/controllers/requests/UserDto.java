package com.nurserygarden.ecommerceapp.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String password;
    @JsonProperty("user_type_id")
    private Long userTypeId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;

}
