package com.company.entity;

public class RoutingSlip {
    // По умолчанию статус заказа false
    boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
