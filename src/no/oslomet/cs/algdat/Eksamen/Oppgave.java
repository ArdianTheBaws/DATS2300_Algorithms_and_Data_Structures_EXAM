package no.oslomet.cs.algdat.Eksamen;

import no.oslomet.cs.algdat.Eksamen.EksamenSBinTre;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


@FunctionalInterface



public interface Oppgave<T>  // legges under hjelpeklasser
{

    void utførOppgave(T t);    // f.eks. utskrift til konsollet

}

