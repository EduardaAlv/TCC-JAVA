import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class BubbleSort {
    void bubbleSort(int array[]) {
        int tamArray = array.length;
        for (int i = 0; i < tamArray - 1; i++)
            for (int j = 0; j < tamArray - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int valor = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = valor;
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
        BubbleSort bubbleSort = new BubbleSort();

        long inicio = System.nanoTime();

        bubbleSort.bubbleSort(numeros);

        long fim = System.nanoTime();
        tempoDeExecucao += TimeUnit.NANOSECONDS.toMillis(fim - inicio);

        System.out.println(tempoDeExecucao);
    }
}
