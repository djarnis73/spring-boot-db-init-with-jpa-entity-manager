package example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Slf4j
public class Initializer {

    @PersistenceContext
    EntityManager em;

    @EventListener(ApplicationStartedEvent.class)
    @Transactional
    public void init(SpringApplicationEvent event) {
        log.info("Initializing db: {}", event);
        for (int i = 0; i < 10; i++) {
            em.merge(new MyEntity());
        }
    }
}
