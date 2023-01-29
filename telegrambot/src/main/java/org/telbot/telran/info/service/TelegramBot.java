package org.telbot.telran.info.service;
/** class implements methods for telegrambot
 *  @author Natalia Lux
 *  @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBot extends TelegramLongPollingBot implements Switchable {

    private boolean enabled = true;

    @Value(" ")
    private String botName;

    @Value(" ")
    private String token;

    @Autowired
    private CommandService commandService;

    @Autowired
    private MessageService messageService;

    @Override
    public String getBotUsername() {
        return "LuksikBot";
    }

    @Override
    public String getBotToken() {
        return "5945828450:AAEBsFqO3RYS86hM-ZXLITNNAnKU7Nf8_5o";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().isCommand()) {
            commandService.executeCommand(update.getMessage().getText(), this);
            return;
        }

        if (!enabled) {
            return;
        }
        Message message = update.getMessage();
        Chat chat = ((org.telegram.telegrambots.meta.api.objects.Message) message).getChat();
        if (chat.isGroupChat()) {
            Long chatId = message.getChatId();
            String text = message.getText();
            String title = chat.getTitle();
            messageService.create(title, chatId, text);
        }
    }

    @Override
    public void on() {
        enabled = true;
    }

    @Override
    public void off() {
        enabled = false;
    }
}
