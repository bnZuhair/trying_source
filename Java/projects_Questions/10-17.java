class Employee{
	private String firstName, lastName, socialSecurityNumber;
	private CommissionModel earningModel;

	public Employee(String firstName, String lastName, String socialSecurityNumber, CommissionModel earningModel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.earningModel = earningModel;
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
	public CommissionModel getEarningModel() {
		return earningModel;
	}

	public void setEarningModel(CommissionModel earningModel) {
		this.earningModel = earningModel;
	}

	public double getEarning() {
		return earningModel.earnings();
	}
	
	@Override
	public String toString() {
		return String.format("First Name is :%s%nLast Name is :%s%nSocial security number is :%s%nEarnings is: %.2f$%n%n",
				getFirstName(), getLastName(), getSocialSecurityNumber(), earningModel.earnings());
	}
	
}

interface CommissionModel {
	public abstract double earnings();
}
class SalariedCompensationModel implements CommissionModel {
	private double weeklySalary;
	public double getWeeklySalary() {
		return weeklySalary;
	}
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0) {
			throw new IllegalArgumentException (" salary must be >= 0 ");
		}else
		this.weeklySalary = weeklySalary;
	}
	
	public SalariedCompensationModel(double weeklySalary) {
		if (weeklySalary < 0) {
			throw new IllegalArgumentException (" salary must be >= 0 ");
		}else
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double earnings() {
		return getWeeklySalary();
	}
}

class HourlyCompensationModel implements CommissionModel{
	private double wage, hoursWorked;

	public HourlyCompensationModel( double wage,
			double hoursWorked) {
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
	
	@Override
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
}

class CommissionCompensationModel implements CommissionModel{
	private double grossSales;
	private double commissionRate;
	
	public CommissionCompensationModel(double grossSales, double commissionRate) {
		
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
	
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
}

class BasePlusCommissionCompensationModel implements CommissionModel{
	private double BaseSalary;
	private double grossSales;
	private double commissionRate;
	
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate , double baseSalary) {
		
		if (grossSales < 0)
			throw new IllegalArgumentException ("Gross sales must be >= 0.0");
		if (commissionRate > 1 || commissionRate < 0)
			throw new IllegalArgumentException ("CommissionRate must be > 0 and < 1");
		if (BaseSalary < 0)
			throw new IllegalArgumentException ("Base salary must be >= 0.0");
		BaseSalary = baseSalary;
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

	public double getBaseSalary() {
		return BaseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		if (BaseSalary < 0)
			throw new IllegalArgumentException ("Base salary must be >= 0.0");
		BaseSalary = baseSalary;
	}

	@Override
	public double earnings() {
		return getBaseSalary() + getCommissionRate() * getGrossSales();
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println("before changing");
		Employee[] employee = {
				new Employee("saleh", "Atash", "1", new SalariedCompensationModel(3000.0)),
				new Employee("Mohammad", "Atash", "2", new HourlyCompensationModel(50, 60)),
				new Employee("Ali", "Atash", "3", new CommissionCompensationModel(100_000, 0.05)),
				new Employee("Khaild", "Atash", "4", new BasePlusCommissionCompensationModel(200_000, 0.05, 3000))
		};
		
		for(Employee currentEmployee : employee) {
			System.out.println(currentEmployee);
		}
		
		System.out.println("After changing");
		employee[0].setEarningModel(new HourlyCompensationModel(50, 60));
		employee[1].setEarningModel(new CommissionCompensationModel(100_000, 0.05));
		employee[2].setEarningModel(new BasePlusCommissionCompensationModel(200_000.0, 0.05, 3000.0));
		employee[3].setEarningModel(new SalariedCompensationModel(3000.0));
		
		for(Employee currentEmployee : employee) {
			System.out.println(currentEmployee);
		}
		
	}
}