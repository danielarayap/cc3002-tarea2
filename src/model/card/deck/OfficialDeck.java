package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Card;
import model.card.type.Color;
import model.card.type.Symbol;
import model.card.type.executeAction.*;
import model.card.type.isPlayableOver.ColoredIsPlayableOverStrategy;
import model.card.type.isPlayableOver.UncoloredIsPlayableOverStrategy;

/**
 * This class represents the strategy for the OfficialDeck creation
 * @author daraya
 *
 */
public class OfficialDeck implements IDeckStrategy {

    private ICardPile deck = new CardPile();

    @Override
    public ICardPile createDeck() {
        createNotZeros();
        createNotZeros();
        createZeros();
        createActionCards();
        createWildCards();
        deck.shuffle();
        return deck;
    }

    private void createZeros() {
        deck.pushCard(new Card(Color.BLUE, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.GREEN, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.RED, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        deck.pushCard(new Card(Color.YELLOW, Symbol.ZERO, new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
    }

     void createNotZeros() {
        for (int i = 1; i < 10; i++) {
            deck.pushCard(new Card(Color.BLUE, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.GREEN, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.RED, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.YELLOW, Symbol.getNumeric()[i], new NotExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        }
    }

    private void createActionCards() {
        createInvertCards();
        createSkipTurnCards();
        createPlusTwoCards();
    }

    private void createWildCards() {
        createColorWildCards();
        createPlusFourWildCards();
    }

    private void createInvertCards() {
        for (int i = 0; i < 2; i++) {
            deck.pushCard(new Card(Color.BLUE, Symbol.INVERT, new InvertExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.RED, Symbol.INVERT, new InvertExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.GREEN, Symbol.INVERT, new InvertExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.YELLOW, Symbol.INVERT, new InvertExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        }
    }

    private void createSkipTurnCards() {
        for (int i = 0; i < 2; i++) {
            deck.pushCard(new Card(Color.BLUE, Symbol.SKIP, new SkipExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.RED, Symbol.SKIP, new SkipExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.GREEN, Symbol.SKIP, new SkipExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.YELLOW, Symbol.SKIP, new SkipExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        }
    }

    private void createPlusTwoCards() {
        for (int i = 0; i < 2; i++) {
            deck.pushCard(new Card(Color.BLUE, Symbol.DRAW_TWO, new PlusTwoExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.RED, Symbol.DRAW_TWO, new PlusTwoExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.GREEN, Symbol.DRAW_TWO, new PlusTwoExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.YELLOW, Symbol.DRAW_TWO, new PlusTwoExecuteActionStrategy(), new ColoredIsPlayableOverStrategy()));
        }
    }

    private void createColorWildCards(){
        for (int i = 0; i < 4; i++) {
            deck.pushCard(new Card(Color.NONE, Symbol.WILD,new ChangeColorExecuteActionStrategy(), new UncoloredIsPlayableOverStrategy()));
        }
    }

    private void createPlusFourWildCards() {
        for (int i = 0; i < 4; i++) {
            deck.pushCard(new Card(Color.NONE, Symbol.WILD_DRAW_FOUR, new PlusFourExecuteActionStrategy(), new UncoloredIsPlayableOverStrategy()));
        }
    }
}
