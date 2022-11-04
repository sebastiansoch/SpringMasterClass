package pl.training.shop.payments;

import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Log
public class PaymentStatusChangeListener {

    @Async
    @EventListener
    public void pnPaymentStatusChange(PaymentsStatusChangeEvent statusChangeEvent) {
        log.info("Payment changed status: " + statusChangeEvent.getPayment());
    }
}
