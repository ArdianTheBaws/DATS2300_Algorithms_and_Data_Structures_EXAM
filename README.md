# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

Jeg startet med å dele den opprinnelige kildekoden på Github som en repository.

* Oppgave 1: Denne oppgaven løste jeg ved å hente kode fra kompendiet (5.3.2). Her trengte jeg kun å endre én linje med
kode som var å ta inn forelder q inn i parameteren p = new Node<>(verdi,q);

* Oppgave 2: Denne oppgaven løste ved hjelp av en lignende oppggave fra kompendiet (5.2.6). Vi søker etter en verdi, 
og returnerer 0 ellers. Kopierte løsningen til oppgave 2 og endret variabler. Hvis arrayet er tom (NULL) returneres 0.
Setter p som rot og bruker en while-løkke som starter fra toppen av treet, altså roten. Vi går da nedover treet og 
teller. Vi bruker en comparator til å finne om nodene skal til høyre eller venstre og går ut av løkkken for å
returnere telleren når vi har ingen noder til venstre/høyre å gå til.

* Oppgave 3: Denne oppgaven løste jeg først ved å lage hjelpemetoden førstePostorden. Brukte kode fra kompendiet 
Programkode 5.1.7 h). Startet med å lage en infinite while-løkke med én if-, én if else og én else. Først sjekker
vi i den første if setningen om vi kan gå rekursivt til venstre, hvis ikke vi kan gå til venstre hopper vi til neste
if setningen og sjekker om vi kan gå til høyre. Hvis ingen av if setningen blir oppfylt går vi til siste if
setning else, hvis det ikke er mulig å gå til venstre eller til høyre har vi nådd noden lengst nederst til venstre. Vi
returner bare noden p, altså roten vi startet med.

* Opprettet hjelpemetoden nestePostorden og starter først med å sjekke om forelderNoden er null, returner null 
hvis sann. Sjekker om høyre barn til forelder finnes, returnerer hvis true. Hvis ikke, sjekker vi om venstre barn til 
forelder finnes og om høyre barn er tom. Returner noden som kommer i nestePostorden.

* Oppgave 4: Denne oppgaven løste jeg først ved å lage en while-løkke som kjørte så lenge den ikke var null. Så brukte
førstePostorden sin node som rot. I postordenRecursive metoden går vi rekursivt gjennom hele treet. Besøker venstre node
og høyre node. Denne var litt mer vrien fordi her skjønte jeg ikke med én gang hvordan jeg skulle starte. Men etter å 
ha sett litt på kompendiet, særlig Figur 5.1.7 a) : Et binærtre med konturkurve, grønne prikkene som skulle 
representere postorden i en geometrisk regel skjønte jeg litt av tegninga. Brukte også Programkode 5.1.7 a) som viste
at man kunne gå rekursivt gjennom å besøke nodene. Her bruker jeg huskeregelen for postorden: venstre, høyre, node. 
Her skal rotnoden alltid komme sist i arrayet. Traverserer i postordisk rekkefølge, besøker alle nodene i en bestemt 
rekkefølge.
                                                                                                                                                                                             
* Oppgave 5:

* Oppgave 6: