//3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
//• O menor valor de faturamento ocorrido em um dia do mês;
//• O maior valor de faturamento ocorrido em um dia do mês;
//• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
//
//IMPORTANTE:
//a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
//b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class FaturamentoMensal {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            InputStream is = FaturamentoMensal.class.getResourceAsStream("faturamento_mensal.json");
            Object obj = parser.parse(new InputStreamReader(is));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray faturamentoDiario = (JSONArray) jsonObject.get("faturamentoDiario");

            // converte o JSON array em um array de double
            double[] faturamento = new double[faturamentoDiario.size()];
            int diasComFaturamento = 0;
            double somaFaturamento = 0;

            for (int i = 0; i < faturamentoDiario.size(); i++) {
                faturamento[i] = Double.parseDouble(faturamentoDiario.get(i).toString());
                if (faturamento[i] > 0) { // verifica se houve faturamento no dia
                    diasComFaturamento++;
                    somaFaturamento += faturamento[i];
                }
            }

            // calcula a média mensal desconsiderando os dias sem faturamento
            double mediaMensal = somaFaturamento / diasComFaturamento;

            // encontra o menor e o maior valor de faturamento
            Arrays.sort(faturamento);
            double menorFaturamento = faturamento[0];
            double maiorFaturamento = faturamento[faturamento.length - 1];

            // conta o número de dias com faturamento superior à média mensal
            int diasAcimaDaMedia = 0;
            for (double fat : faturamento) {
                if (fat > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: R$" + menorFaturamento);
            System.out.println("Maior valor de faturamento: R$" + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}