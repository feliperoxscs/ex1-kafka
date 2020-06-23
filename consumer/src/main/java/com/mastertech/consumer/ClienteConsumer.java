package com.mastertech.consumer;


import com.mastertech.producer.Cliente;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConsumer {

    private static final String CSV_SEPARATOR = ",";
    private List<Cliente> clientes = new ArrayList<Cliente>();

    @KafkaListener(topics = "spec2-felipe-sarmento-1", groupId = "snoopy")
    public void recebeMensagem(@Payload Cliente cliente) {
        clientes.add(cliente);
        writeToCSV(clientes);
        System.out.println("Mensagem recebida:" + cliente.getClienteId() + " " + cliente.getPorta() + " " + cliente.getAcesso());
    }

    private static void writeToCSV(List<Cliente> clientes){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("cliente.csv"), "UTF-8"));
            for (Cliente cliente : clientes) {
                StringBuffer line = new StringBuffer();
                line.append(cliente.getClienteId());
                line.append(CSV_SEPARATOR);
                line.append(cliente.getPorta());
                line.append(CSV_SEPARATOR);
                line.append(cliente.getAcesso());
                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
