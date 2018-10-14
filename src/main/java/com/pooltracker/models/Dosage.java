package com.pooltracker.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Dosage {

    @NotEmpty
    public double gallons;

    public double sodHypo;
    public double calHypo;
    public double trichlor;
    public double sodaAsh;
    public double muriaticAcid;
    public double sodBicarb;
    public double sodBisulf;
    public double calChlor;
    public double cyaAcid;
    public double sodThio;


    public Dosage(double g) {
        gallons = g;
        sodHypo = 10.7 * (gallons/10000);
        calHypo = 2.0 * (gallons/10000);
        trichlor = 1.5 * (gallons/10000);
        sodaAsh = 6 * (gallons/10000);
        muriaticAcid = 12 * (gallons/10000);
        sodBicarb = 1.4 * (gallons/10000);
        sodBisulf = 2.1 * (gallons/10000);
        calChlor = 1.2 * (gallons/10000);
        cyaAcid = 13 * (gallons/10000);
        sodThio = 2.6 * (gallons/10000);

    }

    public Dosage() {}

    public double getGallons() { return gallons; }

    public double getSodHypo() { return sodHypo; }

    public double getCalHypo() { return calHypo; }

    public double getTrichlor() { return trichlor; }

    public double getSodaAsh() { return sodaAsh; }

    public double getMuriaticAcid() { return muriaticAcid; }

    public double getSodBicarb() { return sodBicarb; }

    public double getSodBisulf() { return sodBisulf; }

    public double getCalChlor() { return calChlor; }

    public double getCyaAcid() { return cyaAcid; }

    public double getSodThio() { return sodThio; }

    public void setGallons(double gallons) { this.gallons = gallons; }

    public void setSodHypo(double sodHypo) { this.sodHypo = sodHypo; }

    public void setCalHypo(double calHypo) { this.calHypo = calHypo; }

    public void setTrichlor(double trichlor) { this.trichlor = trichlor; }

    public void setSodaAsh(double sodaAsh) { this.sodaAsh = sodaAsh; }

    public void setMuriaticAcid(double muriaticAcid) { this.muriaticAcid = muriaticAcid; }

    public void setSodBicarb(double sodBicarb) { this.sodBicarb = sodBicarb; }

    public void setSodBisulf(double sodBisulf) { this.sodBisulf = sodBisulf; }

    public void setCalChlor(double calChlor) { this.calChlor = calChlor; }

    public void setCyaAcid(double cyaAcid) { this.cyaAcid = cyaAcid; }

    public void setSodThio(double sodThio) { this.sodThio = sodThio; }
}
