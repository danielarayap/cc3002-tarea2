package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

/**
 * This interface allows to specify an ICard creation strategy. I used the Strategy Pattern here too, encapsulating the
 * executeAction method
 *
 * @author daraya
 */
public interface ExecuteActionStrategy {
    void executeAction(IGameLogic game, IController ctrl, Card card);
}

