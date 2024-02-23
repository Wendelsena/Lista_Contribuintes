package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyPayer;
import entities.IndividualPayer;
import entities.Payer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Payer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company? (i/c): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();

			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				list.add(new IndividualPayer(name, annualIncome, healthExpenditures));
			}
			if (ch == 'c') {
				System.out.print("Number of Employees: ");
				int employee = sc.nextInt();

				list.add(new CompanyPayer(name, annualIncome, employee));
			}
		}

		double totalTaxes = 0.0;
		System.out.println();
		System.out.println("------------------");
		System.out.println("TAXES PAID:");
		for (Payer pay : list) {
			double tax = pay.taxesPaid();
			System.out.print(pay.getName());
			System.out.printf(": $%.2f\n", tax);
			totalTaxes += pay.getAnnualIncome();
		}

		System.out.printf("\nTOTAL TAXES: $%.2f", totalTaxes);

		sc.close();

	}

}
