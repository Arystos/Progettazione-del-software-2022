package org.uniroma1.it.collections;

import java.util.NoSuchElementException;

public class MioSetIterator<E> implements Iterator<E> {

    private NodoLista<E> corrente;

    public MioSetIterator(NodoLista<E> inizio) {
        corrente = inizio;
    }

    @Override
    public boolean hasNext() {
        return corrente != null;
    }

    @Override
    public E next() {
        if (corrente == null) {
            throw new NoSuchElementException();
        }
        E elemento = corrente.elemento;
        corrente = corrente.next;
        return elemento;
    }
}
