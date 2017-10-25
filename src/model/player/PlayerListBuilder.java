package model.player;

import model.player.selectColor.HumanSelectColorStrategy;
import model.player.selectColor.RandomSelectColorStrategy;
import model.player.type.HumanCardToPlay;
import model.player.type.IPlayer;
import model.player.type.Player;
import model.player.type.RandomCardToPlay;

import java.util.ArrayList;

public class PlayerListBuilder implements IPlayerListBuilder{
    private ArrayList<IPlayer> players = new ArrayList<>(10);
    @Override
    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    @Override
    public ArrayList<IPlayer> buildPlayerList() {
        ArrayList<IPlayer> aux = players;
        //players.clear();
        return aux;
    }
}
