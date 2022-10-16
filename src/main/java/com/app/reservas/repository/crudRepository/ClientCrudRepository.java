package com.app.reservas.repository.crudRepository;

import com.app.reservas.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> { }
