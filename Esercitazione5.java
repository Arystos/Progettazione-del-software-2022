package org.uniroma1.it.collections;

import java.util.LinkedList;

public class Esercitazione5 {

    public String a;

    public static void main(String[] args) {
        LinkedList<Esercitazione5> l1 = new LinkedList<Esercitazione5>(null);
        Esercitazione5 ma = new Esercitazione5();
        l1.add(ma);
        ma.a = "ciao";

        LinkedList<Esercitazione5> l2 = (LinkedList<Esercitazione5>) l1.clone();
        l2.get(0).a = "ciaox";

        System.out.println(l1.get(0).a);
        System.out.println(l2.get(0).a);
    }
}
