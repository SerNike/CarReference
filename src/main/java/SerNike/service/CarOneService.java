package SerNike.service;

import SerNike.CarModel.Car;
import org.springframework.stereotype.Service;
import java.util.Collection;

/**
 * интерфейс, который описывает логику приложения
 */
@Service
public interface CarOneService {

    Car save(Car car);

    void delete(String number);

    Collection<Car> allCar();

    public int sumCar();
}
