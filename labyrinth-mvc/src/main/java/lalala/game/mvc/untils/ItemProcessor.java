package lalala.game.mvc.untils;

import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.view.IMenuView;

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
