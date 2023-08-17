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
		return String.format("First Name is :%s%nLast Name is :%s%nSocial security number is :%s%n",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
}
class CommissionModel {
	
	public double earnings() {
		return 0;
	}
	
}
class CommissionCompensationModel extends CommissionModel{
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
class BasePlusCommissionCompensationModel extends CommissionModel{
	private CommissionCompensationModel compensationEmp;
	private double BaseSalary;
	
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate , double baseSalary) {
		
		this.compensationEmp = new CommissionCompensationModel(grossSales, commissionRate);
		if (BaseSalary < 0)
			throw new IllegalArgumentException ("Base salary must be >= 0.0");
		BaseSalary = baseSalary;
	}
	public BasePlusCommissionCompensationModel(CommissionCompensationModel compensationEmp, double baseSalary) {
	
	
		this.compensationEmp = compensationEmp;
		if (BaseSalary < 0)
			throw new IllegalArgumentException ("Base salary must be >= 0.0");
		BaseSalary = baseSalary;
	}

	public CommissionCompensationModel getCompensationEmp() {
		return compensationEmp;
	}
	public void setCompensationEmp(CommissionCompensationModel compensationEmp) {
		this.compensationEmp = compensationEmp;
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
		return getBaseSalary() + compensationEmp.getCommissionRate() * compensationEmp.getGrossSales();
	}
}

public class Test{
	public static void main(String[] args) {
		
		
	}
}