package com.dsantanaleal.windowstools.processes.commands;

import java.util.HashSet;
import java.util.Set;

public final class Command {

    Set<Command> commands = new HashSet<Command>() {{
       add(new Command("tasklist", ""));
       add(new Command("taskkill", ""));
    }};

    private String nombre;
    private String command;

    private Command(String nombre, String command) {
        this.nombre = nombre;
        this.command = command;
    }

}
