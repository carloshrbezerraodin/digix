package desafio.digix.rules;

import desafio.digix.model.Dependente;
import desafio.digix.model.Pessoa;

public class RegraDependente implements RegraCasaPopular {

	public final int IDADE_18_ANOS = 18;
	public final int UMA_QUANTIDADE = 1;
	public final int ZERO_QUANTIDADE = 0;
	public final int QUANTIDADE_DEPENDENTE_UM = 1;
	public final int QUANTIDADE_DEPENDENTE_DOIS = 2;
	public final int QUANTIDADE_DEPENDENTE_TRES = 3;
	public final int DOIS_PONTOS = 2;
	public final int TRES_PONTOS = 3;
	public final int ZERO_PONTOS = 0;

	/**
	 * Regra de negócio: 
	 * Famílias com 3 ou mais dependentes (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
	 * Famílias com 1 ou 2 dependentes (lembrando que dependentes a partir de 18 anos não contam) - valendo 2 pontos.
	 * 
	 * @author CARLOS BEZERRA
	 */
	@Override
	public Integer processar(Pessoa pessoa) {
		int quantidade = 0;
		for (Dependente dependente : pessoa.getDependentes()) {
			quantidade += dependente.getIdade() > IDADE_18_ANOS ? UMA_QUANTIDADE : ZERO_QUANTIDADE;
		}
		return quantidade == QUANTIDADE_DEPENDENTE_UM || quantidade == QUANTIDADE_DEPENDENTE_DOIS ? DOIS_PONTOS
				: quantidade == QUANTIDADE_DEPENDENTE_TRES ? TRES_PONTOS : ZERO_PONTOS;
	}

}
