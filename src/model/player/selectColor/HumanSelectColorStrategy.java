package model.player.selectColor;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;


/**
 * This class allows to specify a selectColor strategy for the human players. I used the Strategy
 * Pattern here too!! encapsulating the selectColor method
 * 
 * @author daraya
 */
public class HumanSelectColorStrategy implements SelectColorStrategy {
  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    return ctrl.askForColor();
  }
}
