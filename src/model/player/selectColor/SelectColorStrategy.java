package model.player.selectColor;


import controller.IController;
import model.IGameLogic;
import model.card.type.Color;

public interface SelectColorStrategy {
    Color selectColor(IGameLogic game, IController ctrl);
}
