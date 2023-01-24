package entities;

public class Bank {
	private String name;
	private int num_account;
	private double balance;
	
	public Bank() {
		
	}
	
	public Bank(int num_account, String name, double initialBalance) {
		this.num_account = num_account;
		this.name = name;
		// if you change the method, the initialBalance is going to change too
		deposit(initialBalance);
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public int getNum_conta() {
		return num_account;
	}

	public double getSaldo() {
		return balance;
	}

	public void deposit(double money) {
		balance += money;
	}

	public void withdraw(double money) {
		balance -= (money + 5);
	}

	public String toString() {
		return ("Name: " + name + "%nNúmero da conta: " + num_account + "%nSaldo: $ " + String.format("%.2f", balance));
	}

}
