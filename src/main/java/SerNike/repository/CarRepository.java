package SerNike.repository;

import SerNike.CarModel.Car;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepository {

    void save(Car car);

    void remove(Car car);

    int getAll();

    Collection<Car> getList();


}
