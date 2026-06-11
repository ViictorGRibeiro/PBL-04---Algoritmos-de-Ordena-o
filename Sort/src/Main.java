import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] arquivos = {
                "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== MENU DE ALGORITMOS ===");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Rodar Todos");
        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();
        scanner.close();

        for (String arquivo : arquivos) {
            System.out.println("\nArquivo: " + arquivo);

            if (opcao == 1 || opcao == 4) {
                BufferedReader r1 = new BufferedReader(new FileReader(arquivo));
                int linhas = 0;
                String linhaLida;
                while ((linhaLida = r1.readLine()) != null) {
                    try { Integer.parseInt(linhaLida.trim()); linhas++; } catch (Exception e) {}
                }
                r1.close();

                int[] v = new int[linhas];
                BufferedReader r2 = new BufferedReader(new FileReader(arquivo));
                int index = 0;
                while ((linhaLida = r2.readLine()) != null) {
                    try { v[index++] = Integer.parseInt(linhaLida.trim()); } catch (Exception e) {}
                }
                r2.close();

                long t0 = System.nanoTime();
                for (int i = 0; i < v.length - 1; i++) {
                    for (int j = 0; j < v.length - i - 1; j++) {
                        if (v[j] > v[j + 1]) {
                            int temp = v[j];
                            v[j] = v[j + 1];
                            v[j + 1] = temp;
                        }
                    }
                }
                long t1 = System.nanoTime();
                System.out.println("Bubble Sort: " + ((t1 - t0) / 1000000.0) + " ms");
            }

            if (opcao == 2 || opcao == 4) {
                BufferedReader r1 = new BufferedReader(new FileReader(arquivo));
                int linhas = 0;
                String linhaLida;
                while ((linhaLida = r1.readLine()) != null) {
                    try { Integer.parseInt(linhaLida.trim()); linhas++; } catch (Exception e) {}
                }
                r1.close();

                int[] v = new int[linhas];
                BufferedReader r2 = new BufferedReader(new FileReader(arquivo));
                int index = 0;
                while ((linhaLida = r2.readLine()) != null) {
                    try { v[index++] = Integer.parseInt(linhaLida.trim()); } catch (Exception e) {}
                }
                r2.close();

                long t0 = System.nanoTime();
                for (int i = 1; i < v.length; i++) {
                    int chave = v[i];
                    int j = i - 1;
                    while (j >= 0 && v[j] > chave) {
                        v[j + 1] = v[j];
                        j--;
                    }
                    v[j + 1] = chave;
                }
                long t1 = System.nanoTime();
                System.out.println("Insertion Sort: " + ((t1 - t0) / 1000000.0) + " ms");
            }

            if (opcao == 3 || opcao == 4) {
                BufferedReader r1 = new BufferedReader(new FileReader(arquivo));
                int linhas = 0;
                String linhaLida;
                while ((linhaLida = r1.readLine()) != null) {
                    try { Integer.parseInt(linhaLida.trim()); linhas++; } catch (Exception e) {}
                }
                r1.close();

                int[] v = new int[linhas];
                BufferedReader r2 = new BufferedReader(new FileReader(arquivo));
                int index = 0;
                while ((linhaLida = r2.readLine()) != null) {
                    try { v[index++] = Integer.parseInt(linhaLida.trim()); } catch (Exception e) {}
                }
                r2.close();

                long t0 = System.nanoTime();

                int[] pilha = new int[v.length];
                int topo = -1;

                pilha[++topo] = 0;
                pilha[++topo] = v.length - 1;

                while (topo >= 0) {
                    int fim = pilha[topo--];
                    int inicio = pilha[topo--];

                    int pivo = v[fim];
                    int i = inicio - 1;
                    for (int j = inicio; j < fim; j++) {
                        if (v[j] <= pivo) {
                            i++;
                            int temp = v[i];
                            v[i] = v[j];
                            v[j] = temp;
                        }
                    }
                    int temp = v[i + 1];
                    v[i + 1] = v[fim];
                    v[fim] = temp;
                    int p = i + 1;

                    if (p - 1 > inicio) {
                        pilha[++topo] = inicio;
                        pilha[++topo] = p - 1;
                    }
                    if (p + 1 < fim) {
                        pilha[++topo] = p + 1;
                        pilha[++topo] = fim;
                    }
                }

                long t1 = System.nanoTime();
                System.out.println("Quick Sort: " + ((t1 - t0) / 1000000.0) + " ms");
            }
        }
    }
}