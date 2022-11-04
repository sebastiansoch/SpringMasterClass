package pl.training.shop.payments;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PaymentsStatusChangeEvent extends ApplicationEvent {

    @Getter
    private final Payment payment;

    public PaymentsStatusChangeEvent(Object source, Payment payment) {
        super(source);
        this.payment = payment;
    }
}
