package com.company;

import java.util.Queue;

public class RoutingSlip {
    private Queue<Activity> queue;

    public RoutingSlip(Queue<Activity> queue) {
        this.queue = queue;
    }

    public boolean isCompleted() {
        // Возвращаем результат (есть что-то в очереди)
        return queue.isEmpty();
    }

    public boolean process() {

        // Если хоть какой-то заказ не был выполнен
        for (Activity activity : queue) {
            activity.reserve();
            if (!activity.check()) return false;
        }

        // Проверяем что все заказы выполнены
        return isCompleted();
    }


    // Откатываем результат
    public void undo()
    {
        // Откатываем все заказы, что были выполнены
        for (Activity activity : queue) {
            if (activity.check())
            activity.rollback();
        }
    }
}
