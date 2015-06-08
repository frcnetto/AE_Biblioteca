package br.estacio.poo.dao;

import br.estacio.poo.classes.Livro;
import java.util.ArrayList;

public class LivroDao {
    private ArrayList<Livro> livro = new ArrayList<Livro>();
    
    public ArrayList<Livro> getLivro(){
        return livro;
    }
    
    public void setLivro(ArrayList<Livro> livro){
        this.livro = livro;        
    }
    
    public Livro criaLivro(Livro novoLivro){
        this.livro.add(novoLivro);
        return(novoLivro);
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
                if(l.getTitulo() == titulo){
                    return l;
                }
            }
        }
        return null;
    }
}
