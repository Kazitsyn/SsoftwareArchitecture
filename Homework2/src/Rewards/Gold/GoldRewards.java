package Rewards.Gold;

import Abstractions.IGameItem;

public class GoldRewards implements IGameItem {
    /**
     * открывать и возвращать содержимое сундука
     *
     * @return
     */
    @Override
    public String open() {
        return "Gold";
    }
}
