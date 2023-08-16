package SerNike.repository;

import SerNike.CarModel.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * класс репозиторий, который хранить данные приложения
 */
@Repository
public class CarRepositoryImpl implements CarRepository{

    private Map<Car, Integer> carIntegerMap = new HashMap<>();

    private int identifier = 0;


    @Override
    public void save(Car car) {
        carIntegerMap.put(car, identifier++);
    }

    @Override
    public void remove(Car car) {
        if (!carIntegerMap.containsKey(car)) {
            throw new NoSuchElementException("Автомобиль не найден");
        }
        carIntegerMap.remove(car);
    }

    @Override
    public int getAll() {
        return carIntegerMap.size();
    }


    @Override
    public Collection<Car> getList() {
        return carIntegerMap.keySet();
    }
}
