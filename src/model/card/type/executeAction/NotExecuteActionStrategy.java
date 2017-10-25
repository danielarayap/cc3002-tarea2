package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

/**
 * This class specifies the executeAction method for the numeric cards, just updates the played card
 * and notifies by console the card that was played
 *
 * @author daraya
 */
public class NotExecuteActionStrategy implements ExecuteActionStrategy {
  @Override
  public void executeAction(IGameLogic game, IController ctrl, Card card) {
    game.setCurrentPlayedCard(card);
    ctrl.updatePlayedCard();
  }
}
