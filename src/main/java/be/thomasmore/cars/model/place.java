package be.thomasmore.cars.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class place {
    @Id
    private int id;
    private String stad;
    private String straat;
    private String postcode;
    private String telefoonnumer;
    private String openingsuren;

    public place(String stad, String straat, String postcode, String telefoonnumer, String openingsuren) {
        this.stad = stad;
        this.straat = straat;
        this.postcode = postcode;
        this.telefoonnumer = telefoonnumer;
        this.openingsuren = openingsuren;
    }

    public place() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelefoonnumer() {
        return telefoonnumer;
    }

    public void setTelefoonnumer(String telefoonnumer) {
        this.telefoonnumer = telefoonnumer;
    }

    public String getOpeningsuren() {
        return openingsuren;
    }

    public void setOpeningsuren(String openinigsuren) {
        this.openingsuren = openinigsuren;
    }
}
