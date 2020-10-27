package pl.sda.simple_crud_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCar(CarDTO carDTO) {
        if (carWithVinExists(carDTO.getVin())) {
            throw new CarExistsExeption("samochód o takim numerze vin istnieje: "
                    + carDTO.getVin());
        }
        Car car = Car.apply(carDTO);
        carRepository.save(car);
        System.out.println("zapisano Furę!");
    }

    public List<CarDTO> showCarList() {
        return carRepository.findAll().stream()
                .map(e -> e.toDto())
                .collect(Collectors.toList());
    }

    private boolean carWithVinExists(String vin) {
        return carRepository.findByVin(vin).isPresent();
    }

    public CarDTO findCarById(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        return changeCarToCarDTO(car, "nie znaleziono samochodu o danym ID");

    }

    public CarDTO findCarByVin(String vin) {
        Optional<Car> car = carRepository.findByVin(vin);
        return changeCarToCarDTO(car, "nie znaleziono samochodu o danym VIN");

    }

    private CarDTO changeCarToCarDTO(Optional<Car> car, String message) {
        return car.
                map(c -> c.toDto())
                .orElseThrow(() -> new RuntimeException(message));
    }

    public CarDTO updateCar(CarDTO carDTO) {
        Optional<Car> carOptional = carRepository.findById(carDTO.getId());
        Car car = carOptional.orElseThrow(() -> new RuntimeException("nie znaleziono samochodu o danym ID"));
        car.update(carDTO);
        return carRepository.save(car).toDto();

    }
}
