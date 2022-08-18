package TDD_Test.course;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import TDD_Test.course.exceptions.CadastroVazioException;
import TDD_Test.course.exceptions.PessoaSemNomeException;

public class CadastroPessoasTest {
	
	@Test
	@DisplayName("Deve criar o cadastro de pessoas")
	public void deveCriarCadastroDePessoas() {
		//cenario e execução
		CadastroPessoa cadastro = new CadastroPessoa();
		
		//verificação
		Assertions.assertThat(cadastro.getPessoas()).isEmpty();
	}
	@Test
	@DisplayName("adiciona uma pessoa")
	public void deveAdicionarUmaPessoa() {
		CadastroPessoa cadastroPessoas = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bernardo");
		
		cadastroPessoas.adicionar(pessoa);
		
		Assertions.assertThat(cadastroPessoas.getPessoas())
		.isNotEmpty()
		.hasSize(1)
		.contains(pessoa);
	}
	@Test
	@DisplayName(" nao adiciona uma pessoa com nome vazio")
	public void naoDeveAdicionarPessoaComNomeVazio() {
		CadastroPessoa cadastroPessoas = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		
		org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeException.class,() -> cadastroPessoas.adicionar(pessoa));
	}
	@Test
	@DisplayName("remove uma pessoa")
	public void deveRemoverUmaPessoa() {
		
		CadastroPessoa cadastroPessoas = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Wilson");
		cadastroPessoas.adicionar(pessoa);
		
		cadastroPessoas.remover(pessoa);
		
		Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
	}
	@Test
	@DisplayName("lança erro ao tentar remover pessoa inexistente")
	public void deveLancarErroAoTentarRemoverPessoaInexistente() {
		
		CadastroPessoa cadastroPessoas = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		
		org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class,() -> cadastroPessoas.remover(pessoa));
	}
}
