package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

/**
 * This class specifies the executeAction method for the PlusTwo cards
 *
 * @author daraya
 */
public class PlusTwoExecuteActionStrategy implements ExecuteActionStrategy {
  @Override
  public void executeAction(IGameLogic game, IController ctrl, Card card) {
    game.addToDrawWell(2);
    game.setCurrentPlayedCard(card);
    ctrl.updatePlayedCard();
  }
}
