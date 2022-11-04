package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.shop.orders.Order;
import pl.training.shop.payments.*;
import pl.training.shop.products.Product;
import pl.training.shop.products.ProductsType;

import java.util.List;

@Log
public class Application {

    public static final String BASE_PACKAGE = "pl.training.shop";
    private static final Product VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczyny kurs Spring framework")
            .type(ProductsType.VIDEO)
            .price(LocalMoney.of(799))
            .build();

    private static final Product BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczyne cwiczenia do samodzielnego wykonania")
            .type(ProductsType.BOOK)
            .price(LocalMoney.of(200))
            .build();

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {
            var shopService = applicationContext.getBean(ShopService.class);
            shopService.addProduct(VIDEO_PRODUCT);
            shopService.addProduct(BOOK_PRODUCT);
            log.info(shopService.getProducts(0, 100).toString());

            var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
            shopService.placeOrder(order);
            var payment = shopService.payForOrder(order.getId());
            log.info(payment.getId());
        }
    }
}
/*
            var paymentService = applicationContext.getBean(PaymentService.class);
            var paymentRequest = PaymentRequest.builder()
                    .money(LocalMoney.of(1_000))
                    .build();
            var payment = paymentService.process(paymentRequest);
            log.info(payment.toString());
 */