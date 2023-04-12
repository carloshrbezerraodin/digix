package desafio.digix.rules;

import java.math.BigDecimal;

import desafio.digix.model.Pessoa;

public class RegraRenda900 implements RegraCasaPopular {
	
	public final int CINCO_PONTOS = 5;
	public final int ZERO_PONTOS = 0;
	public final int MENOR_IGUAL_A_ZERO = 0;
	
	/**
	 * Regra de negócio: 
	 * Renda total da família até 900 reais
	 * 
	 * @author CARLOS BEZERRA
	 */
	@Override
	public Integer processar(Pessoa pessoa) {
		return pessoa.getRendaFamiliar().compareTo(BigDecimal.valueOf(900)) <= MENOR_IGUAL_A_ZERO ? CINCO_PONTOS : ZERO_PONTOS;
	}

}
