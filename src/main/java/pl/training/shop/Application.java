package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.shop.payments.*;

@Log
public class Application {

    public static final String BASE_PACKAGE = "pl.training.shop";
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {
            var paymentService = applicationContext.getBean(LoggingPaymentService.class);
            var paymentRequest = PaymentRequest.builder()
                    .money(LocalMoney.of(1_000))
                    .build();
            var payment = paymentService.process(paymentRequest);
            log.info(payment.toString());
        }
/*
        var paymentIdGenerator = new IncrementalPaymentIdGenerator();
        var fakePaymentService = new FakePaymentService(paymentIdGenerator);
        var paymentService = new LoggingPaymentService(fakePaymentService);
        var paymentRequest = PaymentRequest.builder()
                .money(LocalMoney.of(1_000))
                .build();
        var payment = paymentService.process(paymentRequest);
        log.info(payment.toString());
*/
    }
}
