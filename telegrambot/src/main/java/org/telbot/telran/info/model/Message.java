package org.telbot.telran.info.model;
/** class for definition message with fields message_id, title, chat_id, text and is_new
 * @author Natalia Lux
 * @version 1.0
 */
import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    @Column(name = "title")
    private String title;
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "text")
    private String text;
    @Column(name = "is_new")
    boolean unread = true;


    public Message(String title, Long chatId, String text) {
        this.title = title;
        this.chatId = chatId;
        this.text = text;
    }

    public Message(Message message) {
        //
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

}
