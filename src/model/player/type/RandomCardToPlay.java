package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;
import model.card.type.executeAction.DrawCardsActionStrategy;
import model.card.type.isPlayableOver.UncoloredIsPlayableOverStrategy;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class allows to specify a getCardToPlay strategy for the virtual players.
 * @author daraya
 */
public class RandomCardToPlay implements CardToPlayStrategy {
    @Override
    public ICard getCardToPlay(IGameLogic game, IController ctrl, ArrayList<ICard> cartas) {
        if (!game.isDrawWellEmpty()) {
            return new Card(Color.NONE, Symbol.NONE, new DrawCardsActionStrategy(), new UncoloredIsPlayableOverStrategy());
        } else {
            if (game.getCurrentPlayer().needsToDrawCard(game.getCurrentPlayedCard())) {
                ctrl.showMessage("[Estado]: "+ game.getCurrentPlayer() +" roba una carta");
                return game.drawOneCard(game.getCurrentPlayer());
            }
            else
                return cartas.get((new Random()).nextInt(cartas.size()));
        }
    }
}
