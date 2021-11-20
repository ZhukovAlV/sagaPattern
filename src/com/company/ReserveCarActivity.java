package com.company;

public class ReserveCarActivity implements Activity {
    // По умолчанию статус заказа false
    boolean status = false;

    @Override
    public void reserve() {
        System.out.println("Резервируем автомобиль");
        status = true;
    }

    @Override
    public boolean check() {
        return status;
    }

    @Override
    public boolean rollback() {
        System.out.println("Откатываем заказ к первоначальному состоянию");
        return false;
    }
}