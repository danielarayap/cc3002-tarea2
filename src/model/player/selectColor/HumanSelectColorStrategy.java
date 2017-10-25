package model.player.selectColor;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;

public class HumanSelectColorStrategy implements SelectColorStrategy {
    @Override
    public Color selectColor(IGameLogic game, IController ctrl) {
        return ctrl.askForColor();
    }
}
