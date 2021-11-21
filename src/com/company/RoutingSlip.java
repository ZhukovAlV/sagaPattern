package com.company;

import java.util.Queue;

public class RoutingSlip {
    private Queue<Activity> queue;

    public RoutingSlip(Queue<Activity> queue) {
        this.queue = queue;
    }

    // Проверяем, что хоть какой-то заказ не был зарезервирован
    public boolean process() {

        for (Activity activity : queue) {
            activity.reserve();
            if (!activity.check()) return false;
        }

        return true;
    }


    // Откатываем результат
    public void undo() {

        // Откатываем все заказы, что были выполнены
        for (Activity activity : queue) {
            if (activity.check())
            activity.rollback();
        }
    }

    // Коммитим результат
    public void commit() {

        // Применяем все заказы, что были зарезервированы
        for (Activity activity : queue) {
            activity.commit();
        }
    }
}
