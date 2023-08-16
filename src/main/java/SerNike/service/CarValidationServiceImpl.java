package SerNike.service;

import SerNike.CarModel.Car;
import SerNike.exception.ValidationException;
import org.springframework.stereotype.Service;

/**
 * класс который проверяет правильные значения передаются
 */
@Service
public class CarValidationServiceImpl implements CarValidationService{
        @Override
    public boolean validation(Car car) {
            if (car.getNumber() == null
                    && car.getColor() == null
                    && car.getMarka() == null
                    && car.getYearOfRelease() <= 0) {
                throw new ValidationException("значение пустое");
            } else {
                return car.getNumber() != null
                        && car.getColor() != null
                        && car.getMarka() != null
                        && car.getYearOfRelease() > 0;
            }
    }
    @Override
    public boolean validationNumber(String number) {
        if (number == null) {
            throw new ValidationException("значение пустое");
        }
        return number != null;
    }
}
