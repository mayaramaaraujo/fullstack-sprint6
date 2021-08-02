package br.com.rchlo.main;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import br.com.rchlo.service.PaymentStatisticsCalculator;

import java.util.Map;

public class PaymentsReportMain {

    public static void main(String[] args) {
        var paymentRepository = new PaymentRepository();
        var paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);

        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate(paymentRepository.all());

        System.out.printf("%nMaior pagamento confirmado %.2f %n", paymentStatistics.getMaximumAmountOfConfirmedPayment());

        Map<PaymentStatus, Long> quantidadeDePagamentoPorStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        for (PaymentStatus paymentStatus : quantidadeDePagamentoPorStatus.keySet()) {
            System.out.printf("Quantidade de pagamentos com status '%s': %d %n", paymentStatus, quantidadeDePagamentoPorStatus.get(paymentStatus));
        }
    }

}
