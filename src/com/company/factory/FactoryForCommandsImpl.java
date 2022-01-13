package com.company.factory;

import com.company.command.CarCommand;
import com.company.command.Command;
import com.company.command.FlightCommand;
import com.company.command.HotelCommand;
import com.company.entity.RoutingSlip;

public class FactoryForCommandsImpl implements FactoryForCommands {

    @Override
    public Command createCarCommand(RoutingSlip rs) {
        return new CarCommand(rs);
    }

    @Override
    public Command createFlightCommand(RoutingSlip rs) {
        return new FlightCommand(rs);
    }

    @Override
    public Command createHotelCommand(RoutingSlip rs) {
        return new HotelCommand(rs);
    }
}
