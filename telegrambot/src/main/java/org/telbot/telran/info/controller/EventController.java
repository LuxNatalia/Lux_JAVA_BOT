package org.telbot.telran.info.controller;
/** class REST controller for events
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.service.EventServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/events")
public abstract class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @PostMapping
    public void createNewEvents() {
        eventService.createNewEvents();
    }

    @GetMapping
    public List<Event> list() {
        return eventService.list();
    }
}