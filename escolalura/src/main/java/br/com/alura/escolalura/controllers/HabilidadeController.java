package br.com.alura.escolalura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alura.escolalura.models.Aluno;
import br.com.alura.escolalura.models.Habilidade;
import br.com.alura.escolalura.repositorys.AlunoRepository;

@Controller
public class HabilidadeController {

	@Autowired
	private AlunoRepository repository;

	@GetMapping("/habilidade/cadastrar/{id}")
	public String cadastrar(@PathVariable String id, Model model) {

		Aluno aluno = repository.obterAlunoPorId(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("habilidade", new Habilidade());

		return "habilidade/cadastrar";
	}

}
