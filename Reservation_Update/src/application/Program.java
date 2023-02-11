package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = in.nextInt();
			System.out.print("Check-in date (dd/MM/yyy): ");
			Date checkin = sdf.parse(in.next());
			// needs to add an Exception into the method because of the parse-Date
			System.out.print("Check-out date (dd/MM/yyy): ");
			Date checkout = sdf.parse(in.next());
	
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Revervation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkin = sdf.parse(in.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
			checkout = sdf.parse(in.next());
	
			reservation.updatesoDates(checkin, checkout);
			System.out.println("Reservation " + reservation);
		}
		catch (ParseException e){
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in revervation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		in.close();
	}
}
