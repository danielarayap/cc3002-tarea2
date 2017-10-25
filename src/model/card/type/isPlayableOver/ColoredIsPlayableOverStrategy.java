package model.card.type.isPlayableOver;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;
/**
 * This class specifies the isPlayableOver method for colored cards like numeric and action cards
 * @author daraya
 */
public class ColoredIsPlayableOverStrategy implements IsPlayableOverStrategy {

    @Override
    public boolean isPlayableOver(ICard cardInHand, ICard card) {
        if(card == null)
            return true;
        return ((cardInHand.getColor()==card.getColor()) || (cardInHand.getSymbol()==card.getSymbol()));  //se puede jugar sobre otra carta de igual color o simbolo
    }
}