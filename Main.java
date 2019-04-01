import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PublisherImplementation pub = new PublisherImplementation();
    }
}

interface PublisherInterface {
    public void RegisterObserver(Observer o);
    public void RemoveObserver(Observer o);
    public void NotifyObservers(Event e);
    Random RandomNumberGenerator = new Random();
}

interface Observer {
    public void notifyObserver(Event e);
}

class PublisherImplementation implements PublisherInterface {
//List of subscribers that PubImp needs to notify
ArrayList Subscribers = new ArrayList<Observer>();
//Add observer object to the list
public void RegisterObserver(Observer o) {
    Subscribers.add(o);
}
//Remove observer from the list
public void RemoveObserver(Observer o) {
    Subscribers.remove(o);
}
//Notify all observers on the list
public void NotifyObservers(Event e) {
    
}
//generates a random Event object, this is called from runSimulation()
private Event GenerateEvent(Integer iter){
    Integer rand = RandomNumberGenerator.nextInt(4999) + 1;
    //creates an event. Iter is the iteration number provided by runSimulation, rand is a random number generated above
    Event myEvent = new Event(iter,rand);
    return myEvent;
}
//Generates 200 Events with the GenerateEvent() method
public void runSimulation(){
    for (Integer i=1;i<=200;i++){
        Event generatedEvent = GenerateEvent(i);
        NotifyObservers(generatedEvent);
    }
}
}

class Event {
    private Integer EventNumber;
    private Integer EventData;

    Event(Integer num, Integer dat){
        EventNumber = num;
        EventData = dat;
    }
    Integer getEventNumber() {
        return EventNumber;
    }
    Integer getEventData() {
        return EventData;
    }
}

class SubscriberOdds implements Observer {
    public void notifyObserver(Event e) {
        if (event.getData % 2 == true)
            System.out.print("Event event.getNumber() is odd: event.getData()");
        else
            return false;
    }
}

class SubscriberEvens implements Observer {
    public void notifyObserver(Event e) {
        if (event.getData % 2== true)
            System.out.print("Event event.getNumber() is even: event.getData()");
        else
            return false;
    }
}

class SubscriberThrees implements Observer {
    public void notifyObserver(Event e) {
        if (event.getData % 3 == true)
            System.out.print("Event event.getNumber() is divisible by 3: event.getData()");
        else
            return false;
    }
}


