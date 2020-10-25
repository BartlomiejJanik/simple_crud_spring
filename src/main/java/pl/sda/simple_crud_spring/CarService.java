package pl.sda.simple_crud_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCar(CarDTO carDTO){

        Car car = Car.apply(carDTO);
        carRepository.save(car);
        System.out.println("zapisano Furę!");
    }

    public List<CarDTO> showCarList() {
        return carRepository.findAll().stream()
                .map(e->e.toDto())
                .collect(Collectors.toList());

    }
}
