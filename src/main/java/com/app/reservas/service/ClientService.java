package com.app.reservas.service;

import com.app.reservas.entities.Client;
import com.app.reservas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getById(int id) {
        return clientRepository.getById(id);
    }

    public Client save(Client p) {
        if (p.getIdClient() != null) {
            Optional<Client> e = clientRepository.getById(p.getIdClient());
            if (e.isPresent()){
                return e.get();
            }
            else{
                return clientRepository.save(p);
            }
        } else {
            return clientRepository.save(p);
        }
    }

    public Client update(Client p) {
        if(p.getIdClient() != null) {
            Optional<Client> e = clientRepository.getById(p.getIdClient());
            if (e.isPresent()){
                if(p.getName() != null) {
                    e.get().setName(p.getName());
                }
                if(p.getAge() != null) {
                    e.get().setAge(p.getAge());
                }
                if(p.getPassword() != null) {
                    e.get().setPassword(p.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }
            else{
                return p;
            }
        }
        else {
            return p;
        }
    }

    public boolean delete(int id) {
        boolean res = false;
        Optional<Client> e = clientRepository.getById(id);
        if (e.isPresent()) {
            clientRepository.delete(e.get());
            res = true;
        }
        return res;
    }
}
