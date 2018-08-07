package com.pooltracker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "Client must have a first name")
    private String firstName;

    @NotNull
    @Size(min=1, message = "Client must have a last name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "address_id", nullable = false)
    private Address address;

    @NotNull
    @Size(min=10, max=10, message = "10 digits only")
    private String phone;

    public Client(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    //public Pool getPool() { return pool; }

    //public void setPool(Pool pool) { this.pool = pool; }
}
