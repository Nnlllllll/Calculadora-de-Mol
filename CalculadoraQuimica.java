import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraQuimica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Massa Molar");

        // 1. Coleta da fórmula (opcional, apenas para exibição)
        System.out.print("Digite a fórmula química (exemplo: H2O): ");
        String formula = scanner.nextLine().toUpperCase();

        // 2. Coleta da quantidade de elementos distintos
        System.out.print("Digite a quantidade de elementos distintos na substância: ");
        int numElementos = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        if (numElementos <= 0) {
            System.out.println("Erro: A quantidade de elementos deve ser positiva!");
            scanner.close();
            return;
        }

        // 3. Coleta de informações de cada elemento
        Map<String, Double> massasAtomicas = new HashMap<>();
        Map<String, Integer> quantidades = new HashMap<>();

        for (int i = 1; i <= numElementos; i++) {
            System.out.printf("Elemento %d:%n", i);
            System.out.print("  Nome do elemento (exemplo: H, O): ");
            String elemento = scanner.nextLine().toUpperCase();

            System.out.print("  Massa atômica em u (exemplo: 1.008 para H): ");
            double massaAtomica = scanner.nextDouble();
            if (massaAtomica <= 0) {
                System.out.println("Erro: Massa atômica deve ser positiva!");
                scanner.close();
                return;
            }

            System.out.print("  Quantidade na fórmula (exemplo: 2 para H em H2O): ");
            int quantidade = scanner.nextInt();
            if (quantidade <= 0) {
                System.out.println("Erro: Quantidade deve ser positiva!");
                scanner.close();
                return;
            }
            scanner.nextLine(); // Limpar buffer

            massasAtomicas.put(elemento, massaAtomica);
            quantidades.put(elemento, quantidade);
        }

        // 4. Criação e execução do cálculo
        CalculoQuimico calculo = new MassaMolar(formula, massasAtomicas, quantidades);
        calculo.calcular();

        scanner.close();
    }
}