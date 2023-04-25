package Lab3CiceroHenryquePereiraRocha;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 
import agenda.Agenda;
public class Teste_Agenda {
	
	/**
	 * testes de cadastrar
	 */
	@Test
	public void test() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("CADASTRO REALIZADO", minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	public void test1() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CADASTRO REALIZADO", minhaAgenda.cadastraContato(1, "Pedro", "Silva", "(84) 01235-0000"));
		
	}
	@Test
	public void test3() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO JÁ CADASTRADO", minhaAgenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000"));
		
	}
	@Test
	public void test4() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("CADASTRO REALIZADO", minhaAgenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	public void test5() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("POSIÇÃO INVÁLIDA", minhaAgenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	public void test6() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("POSIÇÃO INVÁLIDA", minhaAgenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	public void test7() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("TELEFONE NÃO PODE SER VAZIO", minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", ""));
	}
	@Test
	public void test8() {
		Agenda minhaAgenda = new Agenda();
		assertEquals("NOME ESTÁ VAZIO", minhaAgenda.cadastraContato(1,"", "Gaudencio", "(83) 99999-0000"));
	}
	
	/**
	 * Testes de exibir
	 */
	@Test
	public void test_exibir1() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", minhaAgenda.getContato(1));
	}
	@Test
	public void test_exibir2() {
		Agenda minhaAgenda = new Agenda();
		assertEquals( null , minhaAgenda.getContato(100));
	}

	
	@Test
	public void test_exibir3() {
		Agenda minhaAgenda = new Agenda();
		assertEquals( null , minhaAgenda.getContato(0));
	}
	@Test
	public void test_exibir4() {
		Agenda minhaAgenda = new Agenda();
		assertEquals( null , minhaAgenda.getContato(101));
	}
	
	@Test
	public void test_exibir5() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		minhaAgenda.adicionarContatoFavorito(1, 1);
		assertEquals( "❤️ Matheus Gaudencio\n(83) 99999-0000" , minhaAgenda.getContato(1));
	}
	/**
	 * Teste de listar contato
	 */
	@Test
	public void teste_cadastrarFavorito1() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", minhaAgenda.adicionarContatoFavorito(1, 1));
	}
	
	@Test
	public void teste_cadastrarFavorito2() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO NÃO EXISTE", minhaAgenda.adicionarContatoFavorito(5, 1));
	}
	
	@Test
	public void teste_cadastrarFavorito3() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("POSICAO DO CONTATO OU POSICAO DO FAVORITO INVÁLIDA", minhaAgenda.adicionarContatoFavorito(1, 0));
	}
	
	/**
	 * Remover Favorito
	 */
	@Test
	public void teste_RemoverFavorito() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		minhaAgenda.adicionarContatoFavorito(1, 1);
		assertEquals(true, minhaAgenda.removerContatoFavorito(1));	
	}
	
	@Test
	public void teste_RemoverFavorito2() {
		Agenda minhaAgenda = new Agenda();
		minhaAgenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		minhaAgenda.adicionarContatoFavorito(1, 1);
		assertEquals(false, minhaAgenda.removerContatoFavorito(2));	
	}
}
