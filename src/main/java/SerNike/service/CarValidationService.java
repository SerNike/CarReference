package SerNike.service;

import SerNike.CarModel.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarValidationService {
    boolean validation(Car car);

    boolean validationNumber(String number);
}
