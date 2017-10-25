package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Card;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;
import model.card.type.executeAction.DrawCardsActionStrategy;
import model.card.type.isPlayableOver.ColoredIsPlayableOverStrategy;
import model.card.type.isPlayableOver.UncoloredIsPlayableOverStrategy;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class allows to specify a getCardToPlay strategy for the human players.
 * 
 * @author daraya
 */
public class HumanCardToPlay implements CardToPlayStrategy {
  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl, ArrayList<ICard> cartas) {
    if (!game.isDrawWellEmpty()) {
      return new Card(Color.NONE, Symbol.NONE, new DrawCardsActionStrategy(),
          new UncoloredIsPlayableOverStrategy());
    } else {
      return cartas.get(ctrl.AskForCardFromHand(game.getCurrentPlayer()));
    }
  }

}
