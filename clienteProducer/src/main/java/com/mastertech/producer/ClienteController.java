package com.mastertech.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteProducer clienteProducer;

    @GetMapping("/acesso/{cliente}/{porta}")
    public void verificaAcesso(@PathVariable Long cliente, @PathVariable Long porta) {
        clienteProducer.enviaKafka(new Cliente(cliente, porta));
    }

}
