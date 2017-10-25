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
public class OfficialDeck extends DeckStrategy {

    void createActionCards() {
        createInvertCards();
        createSkipTurnCards();
        createPlusTwoCards();
    }

    void createWildCards() {
        for (int i = 0; i < 4; i++) {
            deck.pushCard(new Card(Color.NONE, Symbol.WILD_DRAW_FOUR, new PlusFourExecuteActionStrategy(), new UncoloredIsPlayableOverStrategy()));
            deck.pushCard(new Card(Color.NONE, Symbol.WILD,new ChangeColorExecuteActionStrategy(), new UncoloredIsPlayableOverStrategy()));
        }
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
}
