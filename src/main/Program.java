package main;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String nameString = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		Department department = new Department(nameString, payDay, new Address(email, phone));
		
		for(int i= 1; i <= n; i++) {
			System.out.println("Dados do funcionário "+ i +":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salario: ");
			double salary = sc.nextDouble();
			department.addEmployee(new Employee(name, salary));		
		}
		
		
		showReport(department);
		
		sc.close();
	}

	private static void showReport(Department department) {
		System.out.println("\nFOLHA DE PAGAMENTO:");
		System.out.printf("Departamento Vendas = %.2f%n", department.payroll());
		System.out.printf("Pagamento realizado no dia %d%n", department.getPayDay());
		System.out.println("Funcionários:");
		//department.getEmployees().stream().map(e -> e.getName()).forEach(System.out::println);
		for(Employee employee : department.getEmployees()) {
			System.out.println(employee.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: vendas@lojatop.com");		
	}
}
