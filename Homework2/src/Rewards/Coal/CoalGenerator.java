package Rewards.Coal;

import Abstractions.IGameItem;
import Abstractions.ItemGenerator;

public class CoalGenerator extends ItemGenerator {
    /**
     * Метод создания экземпляра продукта
     *
     * @return экземпляр продукта
     */
    @Override
    public IGameItem createItem() {
        return new CoalRewards();
    }
}
