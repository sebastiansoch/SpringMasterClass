package pl.training.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.training.shop.orders.OrderService;
import pl.training.shop.payments.PaymentService;
import pl.training.shop.products.ProductService;

@EnableAspectJAutoProxy
@Configuration
public class ShopConfiguration {

    @Bean
    public ShopService shopService(OrderService orderService, PaymentService paymentService, ProductService productService) {
        return new ShopService(orderService, paymentService, productService);
    }

}
