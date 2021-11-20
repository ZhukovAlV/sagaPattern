package com.company;

public class ReserveHotelActivity implements Activity {
    // По умолчанию статус заказа false
    boolean status = false;

    @Override
    public void reserve() {
        System.out.println("Резервируем отель");
        status = true;
    }

    @Override
    public boolean check() {
        return status;
    }

    @Override
    public boolean rollback() {
        System.out.println("Откатываем заказ на отель к первоначальному состоянию");
        return false;
    }
}
