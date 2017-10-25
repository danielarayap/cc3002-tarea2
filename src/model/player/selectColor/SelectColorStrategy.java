package model.player.selectColor;


import controller.IController;
import model.IGameLogic;
import model.card.type.Color;

/**
 * This interface allows to specify a color strategy. I used the Strategy Pattern here too!!
 * encapsulating the selectColor method
 *
 * @author daraya
 */
public interface SelectColorStrategy {
  Color selectColor(IGameLogic game, IController ctrl);
}
