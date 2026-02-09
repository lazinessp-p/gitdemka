import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class WorkingWithDatesAndTimes {

    public String getMonthName(int month_number){
        switch (month_number) {
            case 1:  return "January";
            case 2:  return "February";
            case 3:  return "March";
            case 4:  return "April";
            case 5:  return "May";
            case 6:  return "June";
            case 7:  return "July";
            case 8:  return "August";
            case 9:  return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "ошибка: введите число от 1 до 12";
        }
    }

    public static LocalDateTime findMostDistantDates(LocalDateTime[] date_arr) {
        if (date_arr == null || date_arr.length == 0) {
            throw new IllegalArgumentException("массив дат не может быть null или пустым.");
        }

        LocalDateTime current_date = LocalDateTime.now();
        LocalDateTime farthestdate = date_arr[0];
        Duration maximum_difference = Duration.between(current_date, date_arr[0]).abs();

        for (int i = 1; i < date_arr.length; i++) {
            Duration current_difference = Duration.between(current_date, date_arr[i]).abs();
            if (current_difference.compareTo(maximum_difference) > 0) {
                maximum_difference = current_difference;
                farthestdate = date_arr[i];
            }
        }
        return farthestdate;
    }

    public String getLastDayOfMonthFormatted(LocalDate date) {
        if (date == null) {
            return "ошибка: дата не указана";
        }
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM d, yyyy", Locale.ENGLISH);
        return lastDay.format(formatter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkingWithDatesAndTimes processor = new WorkingWithDatesAndTimes();
        System.out.println("впишите номер месяца: ");
        int month_number = scanner.nextInt();
        System.out.println("месяц: " + processor.getMonthName(month_number));
        scanner.nextLine();
        System.out.println("впишите год: ");
        int year = scanner.nextInt();
        System.out.println("количество пятниц 13 в " + year + " году: " + processor.findFriday13ths(year));
        scanner.close();
        LocalDate date = LocalDate.of(2021, 1, 15);
        System.out.println("дата вычислений: " + date);
        System.out.println("последний день месяца: " + processor.getLastDayOfMonthFormatted(date));
        LocalDateTime[] date_now = {
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(10),
                LocalDateTime.now().minusDays(1)
        };
        System.out.println("наиболее удаленная дата от нынешней: " + findMostDistantDates(date_now));
        LocalDateTime now = LocalDateTime.now();
        double hours_before_midnight = processor.calculateHowManyHoursUntilMidnight(now);
        System.out.println("осталось часов до полуночи: " + hours_before_midnight);
    }

    public List<String> findFriday13ths(int year) {
        List<String> results = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                results.add(date.getDayOfMonth() + " " + date.getMonth() + " " + year);
            }
        }
        return results;
    }

    public double calculateHowManyHoursUntilMidnight(LocalDateTime time) {
        if (time == null) {
            throw new IllegalArgumentException("время не может быть null.");
        }
        LocalDateTime midnight_today = LocalDateTime.of(time.toLocalDate(), LocalTime.MIDNIGHT).plusDays(1);
        Duration difference = Duration.between(time, midnight_today);
        double hours = difference.toMinutes() / 60.0;
        return (double) Math.round(hours);
    }

}
