package com.company.command;

import com.company.entity.RoutingSlip;

public class FlightCommand implements Command {

    // Маршрутный лист
    private RoutingSlip rs;

    public FlightCommand(RoutingSlip rs) {
        this.rs = rs;
    }

    @Override
    public void executeCommand() {
        System.out.println("Резервируем рейс");
    }

    @Override
    public void rollbackCommand() {
        System.out.println("Откатываем рейс к первоначальному состоянию");
    }

    @Override
    public void commitCommand() {
        System.out.println("Транзакция по заказу рейса применена");
    }

    @Override
    public RoutingSlip getRs() {
        return rs;
    }
}
