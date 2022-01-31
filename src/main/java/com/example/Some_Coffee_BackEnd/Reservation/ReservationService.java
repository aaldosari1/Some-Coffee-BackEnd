package com.example.Some_Coffee_BackEnd.Reservation;

import com.example.Some_Coffee_BackEnd.CoffeeTable.TableRepository;
import com.example.Some_Coffee_BackEnd.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Some_Coffee_BackEnd.CoffeeTable.CoffeeTable;
import com.example.Some_Coffee_BackEnd.User.User;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final TableRepository tableRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, TableRepository tableRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.tableRepository = tableRepository;

    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservation(String id) {
        Long reservationId = Long.parseLong(id);
        return reservationRepository.findById(reservationId).orElse(null);
    }

    public Reservation addReservation(Reservation reservation, Long userId, Long tableId) {
        User user = (User) userRepository.findById(userId).orElse(null);
        reservation.setUser(user);
        CoffeeTable coffeeTable = (CoffeeTable) tableRepository.findById(tableId).orElse(null);
        reservation.setCoffeeTable(coffeeTable);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(String id) {
        Long reservationId = Long.parseLong(id);
        reservationRepository.deleteById(reservationId);
    }

    public void updateReservation(String id, Reservation data) {
        Long reservationId = Long.parseLong(id);
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);


        if (reservation != null) {
            reservation.setReservationDate(data.getReservationDate());
            reservation.setReservationTime(data.getReservationTime());

            reservationRepository.save(reservation);
        }

    }


}
