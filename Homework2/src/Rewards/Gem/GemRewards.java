package Rewards.Gem;

import Abstractions.IGameItem;

public class GemRewards implements IGameItem {
    /**
     * открывать и возвращать содержимое сундука
     *
     * @return
     */
    @Override
    public String open() {
        return "Gem";
    }
}
