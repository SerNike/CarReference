package SerNike.CarModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Модель класса, который имеет:
 *  number - номер автомобиля
 *  marka - марка автомобиля
 *  color - цвет автомобиля;
 *  yearOfRelease - год выпуска автомобиля
 *
 *  контрукторы со всеми параметрами и только с одним параметром (номер автомобиля)
 */
public class Car {
    public Car(String number, String marka, String color, int yearOfRelease) {
        this.number = number;
        this.marka = marka;
        this.color = color;
        this.yearOfRelease = yearOfRelease;
    }
    public Car(String number) {
        this.number = number;
    }

    private String number;

    private String marka;

    private String color;

    private int yearOfRelease;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfRelease == car.yearOfRelease && Objects.equals(number, car.number) && Objects.equals(marka, car.marka) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, marka, color, yearOfRelease);
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", marka='" + marka + '\'' +
                ", color='" + color + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
