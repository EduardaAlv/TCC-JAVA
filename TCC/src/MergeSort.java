import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MergeSort {
    void merge(int array[], int indiceInicio, int meio, int indiceFinal) {
        int array1 = meio - indiceInicio + 1;
        int array2 = indiceFinal - meio;

        int X[] = new int[array1];
        int Y[] = new int[array2];

        for (int i = 0; i < array1; ++i)
            X[i] = array[indiceInicio + i];
        for (int j = 0; j < array2; ++j)
            Y[j] = array[meio + 1 + j];

        int i = 0, j = 0;
        int indiceInicialSubArray = indiceInicio;
        while (i < array1 && j < array2) {
            if (X[i] <= Y[j]) {
                array[indiceInicialSubArray] = X[i];
                i++;
            } else {
                array[indiceInicialSubArray] = Y[j];
                j++;
            }
            indiceInicialSubArray++;
        }

        while (i < array1) {
            array[indiceInicialSubArray] = X[i];
            i++;
            indiceInicialSubArray++;
        }

        while (j < array2) {
            array[indiceInicialSubArray] = Y[j];
            j++;
            indiceInicialSubArray++;
        }
    }

    void MetodoMergeSort(int arr[], int indiceInicial, int indiceFinal) {
        if (indiceInicial < indiceFinal) {
            int meio = indiceInicial + (indiceFinal - indiceInicial) / 2;
            MetodoMergeSort(arr, indiceInicial, meio);
            MetodoMergeSort(arr, meio + 1, indiceFinal);
            merge(arr, indiceInicial, meio, indiceFinal);
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File(
                "C:\\Users\\eduar\\Documents\\Repos\\ConsoleTeste\\ConsoleTeste\\dataTRINTAMIL.txt");
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
        MergeSort mergeSort = new MergeSort();

        long inicio = System.nanoTime();

        mergeSort.MetodoMergeSort(numeros, 0, numeros.length - 1);

        long fim = System.nanoTime();
        tempoDeExecucao += TimeUnit.NANOSECONDS.toMillis(fim - inicio);

        System.out.println(tempoDeExecucao);
    }
}
