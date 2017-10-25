package model.card.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.executeAction.ExecuteActionStrategy;
import model.card.type.isPlayableOver.IsPlayableOverStrategy;

/**
 * Created by Daniel Araya on 21-10-2017.
 */
public class Card implements ICard {
    private Color color;
    private Symbol symbol;
    private ExecuteActionStrategy actionStrategy;
    private IsPlayableOverStrategy playableOverStrategy;

    public Card(Color color, Symbol symbol, ExecuteActionStrategy actionStrategy, IsPlayableOverStrategy playableOverStrategy) {
        this.color = color;
        this.symbol = symbol;
        this.actionStrategy = actionStrategy;
        this.playableOverStrategy = playableOverStrategy;
    }

    @Override
    public boolean isPlayableOver(ICard otherCard) {
        return playableOverStrategy.isPlayableOver(this, otherCard);
    }

    @Override
    public boolean isFirstPlayable() {
        return true; //cualquiera se puede depositar como primera carta
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void executeAction(IGameLogic game, IController ctrl) { //no hace nada
        actionStrategy.executeAction(game, ctrl, this);
    }

    @Override
    public boolean isDiscardable() {
        return false; //???
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color: " + this.color.getName() + ", Simbolo: " + this.symbol.getName();
    }
}
