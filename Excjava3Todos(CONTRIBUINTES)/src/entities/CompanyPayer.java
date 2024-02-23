package entities;

public class CompanyPayer extends Payer {

	private Integer employee;

	public CompanyPayer() {
		super();
	}

	public CompanyPayer(String name, Double totalIncome, Integer employee) {
		super(name, totalIncome);
		this.employee = employee;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	@Override
	public Double taxesPaid() {
		if (employee > 10) {
			return getAnnualIncome() * 0.14;
		}
		else {
			return getAnnualIncome() * 0.16;
		}
	}
}


