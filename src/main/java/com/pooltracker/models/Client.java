package com.pooltracker.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Grier
 */

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private int id;

    @NotNull
    @Size(min=1, message = "Client must have a first name")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min=1, message = "Client must have a last name")
    @Column(name = "last_name")
    private String lastName;

    @Valid
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @Valid
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pool_id")
    private Pool pool;

    @NotNull
    @Size(min=10, max=10, message = "Must be 10 digits only")
    private String phone;

    @NotNull
    @Email(message = "Please enter a valid email")
    private String email;

    @ManyToOne
    private User user;


    public Client(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Client() { }

    public int getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Pool getPool() { return pool; }

    public void setPool(Pool pool) { this.pool = pool; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
