package com.pooltracker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Kevin Grier
 */

@Entity
@Table(name="pool")
public class Pool {

    @Id
    @GeneratedValue
    @Column(name = "pool_id")
    private int id;

    @NotNull
    @Column(name="gallons")
    private int gallons;

    @NotNull
    @Column(name="filter_mfr")
    private String filterMfr;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "filter_type")
    private FilterType filterType;

    @NotNull
    @Column(name="filter_model")
    private String filterModel;

    @NotNull
    @Column(name="pump_mfr")
    private String pumpMfr;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "pump_hp")
    private PumpHp pumpHp;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "pump_ph")
    private PumpPh pumpPh;

    @NotNull
    @Column(name="pump_model")
    private String pumpModel;

    @OneToOne(mappedBy = "pool" , fetch = FetchType.EAGER)
    public Client client;

    public Pool() { }

    public int getId() { return id; }

    public int getGallons() { return gallons; }

    public void setGallons(int gallons) { this.gallons = gallons; }

    public String getFilterMfr() { return filterMfr; }

    public void setFilterMfr(String filterMfr) { this.filterMfr = filterMfr; }

    public FilterType getFilterType() { return filterType; }

    public void setFilterType(FilterType filterType) { this.filterType = filterType; }

    public String getFilterModel() { return filterModel; }

    public void setFilterModel(String filterModel) { this.filterModel = filterModel; }

    public String getPumpMfr() { return pumpMfr; }

    public void setPumpMfr(String pumpMfr) { this.pumpMfr = pumpMfr; }

    public PumpHp getPumpHp() { return pumpHp; }

    public void setPumpHp(PumpHp pumpHp) { this.pumpHp = pumpHp; }

    public PumpPh getPumpPh() { return pumpPh; }

    public void setPumpPh(PumpPh pumpPh) { this.pumpPh = pumpPh; }

    public String getPumpModel() { return pumpModel; }

    public void setPumpModel(String pumpModel) { this.pumpModel = pumpModel; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

}
