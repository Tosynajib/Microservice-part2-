package com.dharmycode.user.valueobject;

import com.dharmycode.user.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {

    private Users users;
    private Department department;
}
