package pl.sda.simple_crud_spring;

import javax.persistence.Enumerated;

public class CarDTO { //Data transfer object

    private Integer id;
    private String model;
    private String vin;
    private String colour;

    public CarDTO(Integer id, String model, String vin, String colour) {
        this.id = id;
        this.model = model;
        this.vin = vin;
        this.colour = colour;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public String getColour() {
        return colour;
    }
}
