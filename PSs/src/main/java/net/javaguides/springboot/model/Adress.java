package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street_number")
    private String streetnumber;

    @Column(name = "postal_code")
    private String postalcode;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {this.city = city;}
    public void setPostalcode(String postalcode) {this.postalcode = postalcode;}
    public void setStreetnumber(String streetnumber) {this.streetnumber = streetnumber;}
    public String getPostalcode() {return postalcode;}
    public String getStreetnumber() {return streetnumber;}

}
