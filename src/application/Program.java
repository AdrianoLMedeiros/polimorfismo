package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US); // set locale to US
		Scanner sc = new Scanner(System.in); // scanner object

		int n; // number of employees

		System.out.println("Enter the number of employees: "); // read number of employees
		n = sc.nextInt();
		sc.nextLine();
		
		Employee[] employees = new Employee[n]; // array of employees

		for (int i = 0; i < n; i++) { // loop to read employee data
			
			System.out.println("Employee #" + (i+1) + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				employees[i] = new entities.OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
			} else {
				employees[i] = new Employee(name, hours, valuePerHour);
			}

		}
		
		System.out.println();
		System.out.println("PAYMENTS: ");
		for (int i = 0; i < n; i++) {
			System.out.println(employees[i].getName() + " - $ " + String.format("%.2f", employees[i].payment()));
		}	

		sc.close();

	}

}
