# Справочник автомобилей
Cервис справочника автомобилей с хранением данных, которой позволяет сохранить, удалить, узнать количество автомобилей и вывести весь список
# С помощью программы работник склада имеет возможность:
- сохранить автомобиль;
- удалить автомобиль;
- узнать количество автомобилей;
- вывести весь список.
# Внешний интерфейс приложения представлен в виде REST API.
POST /api/car/files/save сохранить автомобиль по таким парматерам как номер, цвет, марка, год выпуска.
DELETE /api/car/files/delete удалить автомобиль по такому параметру как номер авто.
Get /api/car/files/allCar вывести весь список, который был сохранет (изменен) в последний раз.
Get /api/car/files/sumCar вывести количество автомобилей, которые были сохранены.
# Использован следующий стек технологий:
- Веб-приложение выполнено в виде RESTful-сервиса
- Java11
- SpringBoot
- Swagger
- Lombok
# что можно сделать в дальнейшем:
- В классе Car можно заменить оставить только параметры автомобиля остальное заменить аннтотациями Lombok: @Data, @AllArgsConstructor, @NoArgsConstructor. Для уменьшения количество строк кода
- Подключить БД PostgresSQL
- Добавить тесты (JUnit)
