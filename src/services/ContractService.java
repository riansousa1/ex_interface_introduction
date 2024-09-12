package services;

import entitites.Contract;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	// geração de parcelas
	
	public void processContract(Contract contract, int months) {
		
	}
	
	
}
