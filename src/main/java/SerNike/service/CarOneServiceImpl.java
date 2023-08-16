package SerNike.service;

import SerNike.CarModel.Car;
import SerNike.exception.ValidationException;
import org.springframework.stereotype.Service;
import SerNike.repository.CarRepository;
import java.util.Collection;

@Service
public class CarOneServiceImpl implements CarOneService{
    private final CarRepository carRepository;
    private final CarValidationService carValidationService;

    public CarOneServiceImpl(CarRepository carRepository, CarValidationService carValidationService) {
        this.carRepository = carRepository;
        this.carValidationService = carValidationService;
    }

    @Override
    public Car save(Car car) {
        if (!carValidationService.validation(car)) {
            throw new ValidationException(" ошибка 1");
        }
        carRepository.save(car);
        return car;
    }

    @Override
    public void delete(String number) {
        if (!carValidationService.validationNumber(number)) {
            throw new ValidationException("ошибка 3");
        }
        Collection<Car> carListOne = carRepository.getList();
        for (Car car : carListOne) {
            if (car.getNumber().equals(number)) {
                carRepository.remove(car);
                break;
            } else {
                throw new ValidationException("ошибка 4");
            }
        }
    }

    @Override
    public Collection<Car> allCar() {
        return carRepository.getList();
    }

    @Override
    public int sumCar() {
        return carRepository.getAll();
    }
}

