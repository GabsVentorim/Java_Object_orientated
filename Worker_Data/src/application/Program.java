package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Workers;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter depatament's name: ");
		String departamentName = in.nextLine();

		System.out.println("Enter worker data:");

		System.out.print("Name: ");
		String workerName = in.nextLine();

		System.out.print("Level: ");
		String workerLevel = in.nextLine();

		System.out.print("Base salary: ");
		double baseSalary = in.nextDouble();

		// obj worker ligado ao obj departamento
		Workers worker = new Workers(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departamentName));

		System.out.print("How many contracts to this worker? ");
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Enter contract #" + (i+1) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(in.next());
			System.out.print("Value per hour: ");
			double valuePerHour = in.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = in.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter month and year ro calculate income (MM/YYYY): ");
		String monthAndYear = in.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		in.close();
	}
}
