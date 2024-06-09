import java.util.Arrays;
import java.util.Scanner;

public class B2A1 {
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
            if (isSorted(arr)== true){
                System.out.println("Array ist bereits sortiert."); //Weisst user daraufhin, dass Array bereits sortiert ist.
                insertionSort(arr);//Sortiert das Array durch Insertionsort.
            }

            else {insertionSort(arr);} //Sortiert Unsortiertes Array.

        }

        else System.out.println("Array wurde nicht sortiert.");//Falls User nicht sortieren möchte wird das zurückgegeben und Programm wird beendet.


        input.close();
    }


    public static boolean isSorted(int[] numbers) {


        for (int i = 0; i < numbers.length-1; i++) {

            assert numbers.length > 0; //stellt sicher dass, Array eine valide Grösse hat.
            //Äussere Schleife startet beim ersten Index.

            for (int j = i+1; j <numbers.length ; j++) //Innere Schleife vergleicht für gewählten Index, ob es in den
            //Array einen folgenden Index gibt der kleiner ist als der Gewählte
            // wird einer gefunden wird false zurückgegeben.
            {

                if (numbers[i] > numbers[j]){return false;}



            }


        }


        return true; //Wird nichts gefunden wird true zurückgegeben.
    }


    public static void insertionSort(int[] numbers) {

        int j ;
        int temp;
        int [] backup = Arrays.copyOf(numbers,numbers.length);


        for (int i = 0; i < numbers.length; i++) {
            assert numbers.length> 0;
            j=i;
            assert j==i;

            while (j > 0 && numbers[j-1] > numbers[j])
            {
                compare_cnt++; //Erhöht den compare_cnt jedes Mal, wenn While Schleife iteriert und verglichen wird.
                temp = numbers[j]; //speichert gewählten Wert in einem Zwischenspeicher.
                numbers[j] = numbers[j-1];   //Tauscht so lange mit linken Werten bis Conditionen der Whileschleife verletzt wird.
                numbers[j-1] = temp;
                j = j-1;


            }



        }
        if (!isSorted(numbers)){
            System.out.println("Fehler : Array wurde nicht sortiert."); //Gibt fehler aus falls Array unsortiert ist .
        }
        System.out.println("Array ist sortiert.");
        assert isSorted(numbers); //stellt sicher ob, das Array korrekt sortiert wurde.

        System.out.print("Input:");
        System.out.println(Arrays.toString(backup));
        System.out.print("Output:");                       //Ausgabe für den User.
        System.out.println(Arrays.toString(numbers));
        System.out.println("Das sortieren des Arrays hat "+compare_cnt+ " Vergleiche benötigt.");


    }


}



