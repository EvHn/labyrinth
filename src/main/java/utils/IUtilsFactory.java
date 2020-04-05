package utils;

import models.IMenu;
import view.IMenuView;

public interface IUtilsFactory {
    IDataLoader createDataLoader();
    IItemProcessor createItemProcessor(IMenu model, IMenuView menuView);
}
