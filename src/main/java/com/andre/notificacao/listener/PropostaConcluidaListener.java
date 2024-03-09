package com.andre.notificacao.listener;

import com.andre.notificacao.constantes.MensagemConstante;
import com.andre.notificacao.domain.Proposta;
import com.andre.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;
    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaPendente(Proposta proposta) {
        String mensagem = "";
        if (proposta.getAprovada()) {
            mensagem = String.format(MensagemConstante.PROPOSTA_APROVADA, proposta.getUsuario().getNome());
        } else {
            mensagem = String.format(MensagemConstante.PROPOSTA_REPROVADA, proposta.getUsuario().getNome());
        }

        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(),mensagem);
    }
}
