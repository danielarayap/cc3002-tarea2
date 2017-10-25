package model.card.type.isPlayableOver;

import model.card.type.ICard;

/**
 * This class specifies the isPlayableOver method for NoColor cards like plusFour and colorWildCard
 * @author daraya
 */
public class UncoloredIsPlayableOverStrategy implements IsPlayableOverStrategy{
    @Override
    public boolean isPlayableOver(ICard cardInHand, ICard card) {
        return true;
    }
}
