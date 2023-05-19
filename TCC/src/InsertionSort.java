import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InsertionSort {
    void insertionSort(int array[]) {
        int tamArray = array.length;
        for (int i = 1; i < tamArray; ++i) {
            int valorAtual = array[i];
            int posicao = i - 1;

            while (posicao >= 0 && array[posicao] > valorAtual) {
                array[posicao + 1] = array[posicao];
                posicao = posicao - 1;
            }
            array[posicao + 1] = valorAtual;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\eduar\\Documents\\Repos\\ConsoleTeste\\ConsoleTeste\\dataCINQUENTAMIL.txt");
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
        InsertionSort insertionSort = new InsertionSort();

        long inicio = System.nanoTime();

        insertionSort.insertionSort(numeros);

        long fim = System.nanoTime();
        tempoDeExecucao += TimeUnit.NANOSECONDS.toMillis(fim - inicio);

        System.out.println(tempoDeExecucao);
    }
}
