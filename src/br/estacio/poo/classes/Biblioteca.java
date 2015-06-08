package br.estacio.poo.classes;
import br.estacio.poo.classes.Livro;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String local;            
    private ArrayList<Livro> livro = new ArrayList<Livro>();          
    private int capacidade;        
    private int quantidade;

    public Biblioteca() {
        
        }
        
    public Biblioteca(String nome, String local, int capacidade) {
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public int getQuantidade(){
        quantidade = livro.size();
        return quantidade;
    }
    
    public ArrayList<Livro> getLivro(){
        return livro;
    }
    
    public void setLivro(ArrayList<Livro> livro){
        this.livro = livro;        
    }
    
    public void criaLivro(Livro novoLivro){
        this.livro.add(novoLivro);
    }
    
    public ArrayList<Livro> lista(){
        return livro;
    }
    
    public Livro buscaCod(int cod){
        if(!livro.isEmpty()){
            for(Livro l : livro){
                if(l.getCodigo() == cod){
                    return l;
                }
            }
        }
        return null;
    }
    
    public Livro buscaTitulo(String titulo){
        if(!livro.isEmpty()){
            for(Livro l : livro){
                if(l.getTitulo().contains(titulo)){
                    return l;
                }
            }
        }
        return null;
    }
    public void limpaLivros(){
    	livro.clear();
    }

	public void removeEm(int selectedIndex) {
		livro.remove(selectedIndex);
	}
	
	public void addEm(int index, Livro livro) {
		this.livro.add(index, livro);
	}
	
	public void substituiEm(int index, Livro livro) {
		removeEm(index);
		addEm(index, livro);
	}
}
