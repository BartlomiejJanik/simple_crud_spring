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
@GetMapping("/{id}")
    public CarDTO findCarById(@PathVariable Integer id){//przechwyca id z url
        return carService.findCarById(id);

}@GetMapping("/vin/{vin}")
    public CarDTO findCarByVin(@PathVariable String vin){//przechwyca id z url
        return carService.findCarByVin(vin);

}
}
