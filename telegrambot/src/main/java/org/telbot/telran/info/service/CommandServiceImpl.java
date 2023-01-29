package org.telbot.telran.info.service;
/**
 * class implements methods for commands
 * @author Natalia Lux
 * @version 1.0
 */

import org.springframework.stereotype.Service;
import org.telbot.telran.info.commands.Command;

@Service
public class CommandServiceImpl implements CommandService {

    @Override
    public void executeCommand(String command, Switchable switchableBot) {
        if (Command.START.getName().equals(command)) {
            switchableBot.on();
        }

        if (Command.STOP.getName().equals(command)) {
            switchableBot.off();
        }
    }
}
