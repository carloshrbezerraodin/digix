package desafio.digix.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import desafio.digix.model.Dependente;
import desafio.digix.model.Pessoa;
import desafio.digix.rules.RegraCasaPopularEvaluator;

@Service
public class PessoaService {

	public List<Pessoa> preencherPessoas() {

		List<Dependente> depentendes = Arrays.asList(Dependente.builder().idade(19).build(),
				Dependente.builder().idade(20).build(), Dependente.builder().idade(21).build());

		List<Dependente> depentendes2 = Arrays.asList(Dependente.builder().idade(19).build(),
				Dependente.builder().idade(20).build(), Dependente.builder().idade(21).build());
		
		List<Dependente> depentendes3 = Arrays.asList(Dependente.builder().idade(17).build(),
				Dependente.builder().idade(20).build(), Dependente.builder().idade(21).build());

		Pessoa pessoa1 = Pessoa.builder().nome("Carlos Henrique").rendaFamiliar(new BigDecimal(900))
				.dependentes(depentendes).build();
		Pessoa pessoa2 = Pessoa.builder().nome("Paulo Cesar").rendaFamiliar(new BigDecimal(901))
				.dependentes(depentendes2).build();
		Pessoa pessoa3 = Pessoa.builder().nome("Maria Souza").rendaFamiliar(new BigDecimal(1200))
				.dependentes(depentendes3).build();
		return Arrays.asList(pessoa1, pessoa2, pessoa3);
	}

	/**
	 * Método responsável pelo procedssamento das regras da Casa Popular em um
	 * conjunto de pessoas
	 * 
	 * @author CARLOS BEZERRA
	 * @return List<Pessoa>
	 */
	public List<Pessoa> regraCasaPopular() {

		List<Pessoa> pessoasAplicadaRegras = new ArrayList<Pessoa>();

		for (Pessoa pessoa : preencherPessoas()) {
			RegraCasaPopularEvaluator familiaEvaluator = new RegraCasaPopularEvaluator();
			int pontuacao = familiaEvaluator.evaluate(pessoa);
			pessoa.setPontuacao(pontuacao);
			pessoasAplicadaRegras.add(pessoa);
		}

		Collections.sort(pessoasAplicadaRegras);
		return pessoasAplicadaRegras;
	}

}
