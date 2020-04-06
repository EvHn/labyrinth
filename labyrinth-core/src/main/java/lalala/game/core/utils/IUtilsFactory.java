package lalala.game.core.utils;

import lalala.game.core.models.IMenu;
import lalala.game.core.view.IMenuView;

public interface IUtilsFactory {
    IDataLoader createDataLoader();
    IItemProcessor createItemProcessor(IMenu model, IMenuView menuView);
}
