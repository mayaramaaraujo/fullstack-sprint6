package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class PaymentStatisticsCalculatorTest {
	
    private PaymentRepository paymentRepository;

    private PaymentStatisticsCalculator paymentStatisticsCalculator;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {    		
    	PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate(allPayments());      

        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("3000.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate(allPayments());

        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CREATED, 1L)
                .containsEntry(PaymentStatus.CONFIRMED, 1L)
                .containsEntry(PaymentStatus.CANCELED, 1L);
    }
    
    List<Payment> allPayments() {
    	List<Payment> allPayments = new ArrayList<Payment>();    	
    	Payment one = new Payment(1234l, new BigDecimal("1000.00"), new Card("mayara", "123456799", YearMonth.of(2021, 12), "123"), PaymentStatus.CREATED);
    	Payment two = new Payment(1234l, new BigDecimal("2000.00"), new Card("mayara", "123456799", YearMonth.of(2021, 12), "123"), PaymentStatus.CANCELED);
    	Payment three = new Payment(1234l, new BigDecimal("3000.00"), new Card("mayara", "123456799", YearMonth.of(2021, 12), "123"), PaymentStatus.CONFIRMED);
    	
    	allPayments.add(one);
    	allPayments.add(two);
    	allPayments.add(three);
    	
    	return allPayments;
    }

}