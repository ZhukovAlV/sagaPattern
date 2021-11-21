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
        System.out.println("Откатываем заказ на автомобиль к первоначальному состоянию");
        return false;
    }

    @Override
    public boolean commit() {
        System.out.println("Транзакция по заказу авто применена");
        return false;
    }
}
