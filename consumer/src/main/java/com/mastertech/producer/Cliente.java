package com.mastertech.producer;

import java.util.Random;

public class Cliente {

    private Long clienteId;
    private Boolean acesso;
    private Long porta;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(Boolean acesso) {
        this.acesso = acesso;
    }

    public Long getPorta() {
        return porta;
    }

    public void setPorta(Long porta) {
        this.porta = porta;
    }
}
