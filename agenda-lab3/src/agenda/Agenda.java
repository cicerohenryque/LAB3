package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITO = 10;
	
	private Contato[] contatos; //apenas uma simplificacao de contato
	private Contato[] favorito;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favorito = new Contato[TAMANHO_FAVORITO];
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
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}

	public Contato[] getFavorito(){
		return this.favorito.clone();
	}

	public Contato getFavorito(int posicao){
		return favorito[posicao - 1];
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
			throw new IllegalArgumentException("CONTATO JA CADASTRADO");
		}

		else if((telefone.isEmpty()) || nome.isEmpty()){
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}

		else if(posicao <= 0 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSICAO INVALIDA");
		}
		
		else{
			this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return "CADASTRO REALIZADO";
		}
	}

	public boolean verificaExistenciaDoContato(String nome, String sobrenome){
		for (Contato contato : contatos){
			if(contato != null) {
				if(contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean verificaExistencia(int posicao) {
		if (contatos[posicao - 1] == null) {
			return false;
		}
		return true;
	}

	public String listaDeContatos(){
		String listas = "";
		for(int i = 0; i < contatos.length; i++){
			if(contatos[i] != null){
				listas += "\n" + (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
			}
		}
		return listas;
	}

	public void cadastrarFavorito(int posicaoDoContato, int posicaoDoFavorito) {
		if (posicaoDoContato <= 0 || posicaoDoContato > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVALIDA");
		} else if (posicaoDoFavorito <= 0 || posicaoDoFavorito > 10) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVALIDA");
		}
		if (contatos[posicaoDoContato - 1] == null) {
			throw new NullPointerException("POSIÇÃO INVALIDA");
		}
		if (this.favorito[posicaoDoFavorito - 1] != null){
			this.favorito[posicaoDoFavorito - 1].desfavoritar();
		}
		this.favorito[posicaoDoFavorito - 1] = this.contatos[posicaoDoContato - 1];
		this.contatos[posicaoDoContato - 1].favoritar();
	}
	
	public void removerFavorito (int posicaoDoFavorito){
		if (posicaoDoFavorito <= 0 || posicaoDoFavorito > 10){
			throw new IndexOutOfBoundsException("POSICAO INVALIDA");
		} else if (this.favorito[posicaoDoFavorito - 1] == null){
			throw new NullPointerException("POSICAO INVALIDA");
		}
		this.favorito[posicaoDoFavorito - 1].desfavoritar();
		this.favorito[posicaoDoFavorito - 1] = null;
	}

	public String listaDeFavoritos(){
		String listasFavoritos = "";
		for(int i = 0; i < contatos.length; i++){
			if(contatos[i] != null){
				listasFavoritos += "\n" + (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
			}
		}
		return listasFavoritos;
	}
	
}