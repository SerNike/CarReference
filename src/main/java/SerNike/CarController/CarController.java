package SerNike.CarController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import SerNike.CarModel.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import SerNike.service.CarOneService;

import java.util.Collection;

/**
 * Контроллеры для:
 * сохранения
 * удаления
 * количество авто в базе данных
 * список всех авто, которые есть в базе данных
 */
@RestController
@RequestMapping("/api/car/files")
@Tag(name = "API для справочника автомобилей", description = "действия с авто")
public class CarController {

    private final CarOneService carOneService;

    public CarController(CarOneService carOneService) {
        this.carOneService = carOneService;
    }

    @PostMapping("/save")
    @Operation(
            summary = "Сохранение автомобиля"
    )
    @ApiResponse(
            responseCode = "200",
            description = "операция успешна авто сохранилось в базе данных"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "внутрения ошибка приложения"
    )
    public ResponseEntity<Car> login(@RequestBody Car car) {
        try {
             return ResponseEntity.ok(carOneService.save(car));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "удаления автомобиля"
    )
    @ApiResponse(
            responseCode = "200",
            description = "операция успешна авто удалено"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "внутрения ошибка приложения"
    )
    public ResponseEntity<Void> deleteCar(@RequestParam String number) {
        try {
            carOneService.delete(number);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allCar")
    @Operation(
            summary = "все автомобили"
    )
    @ApiResponse(
            responseCode = "200",
            description = "операция успешна список авто выведено"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "внутрения ошибка приложения"
    )
    public ResponseEntity<Collection<Car>> allCar() {
        try {
            return ResponseEntity.ok(carOneService.allCar());
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/sumCar")
    @Operation(
            summary = "количевство авто"
    )
    @ApiResponse(
            responseCode = "200",
            description = "операция успешна на экран выведено количество автомобилей"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "внутрения ошибка приложения"
    )
    public ResponseEntity<Integer> sumCar() {
        try {
            Integer a = carOneService.sumCar();
            return ResponseEntity.ok(a);
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
