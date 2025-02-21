package com.cuspide.LibraryProject.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;

}
