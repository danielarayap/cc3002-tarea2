package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;

import java.util.ArrayList;

/**
 * This interface allows to specify a getCardToPlay strategy for the different players. I used the Strategy Pattern
 * here too!! encapsulating the getCardToPlay method
 * @author daraya
 */
public interface CardToPlayStrategy {

    ICard getCardToPlay(IGameLogic game, IController ctrl, ArrayList<ICard> cartas);

}
