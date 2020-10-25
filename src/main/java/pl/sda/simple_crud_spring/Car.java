package pl.sda.simple_crud_spring;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Integer id;
    private String model;
    private String vin;
    @Enumerated
    private Colour colour;//fixme!!

    public Car() {
    }

    public Car(String model, String vin, Colour colour) {

        this.model = model;
        this.vin = vin;
        this.colour = colour;
    }
}
