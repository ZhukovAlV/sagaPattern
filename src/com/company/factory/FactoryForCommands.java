package com.company.factory;

import com.company.command.Command;
import com.company.entity.RoutingSlip;

public interface FactoryForCommands
{
    Command createCarCommand(RoutingSlip rs);
    Command createFlightCommand(RoutingSlip rs);
    Command createHotelCommand(RoutingSlip rs);
}

