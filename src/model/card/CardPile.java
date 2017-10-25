package model.card;

import model.card.type.ICard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CardPile implements ICardPile {
    private Stack<ICard> pila;

    public CardPile() {
        pila = new Stack<>();
    }

    @Override
    public int getSize() {
        return pila.size();
    }

    @Override
    public ICard pushCard(ICard newCard) {
        return pila.push(newCard);
    }

    @Override
    public ICard popCard() {
        return pila.pop();
    }

    @Override
    public ArrayList<ICard> popCards(int i) {
        ArrayList<ICard> cartas = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            if(!pila.isEmpty())
                cartas.add(pila.pop());
        }
        return cartas;
    }

    @Override
    public ICard peekCard() {
        return pila.peek();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(pila);
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }

    @Override
    public void pushCards(ICardPile otherPile) {
        while(!otherPile.isEmpty()){
            pila.push(otherPile.popCard());
        }
    }
}
