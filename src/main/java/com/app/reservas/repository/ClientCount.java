package com.app.reservas.repository;

import com.app.reservas.entities.Client;

public class ClientCount {
    private Client client;
    private Long total;


    public ClientCount(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
