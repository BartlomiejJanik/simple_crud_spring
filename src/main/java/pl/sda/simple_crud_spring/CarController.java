package pl.sda.simple_crud_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public void addCar(@RequestBody CarDTO carDTO) {
        carService.addCar(carDTO);
    }

@GetMapping
    public List<CarDTO> showCarList(){
        return carService.showCarList();
}
}
