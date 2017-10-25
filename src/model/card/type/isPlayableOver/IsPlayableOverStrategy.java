package model.card.type.isPlayableOver;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;

/**
 * This interface allows to specify an ICard creation strategy to determine if the card is playable
 * over the one in the discard pile. I used the Strategy Pattern here too, encapsulating the
 * isPlayableOver method
 *
 * @author daraya
 */
public interface IsPlayableOverStrategy {
  boolean isPlayableOver(ICard cardInHand, ICard card);
}
