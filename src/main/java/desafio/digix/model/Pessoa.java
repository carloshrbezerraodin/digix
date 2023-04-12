package desafio.digix.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private BigDecimal rendaFamiliar;
	private List<Dependente> dependentes;
	private Integer pontuacao;

	@Override
	public int compareTo(Pessoa outraPessoa) {
		if (this.pontuacao > outraPessoa.pontuacao) {
			return -1;
		}
		if (this.pontuacao < outraPessoa.pontuacao) {
			return 1;
		}
		return 0;
	}

}
