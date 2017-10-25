package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;
import model.card.type.executeAction.ExecuteActionStrategy;

public class InvertExecuteActionStrategy implements ExecuteActionStrategy {

    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.invertDirection();
        game.setCurrentPlayedCard(card);
        ctrl.updatePlayedCard();
        ctrl.showMessage("[Estado]: Cambio de dirección");
    }
}
