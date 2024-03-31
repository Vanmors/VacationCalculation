## Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Минимальные требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

1. [Controller](./src/main/java/org/example/controller/VacationController.java) с GET мтодом
2. [Service](./src/main/java/org/example/service/VacationCalculatorService.java) с логикой вычисления отпускных
3. [Тесты](./src/test/java/VacationCalculatorServiceTest.java) на service 