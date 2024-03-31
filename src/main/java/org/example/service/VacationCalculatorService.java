package org.example.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {


    // Метод для расчета отпускных с учетом праздников и выходных дней
    public double calculateVacationCompensationWithHolidays(double averageSalary, int vacationDays, List<LocalDate> vacationDates, List<LocalDate> holidays) {
        int workDays = calculateWorkDays(vacationDates, holidays);
        return averageSalary / workDays * vacationDays;
    }

    // Вспомогательный метод для расчета рабочих дней
    private int calculateWorkDays(List<LocalDate> vacationDates, List<LocalDate> holidays) {
        int workDays = 365 - holidays.size();

        workDays -= vacationDates.size();

        for (LocalDate date : vacationDates) {
            if (date.getDayOfWeek().getValue() >= 6) {
                workDays--;
            }
        }

        return workDays;
    }

}