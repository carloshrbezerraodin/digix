package desafio.digix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.digix.model.Pessoa;
import desafio.digix.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping("/pessoas")
	List<Pessoa> all() {
		return pessoaService.regraCasaPopular();
	}

}
