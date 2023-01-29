package org.telbot.telran.info.service;
/** interface for command
 * @author Natalia Lux
 * @version 1.0
 */
public interface CommandService {

    void executeCommand(String command, Switchable switchableBot);

}
