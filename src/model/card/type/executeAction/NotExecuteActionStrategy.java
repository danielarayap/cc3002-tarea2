package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

public class NotExecuteActionStrategy implements ExecuteActionStrategy {
    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.setCurrentPlayedCard(card);
        ctrl.updatePlayedCard();
    }
}
