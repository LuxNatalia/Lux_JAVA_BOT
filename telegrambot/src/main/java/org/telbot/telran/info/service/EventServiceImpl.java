package org.telbot.telran.info.service;
/** class implements methods for events
 *  @author Natalia Lux
 *  @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.EventRepository;
import org.telbot.telran.info.repository.MessageRepository;
import org.telbot.telran.info.repository.UserChannelRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserChannelService userChannelService;

    @Override
    public void getAllNewMessages() {
    }

    @Scheduled(fixedRate = 60000)
    public void createNewEvents() {
        List<Message> allMessages = messageService.getAllNewMessages();
        Map<Long, List<Message>> channelMap = allMessages.stream().collect(Collectors.groupingBy(Message::getChatId));
        List<UserChannel> userChannelList = userChannelService.getAllByActive();
        Map<Integer, List<UserChannel>> userChannelMap = userChannelList.stream().collect(Collectors.groupingBy(UserChannel::getUserId));
        userChannelMap.forEach((userId, userChannels) -> {
            Event event = new Event();
            event.setUserId(userId);
            StringBuilder sb = new StringBuilder();
            userChannels.stream().map(uc -> uc.getGroupId()).forEach(id -> {
                List<Message> messages = channelMap.get(id);
                messages.stream().forEach(m -> sb.append(m + " / "));
            });
            event.setText(sb.toString());
            eventRepository.save(event);
        });
        markMessagesAsRead(allMessages);
    }

    private void markMessagesAsRead(List<Message> allMessages) {
        allMessages.stream().forEach((m -> m.setUnread(false)));
    }

    @Override
    public List<Event> getNewEventsByUser(User user) {
        List<Event> events = eventRepository.getAllNewByUserId(user.getId());
        markEventsAsOld(events);
        return events;
    }

    @Override
    public List<Event> list() {
        return eventRepository.findAll();
    }

    private void markEventsAsOld(List<Event> events) {
        events.stream().forEach(e -> e.setNew(false));
    }
}
