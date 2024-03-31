package org.example.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {


    // Метод для расчета отпускных с учетом выходных дней
    public double calculateVacationCompensationWithHolidays(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        int workDays = calculateWorkDays(vacationDates);
        return averageSalary / workDays * vacationDays;
    }

    // Вспомогательный метод для расчета рабочих дней
    private int calculateWorkDays(List<LocalDate> vacationDates) {
        int workDays = 365;

        workDays -= vacationDates.size();

        for (LocalDate date : vacationDates) {
            if (date.getDayOfWeek().getValue() >= 6) {
                workDays--;
            }
        }

        return workDays;
    }

}