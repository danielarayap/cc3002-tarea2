package model.player.selectColor;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;

import java.util.Random;

public class RandomSelectColorStrategy implements SelectColorStrategy {
    @Override
    public Color selectColor(IGameLogic game, IController ctrl) {
        int color =  new Random().nextInt(Color.getColors().length);
        return Color.getColors()[color];
    }
}
