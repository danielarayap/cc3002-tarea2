package model.card.type.executeAction;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;

public interface ExecuteActionStrategy {
    void executeAction(IGameLogic game, IController ctrl, Card card);
}

