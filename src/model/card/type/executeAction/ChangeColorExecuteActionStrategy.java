package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

/**
 * This class specifies the executeAction method for the color wild card
 *
 * @author daraya
 */
public class ChangeColorExecuteActionStrategy implements ExecuteActionStrategy {
  @Override
  public void executeAction(IGameLogic game, IController ctrl, Card card) {
    game.setCurrentPlayedCard(card);
    ctrl.updatePlayedCard();
    card.setColor(game.getCurrentPlayer().selectColor(game, ctrl));
    ctrl.updateColor(card.getColor());
  }
}
