package com.company;

import java.util.Queue;

public class RoutingSlip {
    private Queue<Activity> queue;

    public RoutingSlip(Queue<Activity> queue) {
        this.queue = queue;
    }

    // Проверяем, что хоть какой-то заказ не был выполнен
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
}
