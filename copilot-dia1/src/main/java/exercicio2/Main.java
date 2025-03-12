package exercicio2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Set<LocalDate> holidays = new HashSet<>();
        // Adicione os feriados aqui
        holidays.add(LocalDate.of(2023, 1, 1)); // Exemplo de feriado

        LocalDate startDate = LocalDate.now();
        int businessDaysToAdd = 15;
        LocalDate resultDate = calculateBusinessDays(startDate, businessDaysToAdd, holidays);

        System.out.println("Data final: " + resultDate);
    }

    public static LocalDate calculateBusinessDays(LocalDate startDate, int businessDays, Set<LocalDate> holidays) {
        LocalDate currentDate = startDate;
        int addedDays = 0;

        while (addedDays < businessDays) {
            currentDate = currentDate.plusDays(1);
            if (isBusinessDay(currentDate, holidays)) {
                addedDays++;
            }
        }

        return currentDate;
    }

    public static boolean isBusinessDay(LocalDate date, Set<LocalDate> holidays) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return !(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY || holidays.contains(date));
    }
}

