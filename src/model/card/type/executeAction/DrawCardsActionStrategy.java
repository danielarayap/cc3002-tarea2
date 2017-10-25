package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

public class DrawCardsActionStrategy implements ExecuteActionStrategy {
    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.drawCardsFromWell(game.getCurrentPlayer(), ctrl);
    }
}
