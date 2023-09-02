package Rewards.Gold;

import Abstractions.IGameItem;
import Abstractions.ItemGenerator;

public class GoldGenerator extends ItemGenerator {
    /**
     * Метод создания экземпляра продукта
     *
     * @return экземпляр продукта
     */
    @Override
    public IGameItem createItem() {
        return new GoldRewards();
    }
}
