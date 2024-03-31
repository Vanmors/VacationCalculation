package org.example.controller;

import org.example.service.VacationCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    @Autowired
    VacationCalculatorService vacationCalculatorService;

    @GetMapping("/calculate")
    public double calculateVacationCompensationWithHolidays(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam List<LocalDate> vacationDates,
            @RequestParam List<LocalDate> holidays) {
        return vacationCalculatorService.calculateVacationCompensationWithHolidays(averageSalary, vacationDays, vacationDates, holidays);
    }
}
