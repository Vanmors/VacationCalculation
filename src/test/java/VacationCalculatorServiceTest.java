package org.example.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacationCalculatorServiceTest {

    private final VacationCalculatorService service = new VacationCalculatorService();

    @Test
    void calculateVacationCompensationWithHolidays() {
        double averageSalary = 50000;
        int vacationDays = 20;
        List<LocalDate> vacationDates = Arrays.asList(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 2));
        List<LocalDate> holidays = Arrays.asList(LocalDate.of(2023, 7, 4), LocalDate.of(2023, 7, 5));

        // Расчет количества рабочих дней с учетом праздников и выходных
        int workDays = 365 - holidays.size() - vacationDates.size();
        for (LocalDate date : vacationDates) {
            if (date.getDayOfWeek().getValue() >= 6) {
                workDays--;
            }
        }

        double expectedCompensation = averageSalary / workDays * vacationDays;
        double actualCompensation = service.calculateVacationCompensationWithHolidays(averageSalary, vacationDays, vacationDates, holidays);
        assertEquals(expectedCompensation, actualCompensation);
    }
}
