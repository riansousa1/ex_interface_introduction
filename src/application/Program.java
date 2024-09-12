package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entitites.Contract;
import entitites.Installment;
import services.ContractService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Entre com os numeros de parcela: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		ContractService contractService = new ContractService(null);
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas: ");
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}
		
		
		
		sc.close();
	}

}
