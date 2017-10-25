package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;
import model.player.selectColor.SelectColorStrategy;

import java.util.ArrayList;

public class Player implements IPlayer {
  private ArrayList<ICard> cartas;
  private boolean saidUno;
  private CardToPlayStrategy cardToPlayStrategy;
  private String nombre;
  private SelectColorStrategy selectColorStrategy;

  public Player(CardToPlayStrategy cardToPlayStrategy, SelectColorStrategy selectColorStrategy,
      String nombre) {
    this.selectColorStrategy = selectColorStrategy;
    this.cartas = new ArrayList<>();
    this.cardToPlayStrategy = cardToPlayStrategy;
    this.nombre = nombre;
  }

  @Override
  public void addToHand(ArrayList<ICard> hand) {
    cartas.addAll(hand);
  }

  @Override
  public boolean hasWon() {
    return cartas.isEmpty();
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    return cardToPlayStrategy.getCardToPlay(game, ctrl, cartas);
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    return selectColorStrategy.selectColor(game, ctrl);
  }

  @Override
  public int getHandSize() {
    return cartas.size();
  }

  @Override
  public boolean hasOneCard() {
    return cartas.size() == 1;
  }

  @Override
  public ArrayList<ICard> getHand() {
    return cartas;
  }

  @Override
  public void setSaidUNO(boolean status) {
    saidUno = status;
  }

  @Override
  public boolean hasSaidUNO() {
    return saidUno;
  }

  @Override
  public void removeCardFromHand(ICard card) {
    cartas.remove(card);
  }

  @Override
  public boolean needsToDrawCard(ICard currentCard) {
    for (ICard card : cartas) {
      if (card.isPlayableOver(currentCard))
        return false;
    }
    return true;
  }

  @Override
  public ICard getCardFromHand(int number) {
    if (number > 0 && number < cartas.size())
      return cartas.get(number);
    return new NullCard();
  }

  @Override
  public String toString() {
    return this.nombre;
  }
}
