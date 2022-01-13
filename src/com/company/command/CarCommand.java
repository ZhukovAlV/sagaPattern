package com.company.command;

import com.company.entity.RoutingSlip;

public class CarCommand implements Command {

    // Маршрутный лист
    private RoutingSlip rs;

    public CarCommand(RoutingSlip rs) {
        this.rs = rs;
    }

    @Override
    public void executeCommand() {
        System.out.println("Резервируем автомобиль");
    }

    @Override
    public void rollbackCommand() {
        System.out.println("Откатываем заказ на автомобиль к первоначальному состоянию");
    }

    @Override
    public void commitCommand() {
        System.out.println("Транзакция по заказу авто применена");
    }

    @Override
    public RoutingSlip getRs() {
        return rs;
    }
}
