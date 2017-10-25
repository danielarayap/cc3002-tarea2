package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;
/**
 * This class specifies the executeAction method for the skip players cards
 *
 * @author daraya
 */
public class SkipExecuteActionStrategy implements ExecuteActionStrategy {

    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.skipPlayer();
        game.setCurrentPlayedCard(card);
        ctrl.updatePlayedCard();
    }
}
