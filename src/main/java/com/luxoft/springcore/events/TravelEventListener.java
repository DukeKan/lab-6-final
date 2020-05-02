package com.luxoft.springcore.events;

import com.luxoft.springcore.objects.City;
import com.luxoft.springcore.objects.Person;
import com.luxoft.springcore.travel.Connection;
import com.luxoft.springcore.travel.TravellingOpportunities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TravelEventListener {

    @Autowired
    private TravellingOpportunities travellingOpportunities;

    @EventListener
    public void arrivalToDestination(TravelEvent travelEvent) {
        Person person = travelEvent.getPerson();
        City source = person.getCity();
        City destination = travelEvent.getTravellingDestination();

        Optional<Connection> possibleConnection = travellingOpportunities.getConnection(source, destination);
        possibleConnection.ifPresent(connection -> {
            int distanceTravelled = person.getDistanceTravelled();
            distanceTravelled += connection.getDistance();
            person.setDistanceTravelled(distanceTravelled);
        });
    }

}
