package com.mastertech.producer;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClienteProducer {

    @Autowired
    private KafkaTemplate<String, Cliente> clienteKafkaTemplate;


    public void enviaKafka(Cliente cliente) {
        clienteKafkaTemplate.send("spec2-felipe-sarmento-1", cliente);
    }
}
