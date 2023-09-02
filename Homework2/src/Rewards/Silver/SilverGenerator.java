package Rewards.Silver;

import Abstractions.IGameItem;
import Abstractions.ItemGenerator;

public class SilverGenerator extends ItemGenerator {
    /**
     * Метод создания экземпляра продукта
     *
     * @return экземпляр продукта
     */
    @Override
    public IGameItem createItem() {
        return new SilverRewards();
    }
}
