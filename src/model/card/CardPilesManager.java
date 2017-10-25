package model.card;

import model.card.type.ICard;
import model.player.type.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class CardPilesManager implements ICardPilesManager {
  private ICardPile mazo, descarte;

  @Override
  public void rebuildDeck() {
    ICard aux = descarte.popCard();
    while (!descarte.isEmpty())
      mazo.pushCard(descarte.popCard());
    descarte.pushCard(aux);
    mazo.shuffle();
  }

  @Override
  public ICard drawCard() {
    return mazo.popCard();
  }

  @Override
  public int getDrawableCardsNumber() {
    return mazo.getSize() + descarte.getSize() - 1;
  }

  @Override
  public ArrayList<ICard> drawCards(int cardsNumber) {
    ArrayList<ICard> aux = new ArrayList<>();
    if (cardsNumber > this.getDrawableCardsNumber())
      cardsNumber = getDrawableCardsNumber();
    for (int i = 0; i < cardsNumber; i++)
      aux.add(mazo.popCard());
    return aux;
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return descarte.peekCard();
  }

  @Override
  public void discard(ICard newCard) {
    descarte.pushCard(newCard);
  }

  @Override
  public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
    ArrayList<ICard> aux = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      aux.add(mazo.popCard());
    }
    return aux;
  }
}
