package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

public class PlusTwoExecuteActionStrategy implements ExecuteActionStrategy{
    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.addToDrawWell(2);
        game.setCurrentPlayedCard(card);
        ctrl.updatePlayedCard();
    }
}
