package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.*;
import entities.enums.WorkerLevel;
public class App {
    public static void main(String[] args) throws ParseException {

        String department, name, level;
        double baseSalary;
        int contracts;


        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter department's name: ");
        department = sc.nextLine();
        System.out.println();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Level: ");
        level = sc.next();

        System.out.print("Base salary: ");
        baseSalary = sc.nextDouble();

        System.out.print("How many contracts to this worker? ");
        contracts = sc.nextInt();
        sc.nextLine();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

        for (int i = 0; i < contracts; i++) {

            System.out.printf("Enter contract %d data%n", i + 1);

            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        System.out.println();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String montAndYear = sc.next();
        int month = Integer.parseInt(montAndYear.substring(0, 2));
        int year = Integer.parseInt(montAndYear.substring(3));
        sc.close();
        System.out.println();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--");
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + montAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
