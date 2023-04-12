package desafio.digix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import desafio.digix.model.Dependente;
import desafio.digix.model.Pessoa;
import desafio.digix.rules.RegraDependente;
import desafio.digix.rules.RegraRenda900;
import desafio.digix.rules.RegraRenda901a1500;

public class RegraPopularTest {

	public final int TRES_PONTOS = 3;
	public final int CINCO_PONTOS = 5;
	public final int ZERO_PONTOS = 0;

	private Pessoa pessoa;

	RegraPopularTest() {
		List<Dependente> depentendes = Arrays.asList(Dependente.builder().idade(19).build(),
				Dependente.builder().idade(20).build(), Dependente.builder().idade(21).build());
		this.pessoa = Pessoa.builder().nome("Carlos Henrique").rendaFamiliar(new BigDecimal(900))
				.dependentes(depentendes).build();
	}

	@Test
	public void regraDependente() {

		RegraDependente regraDependente = new RegraDependente();
		Integer pontos = regraDependente.processar(this.pessoa);

		assertTrue(pontos == TRES_PONTOS);
	}

	@Test
	public void regraRenda900() {

		RegraRenda900 regraRenda900 = new RegraRenda900();
		Integer pontos = regraRenda900.processar(this.pessoa);

		assertTrue(pontos == CINCO_PONTOS);
	}

	@Test
	public void regraRenda901a1500() {

		RegraRenda901a1500 regraRenda901a1500 = new RegraRenda901a1500();
		Integer pontos = regraRenda901a1500.processar(this.pessoa);

		assertTrue(pontos == ZERO_PONTOS);
	}

}
