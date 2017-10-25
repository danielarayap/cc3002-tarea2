package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;

import java.util.ArrayList;

public interface CardToPlayStrategy {

    ICard getCardToPlay(IGameLogic game, IController ctrl, ArrayList<ICard> cartas);

}
