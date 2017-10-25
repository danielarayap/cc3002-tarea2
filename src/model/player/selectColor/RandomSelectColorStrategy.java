package model.player.selectColor;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;

import java.util.Random;

/**
 * This class allows to specify a selectColor strategy for the virtual players. I used the Strategy Pattern here too!!
 * encapsulating the selectColor method
 * @author daraya
 */
public class RandomSelectColorStrategy implements SelectColorStrategy {
    @Override
    public Color selectColor(IGameLogic game, IController ctrl) {
        int color =  new Random().nextInt(Color.getColors().length);
        return Color.getColors()[color];
    }
}
