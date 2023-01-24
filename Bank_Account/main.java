package curso_udemy;

import java.util.Locale;
import java.util.Scanner;

import entities.Bank;

public class Main {
	public static void main(System[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		System.out.println("Enter account number: ");
		int num_account = in.nextInt();
		System.out.println("Enter account holder: ");
		in.nextInt();
		String name = in.nextLine();
		System.out.println("Is there an initial deposit [y/n]: ");
		char response = in.next().charAt(0);
		double money = 0;
		if ((response == 'y') || (response == 'Y')) {
			System.out.println("Enter initial deposit value");
		}
		Bank account = new Bank(num_account, name, money);

		System.out.println(account.toString());

		System.out.println("Enter a deposit value: ");
		money = in.nextDouble();
		account.deposit(money);
		System.out.println("Update account data: " + account.toString());

		System.out.println("Enter a withdraw value: ");
		money = in.nextDouble();
		account.withdraw(money);
		System.out.println("Update account data: " + account.toString());

		in.close();
	}

}
