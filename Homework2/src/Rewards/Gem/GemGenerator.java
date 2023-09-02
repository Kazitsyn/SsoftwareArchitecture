package Rewards.Gem;

import Abstractions.IGameItem;
import Abstractions.ItemGenerator;

public class GemGenerator extends ItemGenerator {
    /**
     * Метод создания экземпляра продукта
     *
     * @return экземпляр продукта
     */
    @Override
    public IGameItem createItem() {
        return new GemRewards();
    }
}
