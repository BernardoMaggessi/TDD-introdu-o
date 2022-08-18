package TDD_Test.course;

import java.util.ArrayList;
import java.util.List;

import TDD_Test.course.exceptions.CadastroVazioException;
import TDD_Test.course.exceptions.PessoaSemNomeException;

public class CadastroPessoa {
	
	public CadastroPessoa() {
		this.pessoas = new ArrayList<>();
	}
	
	public List<Pessoa> pessoas;
	
	List<Pessoa> getPessoas(){
		return this.pessoas;
	}

	public void adicionar(Pessoa pessoa) {
		if(pessoa.getNome() == null) {
			throw new PessoaSemNomeException();
		}
		this.pessoas.add(pessoa);
		
	}

	public void remover(Pessoa pessoa) {
		if(!this.pessoas.contains(pessoa)) {
			throw new CadastroVazioException();
		}
		this.pessoas.remove(pessoa);
		
	}
}
