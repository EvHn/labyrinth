package models;

import controllers.menuitems.IMenuItem;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Menu implements IMenu {
    Map<String, IMenuItem> items;
    List<IMenuObserver> observers;

    public Menu(Map<String, IMenuItem> items, List<IMenuObserver> observers) {
        this.items = items;
        this.observers = observers;
    }

    public Optional<IMenuItem> getItem(String name) {
        System.out.println();
        if(items.containsKey(name)) {
            return Optional.of(items.get(name));
        }
        return Optional.empty();
    }

    public Set<String> getItemNames() {
        return items.keySet();
    }

    public void addItem(String name, IMenuItem item) {
        items.put(name, item);
    }

    public void deleteItem(String name) {
        items.remove(name);
    }

    public void registerObserver(IMenuObserver menuObserver) {
        observers.add(menuObserver);
    }

    public void removeObserver(IMenuObserver menuObserver) {
        observers.remove(observers);
    }
}
