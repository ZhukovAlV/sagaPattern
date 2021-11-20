package com.company;

public class ReserveFlightActivity implements Activity {
    // По умолчанию статус заказа false
    boolean status = false;

    @Override
    public void reserve() {
        System.out.println("Резервируем рейс");
        status = true;
    }

    @Override
    public boolean check() {
        return status;
    }

    @Override
    public boolean rollback() {
        System.out.println("Откатываем рейс к первоначальному состоянию");
        return false;
    }
}
