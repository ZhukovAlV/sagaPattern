package com.company;

public interface Activity {
    // Резервируем нужный объект, реализуя в классах, что импелментируют Activity
    void reserve();

    // А здесь проверяем, успешно ли заказ отработал
    boolean check();

    // Откатываем заказ
    boolean rollback();
}
