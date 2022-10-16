package com.app.reservas.repository.crudRepository;

import com.app.reservas.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> getByClient();

    public List<Reservation> getByDate(Date dtStart, Date dtFinish);

    public List<Reservation> getByStatus (String status);
}

