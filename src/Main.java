/**
 Von primitiven Datentypen wie int, float, boolean werden die Werte unmittelbar in den Variablen gespeichert.

 Bei Objekte wie Array, Bottle, ... wird ein "Wegweiser" (die Adresse) zu den Objekten
 in der Variable gespeichert -> Referenzvariable

 Wir haben das bereits auch in SEW1 beim Thema Array behandelt.

 Bei Objekten (wie Array, Bottle, ...) ...
 - beginnt der Datentyp mit einem Großbuchstaben
 - werden Referenzen ("Wegweiser") auf das Objekt gespeichert
 - bei Zuweisungen wird die Referenz kopiert.
 - bei Methodenparametern werden Änderungen am Argument des Aufrufers vorgenommen.

 Bei primitiven Datentypen (wie float, int, double,...) ...
 - beginnt der Datentyp mit einem Kleinbuchstaben
 - werden Werte direkt gespeichert
 - bei Zuweisungen wird somit der Wert kopiert.
 - bei Methodenparametern werden Änderungen an einer lokalen Kopie vorgenommen.
 **/


class Main {
    public static void main(String[] args) {

        /*
         Das Objekt, das mit "new" erzeugt wird hat selbst keinen Namen! Nur die Variable b, die auf dieses Objekt referenziert.
         */
        Bottle b = new Bottle();

        /*
         Mehrere Variablen können auf das GLEICHE Objekt zeigen.
         Die Variablen b und c zeigen jetzt auf das gleiche Objekt.
         */
        Bottle c = b;

        /* Die Werte werden auf b gesetzt */
        b.setVolume(500);
        b.setCurrentLevel(200);

        /* und sind natürlich auch für c gültig, weil die Variablen auf das GLEICHE Objekt zeigen */
        System.out.println(c); //Vol: 500, curLevel: 200

        /* Es kann passieren, dass gar keine Referenzvariable mehr auf ein Objekt zeigt.
        Dann kann dieses nicht mehr verwendet werden und wird gelöscht.
        In Java macht das automatisch der "Garbage Collector".
         */

        /* Um eine Variable auf kein Objekt verweisen zu lassen wird die Konstante null zugewiesen. */
        b = null;

        /* Vergleiche dazu das Verhalten bei primitiven Variablen */
        int x = 5;
        int y = x;  //Wert wird kopiert, nicht die Referenz
        x = 2;  //hat keinen Einfluss auf y
        System.out.println("x: "+x+ " y: "+y);

        /* Beachte, dass auch bei Methodenaufrufen bei Objekten die Referenz und bei primitiven Datentypen
        der Wert übergeben wird */
        System.out.println("Vor dem Methodenaufruf: "+c);  //Vol: 500
        changeValues(c);
        System.out.println("Nach dem Methodenaufruf: "+c);  //Vol: 300

        float zahl = 45.2f;
        System.out.println("Vor dem Methodenaufruf: "+zahl);  //zahl: 45.2
        changeValues(zahl);
        System.out.println("Nach dem Methodenaufruf: "+zahl); //zahl: 45.2

        /*  Einen Spezialfall stellen Strings dar. String-Objekte sind unveränderlich (immutable).
            Bei jeder "Änderung" des Texts wird also eine neues String Objekt angelegt.
         */
        String test1="Test1";
        String test2=test1;
        test2="neuer Wert";
        System.out.println("test1: "+test1); //Ausgabe: "Test1"
    }


    public static void changeValues(Bottle b) {
        b.setVolume(300);
    }

    public static void changeValues(float f) {
        f = 50;
    }

}
