package net.javaguides.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Adress {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;


    public String city;


    public String streetnumber;


    public String postalcode;
    public  Adress(){}
    public Adress(String city,String streetnumber,String postalcode){
        this.city=city;
        this.postalcode=postalcode;
        this.streetnumber=streetnumber;
    }
    public Adress(long id,String city,String streetnumber,String postalcode){
        this.id=id;
        this.city=city;
        this.postalcode=postalcode;
        this.streetnumber=streetnumber;
    }
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
