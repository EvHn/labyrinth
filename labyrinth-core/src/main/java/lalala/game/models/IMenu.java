package models;

import controllers.menuitems.IMenuItem;

import java.util.Optional;
import java.util.Set;

public interface IMenu {
    Optional<IMenuItem> getItem(String name);
    Set<String> getItemNames();
    void addItem(String name, IMenuItem item);
    void cleanMenu();
    void deleteItem(String name);
    void registerObserver(IMenuObserver menuObserver);
    void removeObserver(IMenuObserver menuObserver);
}
