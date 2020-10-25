package pl.sda.simple_crud_spring;

public class CarExistsExeption extends RuntimeException{
    public CarExistsExeption(String message) {
        super(message);
    }
}
