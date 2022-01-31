package com.example.Some_Coffee_BackEnd.Reservation;

public class Form {
    private Reservation reservation;
    private Long userId;
    private Long tableId;

    public Form() {
    }

    public Form(Reservation reservation, Long userId, Long tableId) {
        this.reservation = reservation;
        this.userId = userId;
        this.tableId = tableId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTableId() {
        return tableId;
    }

}




