import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SelectionSort {
    void SelectionSort(int array[]) {
        int tamArray = array.length;
        for (int i = 0; i < tamArray - 1; i++) {
            int elMinimo = i;
            for (int j = i + 1; j < tamArray; j++)
                if (array[j] < array[elMinimo])
                    elMinimo = j;
            int valor = array[elMinimo];
            array[elMinimo] = array[i];
            array[i] = valor;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\eduar\\Documents\\Repos\\ConsoleTeste\\ConsoleTeste\\dataDUZENTOSMIL.txt");
        Scanner leitor = new Scanner(arquivo);
        double tempoDeExecucao = 0;

        int tamanho = 0;
        while (leitor.hasNext()) {
            leitor.next();
            tamanho++;
        }

        leitor = new Scanner(arquivo);

        int[] numeros = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = leitor.nextInt();
        }

        leitor.close();
        SelectionSort selectionSort = new SelectionSort();

        long inicio = System.nanoTime();

        selectionSort.SelectionSort(numeros);

        long fim = System.nanoTime();
        tempoDeExecucao += TimeUnit.NANOSECONDS.toMillis(fim - inicio);

        System.out.println(tempoDeExecucao);
    }
}
