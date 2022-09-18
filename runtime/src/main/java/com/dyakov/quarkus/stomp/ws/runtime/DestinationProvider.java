package com.dyakov.quarkus.stomp.ws.runtime;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.stomp.Destination;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;

public abstract class DestinationProvider {

    private static final Logger log = Logger.getLogger(DestinationProvider.class.getName());

    abstract public String getDestinationPath();

    abstract public void setDestination(Destination destination);

    abstract public Destination getDestination();

    abstract public DestinationType getDestinationType();

    abstract public boolean isDestinationSetUp();

    public static enum DestinationType {
        TOPIC, QUEUE
    }

    public void init(@Observes StartupEvent event) {
        log.debug("Destination provider started: " + this.getClass().getSimpleName());
    }

}
