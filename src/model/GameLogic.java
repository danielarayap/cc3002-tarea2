package model;


import controller.IController;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.type.ICard;
import model.player.IPlayerManager;
import model.player.PlayerManager;
import model.player.type.IPlayer;

import java.util.ArrayList;

public class GameLogic implements IGameLogic {

  private ICardPilesManager pilesManager;
  private ICardPile mazo;
  private IPlayerManager jugadores;
  private ICard currentPlayedCard;
  private int drawWell;
  private boolean gameHasEnded = false;

  public GameLogic(ICardPile mazo, IPlayerManager jugadores) {
    this.pilesManager = pilesManager;
    this.mazo = mazo;
    this.jugadores = jugadores;
    if (jugadores.getPlayers().size() <= 10 || jugadores.getPlayers().size() >= 2)
      for (IPlayer jugador : jugadores.getPlayers())
        jugador.addToHand(mazo.popCards(7));
  }

  @Override
  public boolean hasEnded() {
    return gameHasEnded;
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return jugadores.getCurrentPlayer();
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return this.currentPlayedCard;
  }

  @Override
  public void autoShoutUNO(IController ctrl) {
    if (getCurrentPlayer().hasOneCard()) {
      if (!getCurrentPlayer().hasSaidUNO()) {
        getCurrentPlayer().setSaidUNO(true);
        ctrl.showMessage("UNO!");
      }
    } else {
      getCurrentPlayer().setSaidUNO(false);
    }
  }

  @Override
  public void startTurn(IController ctrl) {
    jugadores.startTurn();
  }

  @Override
  public void skipPlayer() {
    jugadores.skipPlayer();
  }

  @Override
  public void addToDrawWell(int number) {
    drawWell += number;
  }

  @Override
  public void resetDrawWell() {
    drawWell = 0;
  }

  @Override
  public boolean isDrawWellEmpty() {
    return drawWell == 0;
  }

  @Override
  public void drawCardsFromWell(IPlayer player, IController ctrl) {
    for (int i = 0; i < drawWell; i++) {
      this.drawOneCard(player);
    }
    ctrl.showMessage("[Estado]: Jugador roba " + drawWell + " cartas");
    resetDrawWell();
  }

  @Override
  public void invertDirection() {
    jugadores.invertDirection();

  }

  @Override
  public boolean playCard(ICard playedCard, IController ctrl) {
    if (playedCard.isPlayableOver(getCurrentPlayedCard())) {
      getCurrentPlayer().removeCardFromHand(playedCard);
      playedCard.executeAction(this, ctrl);
      if (getCurrentPlayer().hasWon()) {
        gameHasEnded = true;
        return true;
      }
      autoShoutUNO(ctrl);
      return true;
    }
    return false;
  }

  @Override
  public ICard drawOneCard(IPlayer player) {
    ICard card = mazo.popCard();
    ArrayList<ICard> list = new ArrayList<>();
    list.add(card);
    player.addToHand(list);
    return card;
  }

  @Override
  public void announceWinner(IController ctrl) {
    ctrl.showMessage("[Estado]: " + getCurrentPlayer() + " gana el juego!!");
  }

  @Override
  public void setCurrentPlayedCard(ICard card) {
    currentPlayedCard = card;
  }
}

