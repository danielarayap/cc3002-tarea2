package model.player;

import model.player.type.IPlayer;

import java.util.ArrayList;

public class PlayerManager implements IPlayerManager {
    private ArrayList<IPlayer> players;
    private int indice;
    private Direction direccionJuego;
    private IPlayerListBuilder playerListBuilder = new PlayerListBuilder();

    public PlayerManager(ArrayList<IPlayer> players) {
        this.players = players;
        direccionJuego = Direction.COUNTERCLOCKWISE;
        indice = -1;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return players.get(indice);
    }

    @Override
    public ArrayList<IPlayer> getPlayers() {
        return players;
    }

    @Override
    public void invertDirection() {
        if (direccionJuego == Direction.CLOCKWISE) direccionJuego = Direction.COUNTERCLOCKWISE;
        else direccionJuego = Direction.CLOCKWISE;
    }

    @Override
    public void startTurn() {
        changeIndex();
    }

    @Override
    public void skipPlayer() {
        changeIndex();
    }

    private void changeIndex() {
        int aux = (indice + direccionJuego.getValue()) % players.size();
        indice = aux < 0 ? aux + players.size() : aux;
    }
}
