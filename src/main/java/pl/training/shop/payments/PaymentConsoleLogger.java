package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Aspect
@Service
@Log
@RequiredArgsConstructor
public class PaymentConsoleLogger {
    private static final String MESSAGES_KEY = "paymentInfo";

    private final MessageSource messageSource;
    @AfterReturning(value = "@annotation(LogPayments)", returning = "payment")
    public void log(Payment payment) {
        log.info(createLogEntry(payment));
    }

    private String createLogEntry(Payment payment) {
        return String.format(MESSAGES_KEY, new String[] {payment.getMoney().toString()}, Locale.getDefault());
    }

}
