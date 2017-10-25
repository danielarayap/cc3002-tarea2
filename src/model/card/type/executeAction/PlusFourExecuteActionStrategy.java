package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;
/**
 * This class specifies the executeAction method for the color+4 wild card
 *
 * @author daraya
 */
public class PlusFourExecuteActionStrategy implements ExecuteActionStrategy {
    @Override
    public void executeAction(IGameLogic game, IController ctrl, Card card) {
        game.addToDrawWell(4);
        game.setCurrentPlayedCard(card);
        ctrl.updatePlayedCard();
        card.setColor( game.getCurrentPlayer().selectColor(game, ctrl));
        ctrl.updateColor(card.getColor());
    }
}
