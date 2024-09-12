package services;

public interface OnlinePaymentService {
	
	 // taxa de pagamento
	 double paymentFee(double amount);
	 
	 // juro simples mensal
	 double interest(double amount, int months);
}
