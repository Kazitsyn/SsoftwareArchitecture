package Rewards.Coal;

import Abstractions.IGameItem;

public class CoalRewards implements IGameItem {
    /**
     * открывать и возвращать содержимое сундука
     *
     * @return
     */
    @Override
    public String open() {
        return "Coal";
    }
}
