package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Card;
import model.card.type.executeAction.NotExecuteActionStrategy;
import model.card.type.Symbol;
import model.card.type.isPlayableOver.ColoredIsPlayableOverStrategy;

/**
 * This class represents the NumericDeck creation strategy
 * @author daraya
 *
 */
public class NumericDeck implements IDeckStrategy {

    private ICardPile deck = new CardPile();

    @Override
    public ICardPile createDeck() {
        createZeros();
        createNotZeros();
        createNotZeros();
        deck.shuffle();
        return deck;
    }

    private void createZeros() {
        deck.pushCard(new Card(Color.BLUE, Symbol.ZERO, new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.GREEN, Symbol.ZERO, new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.RED, Symbol.ZERO, new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.YELLOW, Symbol.ZERO, new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
    }

    private void createNotZeros() {
        for (int i = 1; i < 10; i++) {
            deck.pushCard(new Card(Color.BLUE, Symbol.getNumeric()[i], new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.GREEN, Symbol.getNumeric()[i], new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.RED, Symbol.getNumeric()[i], new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.YELLOW, Symbol.getNumeric()[i], new NotExecuteActionStrategy(),new ColoredIsPlayableOverStrategy()));
        }
    }
}
