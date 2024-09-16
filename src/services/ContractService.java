package services;

import java.time.LocalDate;

import entitites.Contract;
import entitites.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	// geração de parcelas
	
	public void processContract(Contract contract, int months) {
		
		// valor basico de quota
		double basicQuota = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i ++) {
			LocalDate dueDate = contract.getDate().plusMonths(i); // encontra a data um mês depois
			
			double interest = onlinePaymentService.interest(basicQuota, i); // encontra a taxa basica baseada no mês
			double fee = onlinePaymentService.paymentFee(basicQuota + interest); // encontra a taxa fixa
			double totalQuota = basicQuota + interest + fee; // quota total
			
			contract.getInstallments().add(new Installment(dueDate, totalQuota)); // adiciona a nova data e valor na lista 
		}

	}
	
	
}
