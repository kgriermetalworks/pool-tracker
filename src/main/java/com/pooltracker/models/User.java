package com.pooltracker.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotEmpty
    private String business;

    @NotEmpty
    @Email(message = "Invalid Email Address")
    @Column(name="user_email")
    private String email;

    @NotNull
    @Size(min = 8, message = "Password Must Be A Minimum Of 8 Characters Long")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Client> clients = new ArrayList<>();

    public User(){ }

    public String getBusiness() { return business; }

    public void setBusiness(String business) { this.business = business; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getId() { return id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Client> getClients() { return clients; }
}
