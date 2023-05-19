import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class ShellSort {
    void shellSort(int array[]) {
        int tamArray = array.length;
        for (int lacuna = tamArray / 2; lacuna > 0; lacuna /= 2) {
            for (int i = lacuna; i < tamArray; i += 1) {
                int valor = array[i];
                int j;
                for (j = i; j >= lacuna && array[j - lacuna] > valor; j -= lacuna)
                    array[j] = array[j - lacuna];
                array[j] = valor;
            }
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File(
                "C:\\Users\\eduar\\Documents\\Repos\\ConsoleTeste\\ConsoleTeste\\dataTRINTAMILHOES.txt");
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
        ShellSort selectionSort = new ShellSort();

        long inicio = System.nanoTime();

        selectionSort.shellSort(numeros);

        long fim = System.nanoTime();
        tempoDeExecucao = TimeUnit.NANOSECONDS.toMillis(fim - inicio);

        System.out.println(tempoDeExecucao);
    }
}
