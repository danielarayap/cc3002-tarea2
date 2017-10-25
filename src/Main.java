import controller.ConsoleController;
import model.GameLogic;
import model.IGameLogic;
import model.card.deck.NumericDeck;
import model.card.deck.OfficialDeck;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;
import model.player.selectColor.HumanSelectColorStrategy;
import model.player.selectColor.RandomSelectColorStrategy;
import model.player.type.HumanCardToPlay;
import model.player.type.IPlayer;
import model.player.type.Player;
import model.player.type.RandomCardToPlay;
import view.ConsoleView;

import java.util.ArrayList;

/**
 * Main class of UNO Game
 *
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 *
 * @author eriveros
 */
public class Main {

    public static void main(String[] args) {
        IPlayerListBuilder playerBuilder = new PlayerListBuilder();
        playerBuilder.addPlayer(new Player(new RandomCardToPlay(), new RandomSelectColorStrategy(), "Jugador 1"));
        playerBuilder.addPlayer(new Player(new RandomCardToPlay(), new RandomSelectColorStrategy(), "Jugador 2"));
        playerBuilder.addPlayer(new Player(new RandomCardToPlay(), new RandomSelectColorStrategy(), "Jugador 3"));
        playerBuilder.addPlayer(new Player(new HumanCardToPlay(), new HumanSelectColorStrategy(), "Jugador Manual"));

        IGameLogic game = new GameLogic((new OfficialDeck()).createDeck(), new PlayerManager(playerBuilder.buildPlayerList()));
        ConsoleView view = new ConsoleView(game);
        ConsoleController ctrl = new ConsoleController(game, view);
        while (!game.hasEnded()) {
            ctrl.playTurn();
        }
        game.announceWinner(ctrl);
    }
}
