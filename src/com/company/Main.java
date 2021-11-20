package com.company;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        // Наш заказ, состоящий из 3 частей: транспорт, команата, место назначения (самолет)
        Queue<Activity> listActivity = new ConcurrentLinkedQueue<>();
        listActivity.add(new ReserveCarActivity());
        listActivity.add(new ReserveHotelActivity());
        listActivity.add(new ReserveFlightActivity());

        // Запускаем наш заказ на отработку
        RoutingSlip routingSlip = new RoutingSlip(listActivity);
        routingSlip.process();

        // отменяем заказ, если не все было выполнено
        if (!routingSlip.isCompleted()) {
            System.out.println("Заказ не был выполнен");
            routingSlip.undo();
        } else {
            System.out.println("Счастливого пути");
        }
    }
}
