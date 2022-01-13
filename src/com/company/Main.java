package com.company;

import com.company.command.Command;
import com.company.entity.RoutingSlip;
import com.company.factory.FactoryForCommands;
import com.company.factory.FactoryForCommandsImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static FactoryForCommands factory = new FactoryForCommandsImpl();

    public static void main(String[] args) {

        // Создаем 2 маршрутных листа
        RoutingSlip firstRoutingSlip = new RoutingSlip();
        RoutingSlip secondRoutingSlip = new RoutingSlip();

        // Добавляем в каждом маршрутном листе команды (резервирования машины, рейса, отеля)
        ArrayList<Command> commands = new ArrayList<>();
        addCommands(commands, firstRoutingSlip);
        addCommands(commands, secondRoutingSlip);

        // Массив для маршрутных листов, которые потребуется отменить
        ArrayList<RoutingSlip> compensationCommands = new ArrayList<>();

        // Выполняем команды для каждого маршрутного листа (в нашем примере для 2 маршрутных листов)
        for (Command command : commands) {
            // Если в результате выполнения комманд хоть какая-то не выполнилась, бракуем данный маршрутный лист
            try {
                command.executeCommand();
            } catch (Exception e) {
                e.getStackTrace();
                compensationCommands.add(command.getRs());
            }
        }

        // Утверждаем (коммитим) результат для корректных команд и отменяем для некорректных
        for (Command command : commands) {
            if (!compensationCommands.contains(command.getRs())) command.commitCommand();
                else command.rollbackCommand();
        }
    }

    public static void addCommands(List<Command> commands, RoutingSlip rs){
        commands.add(factory.createCarCommand(rs));
        commands.add(factory.createFlightCommand(rs));
        commands.add(factory.createHotelCommand(rs));
    }
}
