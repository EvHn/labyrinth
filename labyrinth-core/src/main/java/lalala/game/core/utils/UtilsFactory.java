package lalala.game.core.utils;

import lalala.game.core.models.IMenu;
import lalala.game.core.view.IMenuView;

public class UtilsFactory implements IUtilsFactory {
    @Override
    public IDataLoader createDataLoader() {
        return new LocalDataLoader();
    }

    @Override
    public IItemProcessor createItemProcessor(IMenu model, IMenuView view) {
        return new ItemProcessor(model, view);
    }
}
