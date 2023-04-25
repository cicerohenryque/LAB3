package Lab3CiceroHenryquePereiraRocha;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 
import agenda.Contato;


public class Teste_Contato {
	@Test
	public void test_contato() {
		Contato contato = new Contato( "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", contato.toString());
	}
}
