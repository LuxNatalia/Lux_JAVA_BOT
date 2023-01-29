package org.telbot.telran.info.commands;

/**
 *a class enum for defining commands
 * @author Natalia Lux
 * @version 1.0
 */
public enum Command {
    /** command start bot */
    START("/start"),
    /** command stop bot */
    STOP("/stop");

    private String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
