package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Register_Employees;

public class main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		System.out.print("How many employees will be register: ");
		int n = in.nextInt();

		List<Register_Employees> list = new ArrayList<>();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1));
			System.out.print("Id: ");
			int id = in.nextInt();
			in.nextLine();
			System.out.print("Name: ");
			String name = in.nextLine();
			System.out.print("Salary: ");
			Double salary = in.nextDouble();
			list.add(new Register_Employees(id, name, salary));
			System.out.println();

		}

		System.out.print("Enter the employee id that will have a salary increase: ");
		int id = in.nextInt();
		
		
		Register_Employees pos = list.stream().filter(x->x.getId() == id).findFirst().orElse(null); // case 1
		// or 
		//Integer pos = find(list, id); // case 2
		
		if (pos != null) {
			System.out.print("Enter the percentage: ");
			double raise = in.nextDouble();
			 pos.raise(raise); // case 1
			// or 
			//list.get(pos).raise(raise); // case 2
		} else {
			System.out.println("This id does not exist!");
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Register_Employees obj : list) {
			System.out.println(obj.toString());
		}

		in.close();
	}

	public static Integer find(List<Register_Employees> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
