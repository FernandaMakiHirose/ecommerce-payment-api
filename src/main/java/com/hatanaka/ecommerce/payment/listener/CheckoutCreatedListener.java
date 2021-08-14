package com.hatanaka.ecommerce.payment.listener;

import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.hatanaka.ecommerce.payment.entity.PaymentEntity;
import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import com.hatanaka.ecommerce.payment.service.PaymentService;
import com.hatanaka.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

// fica escutando o input e o output 

@Component // cria a instância
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    private final PaymentService paymentService;

    // vai processar o CheckoutProcessor.INPUT
    @StreamListener(CheckoutProcessor.INPUT)

    // método que processa a mensagem
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
        log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);

        // cria o evento 
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();

        // caso contrário gera um novo estado de solicitação
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()

        // adiciona o código e o pagamento e faz o build
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();

        // envia uma mensagem por output e faz o build
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
