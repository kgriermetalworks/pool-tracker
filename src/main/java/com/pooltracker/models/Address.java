package com.pooltracker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kevin Grier
 */

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private int id;

    @NotNull
    @Size(min=1, message = "Can not be empty")
    @Column(name = "street")
    private String street;

    @NotNull
    @Size(min=1, message = "Can not be empty")
    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @NotNull
    @Size(min=5, max=5, message = "Invalid")
    @Column(name = "zip_code")
    private String zipCode;

//  @OneToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy = "address")
    @OneToOne(mappedBy = "address" , fetch = FetchType.EAGER) // jf added this
    //@JoinColumn(name = "client_id")  // jf added this
    public Client client;

    public Address() { }

    public int getId() { return id; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public State getState() { return state; }

    public void setState(State state) { this.state = state; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }
}
