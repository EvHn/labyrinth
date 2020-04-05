package utils;

import models.IMenu;
import view.IMenuView;

public class ItemProcessor implements IItemProcessor {
    IMenu model;
    IMenuView view;
    public ItemProcessor(IMenu model, IMenuView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void process(String itemName) {
        model.getItem(itemName).ifPresentOrElse(i -> i.execute(), () -> view.show("No such item"));
    }
}
