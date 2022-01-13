package com.company.command;

import com.company.entity.RoutingSlip;

public class HotelCommand implements Command {

    // Маршрутный лист
    private RoutingSlip rs;

    public HotelCommand(RoutingSlip rs) {
        this.rs = rs;
    }

    @Override
    public void executeCommand() {
        System.out.println("Резервируем отель");
    }

    @Override
    public void rollbackCommand() {
        System.out.println("Откатываем заказ на отель к первоначальному состоянию");
    }

    @Override
    public void commitCommand() {
        System.out.println("Транзакция по заказу отеля применена");
    }

    @Override
    public RoutingSlip getRs() {
        return rs;
    }
}
