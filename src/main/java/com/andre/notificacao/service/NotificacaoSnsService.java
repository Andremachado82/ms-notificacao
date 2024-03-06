package com.andre.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

    @Autowired
    private AmazonSNS amazonSNS;
    public void notificar(String telefone, String mensagem) {
//        PublishRequest publishRequest = new PublishRequest()
//                .withMessage(mensagem)
//                .withPhoneNumber(telefone);
//        amazonSNS.publish(publishRequest);
    }
}
