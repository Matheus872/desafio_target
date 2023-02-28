//4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
//
//SP – R$67.836,43
//RJ – R$36.678,66
//MG – R$29.229,88
//ES – R$27.165,48
//Outros – R$19.849,53

public class FaturamentoEstados {

    public static void main(String[] args) {
        // Faturamento mensal por estado
        double faturamentoSP = 67836.43;
        double faturamentoRJ = 36678.66;
        double faturamentoMG = 29229.88;
        double faturamentoES = 27165.48;
        double faturamentoOutros = 19849.53;

        // Valor total mensal
        double valorTotal = faturamentoSP + faturamentoRJ + faturamentoMG + faturamentoES + faturamentoOutros;

        // Imprime os resultados
        System.out.println("Percentual de representação por estado:");
        System.out.println("SP: " + String.format("%.2f", calcularPercentual(faturamentoSP, valorTotal)) + "%");
        System.out.println("RJ: " + String.format("%.2f", calcularPercentual(faturamentoRJ, valorTotal)) + "%");
        System.out.println("MG: " + String.format("%.2f", calcularPercentual(faturamentoMG, valorTotal)) + "%");
        System.out.println("ES: " + String.format("%.2f", calcularPercentual(faturamentoES, valorTotal)) + "%");
        System.out.println("Outros: " + String.format("%.2f", calcularPercentual(faturamentoOutros, valorTotal)) + "%");
    }

    public static double calcularPercentual(double faturamentoEstado, double faturamentoTotal) {    //Calcula percentual de representação do estado
        return (faturamentoEstado/faturamentoTotal)*100;
    }

}