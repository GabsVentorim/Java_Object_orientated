package entities;

public class Register_Employees {
	private Integer id;
	private String name;
	private Double salary;

	public Register_Employees(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}
	
	public void raise(double raise) {
		this.salary = (salary * raise / 100) + salary;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", salary: $ " + salary;
	}
	
	
}
