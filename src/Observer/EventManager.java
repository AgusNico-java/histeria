package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {
    private HashMap<String, List<Observer>> observers = new HashMap<>();

    public void subscribe(String eventType, Observer observer) {
        observers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
    }

    public void notify(String eventType) {
        List<Observer> eventObservers = observers.get(eventType);
        if (eventObservers != null) {
            for (Observer observer : eventObservers) {
                observer.update(eventType);
            }
        }
    }
}
