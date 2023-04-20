package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos; //apenas uma simplificacao de contato

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		return contatos[posicao - 1].toString();
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if(verificaExistenciaDoContato(nome, sobrenome)){
			throw new IllegalArgumentException("CONTATO JA CADASTRADO")
		}

		else if((telefone.equals("")) || nome.equals("")){
			throw new IllegalArgumentException("CONTATO INVALIDO")
		}

		else if(posicao <= 0 || posicao > 100) {
			trow new IllegalArgumentException("POSICAO INVALIDA")
		}
		
		else{
			this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return "CONTATO CADASTRADO";
		}
	}

	public boolean verificaExistenciaDoContato(String nome, String sobrenome){
		for(int i = 0; i < contatos.length; i++){
			if(contatos[i] != null) {
				if(contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean verifivaPosicao(int posicao){
		if(contatos[posicao - 1] == null){
			return false;
		}
		return true;
	}

	public String listaDeContatos(){
		String listas = "\n"
		for(int i = 0; i <c ontatos.length; i++){
			if(contatos[i] != null){
				listas += (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n"
			}
		}
		return listas;
	}
	
}
