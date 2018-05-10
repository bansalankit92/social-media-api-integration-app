package com.codevik.socialmediaapiintegration.model;


import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Getter
@Setter
public class User    {
    @Id
    private long id;
    private String name;
    private long mobileNo;
    private String emailId;
    private String otp;
    private String referralId;
    @DBRef
    private Set<User> users;







}
