package com.company.command;

import com.company.entity.RoutingSlip;

public interface Command
{
    void executeCommand();
    void rollbackCommand();
    void commitCommand();
    RoutingSlip getRs();
}

