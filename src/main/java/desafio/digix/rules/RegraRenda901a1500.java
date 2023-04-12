package desafio.digix.rules;

import java.math.BigDecimal;

import desafio.digix.model.Pessoa;

public class RegraRenda901a1500 implements RegraCasaPopular {

	public final int TRES_PONTOS = 3;
	public final int ZERO_PONTOS = 0;
	public final int MENOR_E_IGUAL_A_ZERO = 0;
	public final int MAIOR_E_IGUAL_A_ZERO = 0;

	/**
	 * Regra de negócio: 
	 * Renda total da família de 901 à 1500 reais
	 * 
	 * @author CARLOS BEZERRA
	 */
	@Override
	public Integer processar(Pessoa pessoa) {
		return pessoa.getRendaFamiliar().compareTo(BigDecimal.valueOf(901)) >= MAIOR_E_IGUAL_A_ZERO
				&& pessoa.getRendaFamiliar().compareTo(BigDecimal.valueOf(1500)) <= MENOR_E_IGUAL_A_ZERO ? TRES_PONTOS
						: ZERO_PONTOS;
	}

}
