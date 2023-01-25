package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Booking;

public class Programa {
	public static void main(final String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		System.out.println("How mamy rooms will be rented: ");
		int num = in.nextInt();

		Booking[] v = new Booking[10];

		for (int i = 1; i <= num; i++) {
			System.out.println();
			System.out.println("Rent #" + i + ": ");

			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();

			System.out.print("Email: ");
			String email = in.next();

			System.out.print("Room: ");
			int room = in.nextInt();

			v[room] = new Booking(name, email);
		}
		
		System.out.println();
		System.out.println("Busy rooms:");
		for (int i = 0; i < 10; i++) {
			if (v[i] != null) {
				System.out.println(i + ": " + v[i].toString());
			}
		}

		in.close();
	}
}
