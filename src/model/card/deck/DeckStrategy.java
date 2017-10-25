package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Card;
import model.card.type.Color;
import model.card.type.Symbol;
import model.card.type.executeAction.NotExecuteActionStrategy;
import model.card.type.isPlayableOver.ColoredIsPlayableOverStrategy;
/**
 * This abstract class allows to specify a Deck Generation Strategy. Here I used the Strategy pattern to
 * generate the NumericDeckStrategy and the Template Method Pattern for the method createDeck()
 *
 * @author daraya
 */
public abstract class DeckStrategy implements IDeckStrategy {
    ICardPile deck = new CardPile();
    @Override
    public final ICardPile createDeck() {
        createZeros();
        createNumbers();
        createActionCards();
        createWildCards();
        deck.shuffle();
        return deck;
    }

    /**
     * Puts the "zero" cards in the deck.
     */
    private void createZeros() {
        deck.pushCard(new Card(Color.BLUE, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.GREEN, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.RED, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.YELLOW, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
    }


    /**
     * Puts the number cards (except 0) in the deck.
     */
    private void createNumbers(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                deck.pushCard(new Card(Color.BLUE, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
                deck.pushCard(new Card(Color.GREEN, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
                deck.pushCard(new Card(Color.RED, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
                deck.pushCard(new Card(Color.YELLOW, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            }
        }
    }


    /**
     * Puts the action cards in the deck.
     */
    abstract void createActionCards();


    /**
     * Puts the wild cards in the deck (color change wild card and plus-four wild cards).
     */
    abstract void createWildCards();
}
