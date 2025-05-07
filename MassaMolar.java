import java.util.Map;

public class MassaMolar implements CalculoQuimico {
    private Map<String, Double> massasAtomicas;
    private Map<String, Integer> quantidades;
    private String formula;

    public MassaMolar(String formula, Map<String, Double> massasAtomicas, Map<String, Integer> quantidades) {
        this.formula = formula;
        this.massasAtomicas = massasAtomicas;
        this.quantidades = quantidades;
    }

    @Override
    public void calcular() {
        double massaTotal = 0.0;

        for (Map.Entry<String, Integer> entry : quantidades.entrySet()) {
            String elemento = entry.getKey();
            int quantidade = entry.getValue();
            Double massaAtomica = massasAtomicas.get(elemento);
            if (massaAtomica == null) {
                System.out.println("Erro: Massa atômica para " + elemento + " não fornecida!");
                return;
            }
            massaTotal += massaAtomica * quantidade;
        }

        System.out.printf("Massa molar de %s: %.2f g/mol%n", formula, massaTotal);
    }
}