package entities;

public class IndividualPayer extends Payer {

	private Double healthExpenditures;

	public IndividualPayer() {

	}

	public IndividualPayer(String name, Double totalIncome, Double healthExpenditures) {
		super(name, totalIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxesPaid() {
		if (getAnnualIncome() < 20000.0) {
			return getAnnualIncome() * 0.15 - healthExpenditures * 0.5;
		} else {
			return getAnnualIncome() * 0.25 - healthExpenditures * 0.5;
		}
	}

}
