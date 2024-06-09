import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class B2A2 {
    public static int compare_cnt = 0; // Zähler für die Vergleiche während des sortierens.


    public static void main(String[] args) {
        System.out.println("Bitte Array grösse festlegen");//Fragt den user nach Array grösse

        Scanner input = new Scanner(System.in);


        int n = input.nextInt(); //Array grösse wird eingegeben

        if (n <= 0){
            System.out.println("Fehler, Geben sie einen Wert grösser als 0 ein!"); //Fehlerfall der eingegebene Wert ist kleiner oder gleich 0
            return;
        }
        else {
            System.out.println("Array wurde mit der Grösse "+n+" initialisiert."); //Rückgabe an den user in der Console
        }

        int [] arr = new int [n];//Array wird mit der eingegebenen grösse initialisiert

        for (int i = 0; i < arr.length; i++) {

            arr[i] = input.nextInt();           //Array wird mit userinput gefüllt und bestätigt nach jeder eingabe.
            System.out.println("gespeichert");

        }

        System.out.println("Array ist nun voll."); //Hinweis auf volles Array.
        System.out.println("Array sortieren ? (Y/N)");//User wird gefragt, ob er das Array sortieren will oder verlassen.

        if (input.next().equalsIgnoreCase("y"))//Prüft usereingabe, ob Array sortiert werden soll.

        {

            mergeSort(arr);
            System.out.println(Arrays.toString(arr));





        }

        else System.out.println("Array wurde nicht sortiert.");//Falls User nicht sortieren möchte wird das zurückgegeben und Programm wird beendet.



        input.close();
    }


    public static void mergeSort(int[] numbers) {

        int[] tmpArray = new int[numbers.length];
        System.arraycopy(numbers, 0, tmpArray, 0, numbers.length);
        mergeSort(numbers, tmpArray, 0, numbers.length);


        // make sure that you have implemented and compiled B2A1 (run: javac B2A1.java)
        assert B2A1.isSorted(numbers);
    }

    /**
     * Hilfsfunktion, welche die rekursiven Aufrufe ausführt.
     *
     * @param target Zielarray für die sortierte Folge
     * @param source ein zu sortierendes Array mit Integer Zahlen
     * @param left   die linke Grenze des zu sortierenden Teilarrays, inklusiv
     * @param right  die rechte Grenze des zu sortierenden Teilarrays, exklusiv
     */
    public static void mergeSort(int[] target, int[] source, int left, int right) {
        /**********************************************************/
        /****                 Kurzaufgabe 2.2:                 ****/
        Instant start = Instant.now();

        if (source.length < 2){return;}  // Basecase , damit das halbieren gestoppt wird.
        int middle = source.length/2;    // mitte des Arrays wird initialisiert
        int[] rightarray = new int[source.length-middle]; //Arrays für rechte und linke Hälfte werden mit korrekter grösse initialisiert
        int[] leftarray = new int[middle];

        for (int i = 0; i < middle; i++)
        {

            leftarray[i] = source[i]; // linke seite wird befüllt.

        }

        for (int i = middle; i < source.length ; i++)

        {
            rightarray[i-middle] = source[i]; // rechte seite wird befüllt.
        }


        mergeSort(leftarray); // rekursive aufrufe zum halbieren.
        mergeSort(rightarray);

        merge(leftarray,rightarray,target); // rekursiver merge aufruf
        Instant finish=Instant.now();
        long time = Duration.between(start, finish).toMillis();
        System.out.println("Das Sortieren hat  " + time + "gedauert");




        /**********************************************************/
    }

    private static void merge (int [] left , int [] right , int[] target) //private merge methode.

    {


        int leftsize = left.length; //grösse der arrays.
        int rightsize = right.length;
        int i=0,j=0,k = 0; //iterator variablen

        while (i < leftsize && j < rightsize) //while schleife die so lange läuft, bis eine Iteratorvariable zu gross wird.
        {
            if (left[i] <= right[j])  // linkes element wird mit rechten verglichen und das kleinere an die stelle von k gepackt.
            {
                target[k] = left[i];
                i++;
                k++;

            }

            else
            {
                target[k] = right[j];
                j++;
                k++;
            }


        }

        while (i < leftsize)              //zwei whileschleifen um die letzte stelle zu befüllen.
        {
            target[k] = left[i];
            i++;
            k++;
        }

        while (j < rightsize)
        {
            target[k] = right[j];
            j++;
            k++;
        }


    }

}
