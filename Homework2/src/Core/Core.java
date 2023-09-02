package Core;

import Abstractions.IGameItem;
import Abstractions.ItemGenerator;
import Rewards.Coal.CoalGenerator;
import Rewards.Gem.GemGenerator;
import Rewards.Gold.GoldGenerator;
import Rewards.Silver.SilverGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Core {
    private Random rnd = new Random();

    /**
     * Логика игры
     */
    public void run(){
        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new GoldGenerator());
        generatorList.add(new SilverGenerator());
        generatorList.add(new GemGenerator());
        generatorList.add(new CoalGenerator());
        ItemGenerator myGoldBox = generatorList.get(rnd.nextInt(0, generatorList.size()));
        ItemGenerator mySimpleBox = generatorList.get(likelihood());

        System.out.println("GoldBox (равновероятный сундук): " + myGoldBox.openReward());
        System.out.println("SimpleBox (50% Уголь, 25% Серебро, 20% Золото, 5% кристалы): " + mySimpleBox.openReward());

    }


    private int likelihood(){
        int likelihood = rnd.nextInt(0,99);
        if (likelihood < 50) {
            return 3;
        } else if (likelihood >= 50 && likelihood < 75) {
            return 1;
        } else if (likelihood >= 75 && likelihood < 95){
            return 0;
        } else {
            return 2;
        }
    }


}
