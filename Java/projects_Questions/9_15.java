class Employee{
	private String firstName, lastName, socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String toString() {
		return String.format("First Name is :%s%nLast Name is :%s%nSocial security number is :%s%n",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
}
class CommissionEmployee extends Employee{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (grossSales < 0)
			throw new IllegalArgumentException ("Gross sales must be >= 0.0");
		if (commissionRate > 1 || commissionRate < 0)
			throw new IllegalArgumentException ("CommissionRate must be > 0 and < 1");
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if (grossSales < 0)
			throw new IllegalArgumentException ("Gross sales must be >= 0.0");
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if (commissionRate > 1 || commissionRate < 0)
			throw new IllegalArgumentException ("CommissionRate must be > 0 and < 1");
		this.commissionRate = commissionRate;
	}
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	@Override
	public String toString() {
		return String.format("%sGross sales is :%f%nCommission rate is :%f%nEearnings is :%f", super.toString(),
				getGrossSales(), getCommissionRate(), earnings());
	}
	
}
class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		
		if (baseSalary < 0)
			throw new IllegalArgumentException ("baseSalary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0)
			throw new IllegalArgumentException ("baseSalary must be >= 0.0");
		this.baseSalary = baseSalary;
	}
	
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}
	
	@Override
	public String toString() {
		return String.format("%sBase salary is :%f%nEearnings is :%f", super.toString(),
				getBaseSalary(),  earnings());
	}
	
}
class HourlyEmployee extends Employee{
	double wage, hoursWorked;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage,
			double hoursWorked) {
		super(firstName, lastName, socialSecurityNumber);
		if (wage < 0)
			throw new IllegalArgumentException ("wage must be >= 0");
		
		this.wage = wage;
		
		if (hoursWorked < 0 || hoursWorked > 168)
			throw new IllegalArgumentException ("hours worked  must be >= 0 and < 168");
		this.hoursWorked = hoursWorked;
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage < 0)
			throw new IllegalArgumentException ("wage must be >= 0");
		this.wage = wage;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		if (hoursWorked < 0 || hoursWorked > 168)
			throw new IllegalArgumentException ("hours worked  must be >= 0 and < 168");
		this.hoursWorked = hoursWorked;
	}
	
	public double earnings() {
		int normalHourse = 40;
		double improvedWage = 1.5;
		
		if (getHoursWorked() < normalHourse )
			return getHoursWorked() * getWage();
		
		
		else if (getHoursWorked() > normalHourse )
			return (normalHourse * getWage()) + ((getHoursWorked() - normalHourse) * (improvedWage * getWage()));
		else 
			return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%sTotal hourse worked is :%.2f%nEearnings is :%.2f", super.toString(),
				getHoursWorked(),  earnings());
	}
	
}
	
public class Test{
	public static void main(String[] args) {
		HourlyEmployee me = new HourlyEmployee("Saleh", "Atash", "1", 75, 60);
		System.out.printf("Employee information obtained by get methods:%nFirstName is: %s%nsName is: %s%nSecurity number is: %s%n"
				+"Total hourse is: %.2f%nEarnings is: %.2f%n%n%n",
				me.getFirstName(), me.getLastName(),me.getSocialSecurityNumber(),  me.getHoursWorked(), me.earnings());

			
		System.out.println("Employy information obtained by toString method\n"+ me);
		
	}
}