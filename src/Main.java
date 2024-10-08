import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату через пробел");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");//сплит
        scanner.close(); //закрытие сканнера

        if (parts.length != 6) {
            try {
                throw new Exception("необходимо ввести 6 элементов");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        String surname = parts[0];
        String name = parts[1];
        String middlename = parts[2];
        String birthdate = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];

        long phone;
        try {
            LocalDate dateOfBirth = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd.mm.yyyy"));
            phone = Long.parseLong(phoneNumber);
            if (!gender.equalsIgnoreCase("м") && !gender.equalsIgnoreCase("ж"))
                throw new IllegalArgumentException("введите м или ж");
        } catch (DateTimeParseException e) {
            System.err.println("Дату рождения необходимо ввести в формате дд.мм.гггг");
        } catch (NumberFormatException e) {
            System.err.println("некорректный номер телефона");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
            writer.write(String.format("%s %s %s %s %d %s", surname, name, middlename, birthdate, phone, gender));
        } catch (IOException e) {
            System.err.println("ошибка записи" + e.getMessage());
        }
    }
}







/*import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату через пробел");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 6) {
            try {
                throw new Exception("необходимо ввести 6 элементов");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        String surname = parts[0];
        String name = parts[1];
        String middlename = parts[2];
        String birthdate = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];

        // writeToFile(surname, name, middlename, birthdate, phoneNumber, gender);
        long phone;
        try {
            LocalDate dateOfBirth = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd.mm.yyyy"));
            phone = Long.parseLong(phoneNumber);
            if (!gender.equalsIgnoreCase("м") && !gender.equalsIgnoreCase("ж"))
                throw new IllegalArgumentException("введите м или ж");
        } catch (DateTimeParseException e) {
            System.err.println("Дату рождения необходимо ввести в формате дд.мм.гггг");
        } System.err.println("некорректный номер телефона");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
        writer.write(String.format("%s %s %s %s %d %s", surname, name, middlename, birthdate, phone, gender));
    } catch (IOException e) {
            System.err.println("ошибка записи" + e.getMessage() );
        }
    }
}