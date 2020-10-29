package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> {


    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) { //https://www.cs.hioa.no/~ulfu/appolonius/kap5/2/kap52.html#5.2.3
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, q);                   // oppretter en ny node. Siden q er forelder til p så da må ny


        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    //http://www.cs.hioa.no/~ulfu/appolonius/kap5/2/kap52.html
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) { //Lignende oppggave fra 5.2.6. Hvor vi søker etter en verdi, og returnerer 0 ellers.
        //https://www.cs.hioa.no/~ulfu/appolonius/kap5/2/kap52.html#5.2.6
        if (verdi == null)
            return 0;


        Node<T> p = rot;
        int antallverdier = 0;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else {
                if (cmp == 0) antallverdier++;
                p = p.høyre;
            }
        }

        return antallverdier;
    }


    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) { //Koden er hentet fra
                                                //https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/kap51.html#kode.5.1.7.h

        //kjører en infinite loop
        while (true){

            //hvis noden har et barn til venstre kan vi gå rekursivt til venstre
            if (p.venstre != null) p = p.venstre;

            //hvis ikke den har et barn til venstre, sjekker vi om noden har et barn til høyre kan vi gå rekursivt
            //til høyre
            else if(p.høyre != null) p = p.høyre;

            //hvis det ikke er mulig å gå til venstre eller til høyre har vi nådd noden lengst nederst til venstre
            else return p;
        }
    }

        private static <T> Node<T> nestePostorden(Node<T> p) { //Kompendiet https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/kap51.html#5.1.7
                                                                //Kode fra forelsning: https://github.com/babrodtk/AlgDat2020/blob/master/src/MyBinaryTree.java

            Node<T> node = p.forelder;


            if (node == null) { //vi sjekker om parameteren p ikke er null. Returner ellers bare null.
                return null;
            }

                if (node.høyre == p){ //høyre barn til forelder finnes
                    return node;
                }

                else if(node.venstre == p ){ //venstre barn til forelder finnes
                    if (node.høyre == null){
                        return node;
                    }


                    else return førstePostorden(node.høyre);
                }
            return node;

    }




    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> node = førstePostorden(rot);  //starter i første noden, altså roten



        while (node != null) { //kjører løkke med tanke på at node ikke er "tom"
            oppgave.utførOppgave(node.verdi); //skriver ut med hjelp fra interfacet i Oppgave.java
            node = nestePostorden(node); //flytter
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }


    //hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/kap51.html#5.1.10
    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        
        Node<T> node = p;


        if (node.venstre != null) postordenRecursive(node.venstre, oppgave); //besøker venstre node
        if (node.høyre != null) postordenRecursive(node.høyre, oppgave); //besøker høyre node

        oppgave.utførOppgave(node.verdi);//utfører oppgaven etter besøket, hvor i dette tilfeller er å skrive ut verdien


    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
