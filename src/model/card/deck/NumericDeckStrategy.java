package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Card;
import model.card.type.executeAction.NotExecuteActionStrategy;
import model.card.type.Symbol;
import model.card.type.isPlayableOver.ColoredIsPlayableOverStrategy;

/**
 * This class represents the NumericDeckStrategy creation strategy
 * 
 * @author daraya
 *
 */
public class NumericDeckStrategy extends DeckStrategy {

  private ICardPile deck = new CardPile();

  @Override
  void createActionCards() {
    // doNothing
  }

  @Override
  void createWildCards() {
    // doNothing
  }
}
