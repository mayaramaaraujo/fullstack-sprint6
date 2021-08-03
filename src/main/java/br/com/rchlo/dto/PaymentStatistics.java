package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Princípio da Substituição de Liskov

public class PaymentStatistics {
	private BigDecimal maximumAmountOfConfirmedPayment;
	private HashMap<PaymentStatus, Long> paymentStatistics = new HashMap<PaymentStatus, Long>();

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return paymentStatistics;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = this.paymentStatistics.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        this.paymentStatistics.put(status, quantity);
    }
}
