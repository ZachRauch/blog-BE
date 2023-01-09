package net.yorksolutions.zachrauchblogcmscapstonebe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long userId;
    public String email;
    public String password;
    public String firstName;
    public String lastName;
}
