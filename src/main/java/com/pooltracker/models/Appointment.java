package com.pooltracker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Kevin Grier
 */

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "appointment_id")
    private int id;

    @NotNull
    @Size(min=1, message = "Appointment must have a title")
    @Column(name = "appointment_title")
    private String title;

    @NotNull
    @Size(min=1, message = "Appointment must have a description")
    @Column(name = "description", length = 500)
    private String description;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name="app_time")
    private String appTime;

    @Column(name = "completed")
    private boolean completed = false;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Appointment() { }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getAppTime() { return appTime; }

    public void setAppTime(String appTime) { this.appTime = appTime; }

    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) { this.completed = completed; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }
}
