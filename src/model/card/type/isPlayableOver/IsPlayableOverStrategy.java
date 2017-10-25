package model.card.type.isPlayableOver;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;

public interface IsPlayableOverStrategy {
    boolean isPlayableOver(ICard cardInHand, ICard card);
}
