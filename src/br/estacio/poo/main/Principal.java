package br.estacio.poo.main;

import br.estacio.poo.classes.JFramePrincipal;

public class Principal {
    public static void main(String[] args) {
    	new JFramePrincipal();
//            Biblioteca biblioteca = new Biblioteca();
//            int op;
//                        
//            String nome = JOptionPane.showInputDialog("Informe o nome da biblioteca:");
//            biblioteca.setNome(nome);
//            
//            String local = JOptionPane.showInputDialog("Informe o local da biblioteca:");
//            biblioteca.setLocal(local);
//            
//            int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade(em livros) da biblioteca:"));
//            biblioteca.setCapacidade(capacidade);
//            do{
//                op = Integer.parseInt(JOptionPane.showInputDialog("Biblioteca:" + biblioteca.getNome()
//                    + "\nLocalização: " + biblioteca.getLocal()
//                    + "\nCapacidade: " + biblioteca.getCapacidade()
//                    + "\n\n"
//                    + "\nOpções:"
//                    + "\n1 - Cadastrar livro."
//                    + "\n2 - Pesquizar livro por código."
//                    + "\n3 - Pesquisar livro por título."
//                    + "\n4 - Listar livros."
//                    + "\n5 - Informações."
//                    + "\n6 - Sair."));
//                switch(op){
//                    case 1:
//                        Livro livro = new Livro();                        
//                        livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do livro:")));
//                        livro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro:"));
//                        livro.setAutor(JOptionPane.showInputDialog("Informe o autor do livro:"));
//                        livro.setISBN(JOptionPane.showInputDialog("Informe o ISBN:"));
//                        livro.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("Informe o número de páginas:")));
//                        livro.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Informe o valor de compra do livro:")));
//                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
//                        biblioteca.criaLivro(livro);
//                        break;
//                    case 2:
//                        int cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código:"));
//                        Livro retCod = biblioteca.buscaCod(cod);
//                        if(retCod != null){
//                            String str = "Código: " + String.valueOf(retCod.getCodigo() + "\nTítulo: " + retCod.getTitulo() + "\nISBC: " + retCod.getISBN() + "\nAutor: " + retCod.getAutor() + "\nNúmero de páginas: " + retCod.getNumPaginas() + "\nValor de compra: R$ " + retCod.getValorCompra());
//                            JOptionPane.showMessageDialog(null, str);
//                        } else{
//                            JOptionPane.showMessageDialog(null, "Não foram encontrados livros com o código: " + cod);
//                        }
//                        break;
//                    case 3:
//                        String titulo = JOptionPane.showInputDialog("Informe o título:");
//                        Livro retTitulo = biblioteca.buscaTitulo(titulo);
//                        if(retTitulo != null){
//                            String str = "Código: " + String.valueOf(retTitulo.getCodigo() + "\nTítulo: " + retTitulo.getTitulo() + "\nISBC: " + retTitulo.getISBN() + "\nAutor: " + retTitulo.getAutor() + "\nNúmero de páginas: " + retTitulo.getNumPaginas() + "\nValor de compra: R$ " + retTitulo.getValorCompra());
//                            JOptionPane.showMessageDialog(null, str);
//                        } else{
//                            JOptionPane.showMessageDialog(null, "Não foram encontrados livros com o título: " + titulo);
//                        }
//                        break;
//                    case 4:
//                        String str = "";
//                        for(Livro lista : biblioteca.lista()){
//                            str += "Código: " + lista.getCodigo() + "\nTítulo: " + lista.getTitulo() + "\nISBC: " + lista.getISBN() + "\nAutor: " + lista.getAutor() + "\nNúmero de páginas: " + lista.getNumPaginas() + "\nValor de compra: R$ " + lista.getValorCompra() + "\n\n";
//                        }
//                        if(!biblioteca.lista().isEmpty()){
//                            JOptionPane.showMessageDialog(null, str);
//                        } else{
//                            JOptionPane.showMessageDialog(null, "Não existem livros cadastrados.");
//                        }
//                        break;
//                    case 5:
//                        JOptionPane.showMessageDialog(null, 
//                                "Biblioteca: " + biblioteca.getNome() + 
//                              "\nLocal: "      + biblioteca.getLocal() +
//                              "\nQuantidade de livros cadastrados: " + biblioteca.getQuantidade() +
//                              "\nCapacidade total: " + biblioteca.getCapacidade());
//                        break;
//                    case 6:
//                        break;
//                }
//            }while(op != 6);           
        }
        static void print(String saida){
            System.out.println(saida);
        }
}
