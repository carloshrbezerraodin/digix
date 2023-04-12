package desafio.digix.rules;

import java.util.ArrayList;
import java.util.List;

import desafio.digix.model.Pessoa;

public class RegraCasaPopularEvaluator {
	
	public final int ZERO_PONTO = 0;

	private List<RegraCasaPopular> casaPopularRules = new ArrayList<>();

	/**
	 * Método responsável pela adição de regras da CASA POPULAR
	 * 
	 * @author CARLOS BEZERRA
	 * @versino 1.0.0
	 */
	public RegraCasaPopularEvaluator() {
		casaPopularRules.add(new RegraRenda900());
		casaPopularRules.add(new RegraRenda901a1500());
		casaPopularRules.add(new RegraDependente());
	}

	public int evaluate(Pessoa pessoa) {
		int pontos = ZERO_PONTO;
		for (RegraCasaPopular casaPopularRule : casaPopularRules) {
			pontos += casaPopularRule.processar(pessoa);
		}
		return pontos;
	}

}
