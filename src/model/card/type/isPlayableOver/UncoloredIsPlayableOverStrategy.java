package model.card.type.isPlayableOver;

import model.card.type.ICard;

public class UncoloredIsPlayableOverStrategy implements IsPlayableOverStrategy{
    @Override
    public boolean isPlayableOver(ICard cardInHand, ICard card) {
        return true;
    }
}
