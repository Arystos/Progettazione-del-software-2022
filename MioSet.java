package org.uniroma1.it.collections;

import java.lang.reflect.Array;
import java.security.DrbgParameters.Reseed;
import java.text.Normalizer.Form;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.naming.spi.ObjectFactory;

public class MioSet <E> implements Set<E> Cloneable {
    
    private NodoLista<E> inizio;
    private int size; //Superflua 

    public void MioSet() {
        inizio =null;
        size = 0;
    }
}

@Override
public int size() {
    // TODO Auto-generated method stub
    return this.size;
}

@Override
public boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
}

@Override
public boolean contains(Object o) { //Dato un oggetto in Imput trus se contiene l'ogetto, false altrimenti
    // TODO Auto-generated method stub
    for(NodoLista<E> n = inizio; n != null; n = n.next) { // For ad oggetti
        if (n.elemento.equals(o)) {
            return true;
        }
    }
    return false;
}

@Override
public Iterator<E> iterator() { // Scanning, è un interfaccia
    // TODO Auto-generated method stub
    
    
}

@Override
@SuppressWarnings("unchecked")  // elimina i warning nel caso degli unchecked casting, lo facciamo quando sappiamo cosa stiamo facendo
public Object[] toArray() {
    // TODO Auto-generated method stub

    Object[] res = new Object[this.size]
    for (NodoLista<E> n = inizio; n != null; n = n.next) { // Scorro la lista
        res[index++] = n.elemento; // Mantengo index all esterno

        //NB: index++ post incremento
    }
    return res;
}

@Override
public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub

    T[] res = (T[]) Array.newInstance(a.getClass().getComponentType(), size) // NewIstance prende il tipo T cha ha grndeza size
    int index = 0;
    for (NodoLista<E> n = inizio; n != null; n = n.next) {// Scorro la lista
        res[index++] = (T) n.elemento; // casting
    } 
    return res;
}

@Override
public boolean add(E e) {
    // TODO Auto-generated method stub

    // Verifica se nell'insieme contiene già l elemento e
    if (this.contains(e)) {
        return false;
    }

    NodoLista<E> n = new NodoLista<E>(null, e);

    // Inserimento in coda
    if (inizio == null) {
        inizio = n;
        return true;
    } else {
        for (NodoLista<E> nodo = inizio; nodo != null; nodo = nodo.next) { // Scorro tutta la lista
            if (nodo.next == null) { //Appena arivo all ultimo elemento
                nodo.next = n; // Accodo all'ultimo elemento il nuovo elemento alla lista
                break;
            }
        }
    }
}

@Override
public boolean remove(Object o) {  // Rimuove un elemento, se non è presente all'interno del sistema è false (anche se la size è 0)
    // TODO Auto-generated method stub
    if(this.contains(o) || this.size == 0) {
        return false;
    }
    
    if (inizio.elemento.equals(o)) { // Caso in cui non è il primo elemento
        inizio = inizio.next;
        size--;
        return true;
    }

    NodoLista<E> corrente = inizio;
    NodoLista<E> successivo = corrente.next;
    while (successivo != null) {
        if (successivo.equals(o)) { // se il successivo è l elemento che sto cercando
            corrente.next = successivo.next; // il corrente diventa il successivo del successivo (?)
            size--;
            return true;
        }
    }
}

@Override
public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
}

@Override
public boolean addAll(Collection<? extends E> c) {
    // TODO Auto-generated method stub
    return false;
}

@Override
public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
}

@Override
public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException()
    return false;
}

@Override
public void clear() {
    // TODO Auto-generated method stub

    // Ripulisce tutta quanta la collezione
    //NB: Dalla garbage collection la memoria a catena viene tutta quanta liberata
    
    inizio = null;
    size = 0;
   
}

@Override
public boolean equals(Object o) {
    //Gli elementi sono all'interno di header?
    if (o == null || !getClass().equals(.getClass())) {
        return false;
    }
    MioSet<E> other = (Mioset<E>) o;
    for(NodoLista<E> nodo = inizio; nodo != null; nodo = nodo.next) {
        if (other.contains(nodo.elemento)) {
            return false;
        }
        for(NodoLista<E> nodo = other.inizio; nodo != null; nodo = nodo.next) {
            if(!this.contains(nodo.elemento)) {
                return false;
            }
        }
    }
    return true;
}

@Override
public int hashCode() {
    int hash = 0;
    for (E elem : this) {
        hash += elem.hashCode();
    }
    return hash;
}

@Override
protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    try {
        MioSet<E> copia = (MioSet<E>) super.clone;
        if(size > 0) {
            NodoLista<E> newInizio = new NodoLista<E>(this.inizio.next, this.inizio.elemento);
            NodoLista<E> coda = newInizio;
            for(NodoLista<E> nodo = this.inizio.next; nodo != null; nodo.next) {
                coda.next = new NodoLista<E>(nodo.next, nodo.elemento);
                cosa = coda.next
            }
            copia.inizio = newInizio;
        }
        return copia;
    } catch (CloneNotSupportedException e ) {
        throw new InternalError(e.toString());
    }
}

@Override
public String toString {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    for (NodoLista<E> corrente = inizio; corrente != null; corrente = corrente.next) {
        sb.append(corrente.elemento.toString());
        if(corrente.next != null) { // Per evitare solo che sull'ultima stringa non esca una virgola
            sb.append(", ")
        }
    }
    sb.append(")")
    return sb.toString;
}


// To array trasforma la collezione
