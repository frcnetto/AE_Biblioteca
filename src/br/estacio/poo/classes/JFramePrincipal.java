package br.estacio.poo.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class JFramePrincipal extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = -4430577209403556868L;
	private JLabel lbAdicionarLivro;
	private JLabel lblListaDeLivros;
	private JScrollPane spListaDeLivros;
	private JLabel lblDetalhes;
	private JTextArea taDetalhes;
	private JButton btnRemoverLivroSelecionado;
	private JButton btnRemoverTodos;
	private JButton btnAdicionar;
	private JButton btnAdicionarDepoisDo;
	private JButton btnAdicionarAntesDo;
	private JButton btnLimparCampos;
	private JButton btnSair;
	private JList<String> lstListaDeLivros;
	private DefaultListModel<String> mdlListaDeLivros;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfISBN;
	private JTextField tfNumeroPaginas;
	private JTextField tfValor;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JLabel lblNumeroDePaginas;
	private JLabel lblValor;
	private Biblioteca biblioteca;
	private JButton btnEditar;
	private Livro existente;
	private JButton btnAtualizar;
	
	public JFramePrincipal() {
		initComponents();
		
		biblioteca.setNome(JOptionPane.showInputDialog("Informe o nome da biblioteca:"));
        biblioteca.setLocal(JOptionPane.showInputDialog("Informe o local da biblioteca:"));
        biblioteca.setCapacidade(Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade(em livros) da biblioteca:")));
	}
	
	private void initComponents(){
		getContentPane().setLayout(null);
		
		biblioteca = new Biblioteca();
		
		lblListaDeLivros = new JLabel("Lista de Livros cadastrados");
		lblListaDeLivros.setBounds(10, 11, 130, 14);
		getContentPane().add(lblListaDeLivros);
		
		spListaDeLivros = new JScrollPane();
		spListaDeLivros.setBounds(10, 34, 207, 431);
		getContentPane().add(spListaDeLivros);
		
		lstListaDeLivros = new JList<String>();
		mdlListaDeLivros = new DefaultListModel<String>();
		lstListaDeLivros.setModel(mdlListaDeLivros);
		lstListaDeLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstListaDeLivros.addMouseListener(this);
		spListaDeLivros.setViewportView(lstListaDeLivros);
		
		lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setBounds(227, 11, 207, 14);
		getContentPane().add(lblDetalhes);
		
		taDetalhes = new JTextArea("");
		taDetalhes.setEditable(false);
		taDetalhes.setBounds(227, 34, 207, 329);
		getContentPane().add(taDetalhes);
		
		btnRemoverLivroSelecionado = new JButton("Remover livro selecionado");
		btnRemoverLivroSelecionado.addActionListener(this);
		btnRemoverLivroSelecionado.setBounds(227, 408, 207, 23);
		getContentPane().add(btnRemoverLivroSelecionado);
		
		btnRemoverTodos = new JButton("Remover todos");
		btnRemoverTodos.addActionListener(this);
		btnRemoverTodos.setBounds(227, 442, 207, 23);
		getContentPane().add(btnRemoverTodos);
		
		lbAdicionarLivro = new JLabel("Adicionar Livro");
		lbAdicionarLivro.setBounds(448, 11, 205, 14);
		getContentPane().add(lbAdicionarLivro);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(444, 305, 209, 23);
		getContentPane().add(btnAdicionar);
		
		btnAdicionarDepoisDo = new JButton("Adicionar depois do selecionado");
		btnAdicionarDepoisDo.addActionListener(this);
		btnAdicionarDepoisDo.setBounds(444, 374, 209, 23);
		getContentPane().add(btnAdicionarDepoisDo);
		
		btnAdicionarAntesDo = new JButton("Adicionar antes do selecionado");
		btnAdicionarAntesDo.addActionListener(this);
		btnAdicionarAntesDo.setBounds(444, 408, 209, 23);
		getContentPane().add(btnAdicionarAntesDo);
		
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(this);
		btnLimparCampos.setBounds(444, 442, 103, 23);
		getContentPane().add(btnLimparCampos);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(557, 442, 96, 23);
		getContentPane().add(btnSair);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(448, 36, 205, 14);
		getContentPane().add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(444, 57, 209, 20);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(448, 84, 205, 14);
		getContentPane().add(lblAutor);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(444, 104, 209, 20);
		getContentPane().add(tfAutor);
		tfAutor.setColumns(10);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(448, 133, 205, 14);
		getContentPane().add(lblIsbn);
		
		tfISBN = new JTextField();
		tfISBN.setBounds(444, 153, 209, 20);
		getContentPane().add(tfISBN);
		tfISBN.setColumns(10);
		
		lblNumeroDePaginas = new JLabel("Numero de Paginas");
		lblNumeroDePaginas.setBounds(448, 184, 205, 14);
		getContentPane().add(lblNumeroDePaginas);
		
		tfNumeroPaginas = new JTextField();
		tfNumeroPaginas.setBounds(444, 204, 209, 20);
		getContentPane().add(tfNumeroPaginas);
		tfNumeroPaginas.setColumns(10);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(448, 235, 205, 14);
		getContentPane().add(lblValor);
		
		tfValor = new JTextField();
		tfValor.setBounds(444, 260, 209, 20);
		getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		btnEditar = new JButton("Editar Livro");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(227, 374, 207, 23);
		getContentPane().add(btnEditar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(this);
		btnAtualizar.setBounds(444, 340, 209, 23);
		getContentPane().add(btnAtualizar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(672, 503);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionar){
			Livro livro = new Livro();
			
			livro.setCodigo(mdlListaDeLivros.size() + 1);
            livro.setTitulo(tfTitulo.getText());
            livro.setAutor(tfAutor.getText());
            livro.setISBN(tfISBN.getText());
            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
            livro.setValorCompra(Float.parseFloat(tfValor.getText()));
			
            biblioteca.criaLivro(livro);
            mdlListaDeLivros.addElement(livro.getTitulo());
		} else if(e.getSource() == btnAdicionarAntesDo){
			Livro livro = new Livro();       
			
            livro.setCodigo(mdlListaDeLivros.size() + 1);
            livro.setTitulo(tfTitulo.getText());
            livro.setAutor(tfAutor.getText());
            livro.setISBN(tfISBN.getText());
            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
            livro.setValorCompra(Float.parseFloat(tfValor.getText()));
            
            biblioteca.criaLivro(livro);
            mdlListaDeLivros.add(lstListaDeLivros.getSelectedIndex(),livro.getTitulo());
		} else if(e.getSource() == btnAdicionarDepoisDo){
			Livro livro = new Livro();   
			
            livro.setCodigo(mdlListaDeLivros.size() + 1);
            livro.setTitulo(tfTitulo.getText());
            livro.setAutor(tfAutor.getText());
            livro.setISBN(tfISBN.getText());
            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
            livro.setValorCompra(Float.parseFloat(tfValor.getText()));
            
            biblioteca.criaLivro(livro);
            mdlListaDeLivros.add(lstListaDeLivros.getSelectedIndex() + 1,livro.getTitulo());
		} else if(e.getSource() == btnAtualizar){
			existente.setTitulo(tfTitulo.getText());
			existente.setAutor(tfAutor.getText());
			existente.setISBN(tfISBN.getText());
			existente.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
			existente.setValorCompra(Float.parseFloat(tfValor.getText()));
			
			biblioteca.addEm(existente.getCodigo() - 1, existente);
			biblioteca.removeEm(existente.getCodigo());
			mdlListaDeLivros.add(existente.getCodigo() - 1, existente.getTitulo());
			mdlListaDeLivros.remove(existente.getCodigo());
			btnAtualizar.setEnabled(false);
			btnAdicionar.setEnabled(true);
		} else if(e.getSource() == btnEditar){
			if(!taDetalhes.getText().isEmpty()){
				Livro livro = biblioteca.buscaCod(lstListaDeLivros.getSelectedIndex() + 1);
				
				tfTitulo.setText(String.valueOf(livro.getTitulo()));
				tfAutor.setText(livro.getAutor());
				tfISBN.setText(livro.getISBN());
				tfNumeroPaginas.setText(String.valueOf(livro.getNumPaginas()));
				tfValor.setText(String.valueOf(livro.getValorCompra()));
				
				btnAtualizar.setEnabled(true);
				btnAdicionar.setEnabled(false);
				existente = livro;
			} else{
				JOptionPane.showMessageDialog(null, "Nenhum livro selecionado", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(e.getSource() == btnRemoverLivroSelecionado){
			biblioteca.removeEm(lstListaDeLivros.getSelectedIndex());
			mdlListaDeLivros.remove(lstListaDeLivros.getSelectedIndex());
		} else if(e.getSource() == btnRemoverTodos){
			biblioteca.limpaLivros();
			mdlListaDeLivros.clear();
		} else if(e.getSource() == btnSair){
			System.exit(0);
		} else if(e.getSource() == btnLimparCampos){
			tfTitulo.setText("");
			tfAutor.setText("");
			tfISBN.setText("");
			tfNumeroPaginas.setText("");
			tfValor.setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lstListaDeLivros){
			Livro livro = biblioteca.buscaCod(lstListaDeLivros.getSelectedIndex() + 1);
			taDetalhes.setText(
					"Codigo.............:" + livro.getCodigo() + "\n" +
					"Titulo.............:" + livro.getTitulo() + "\n" +
					"Autor..............:" + livro.getAutor() + "\n" +
					"ISBN...............:" + livro.getISBN() + "\n" +
					"Numero de Paginas..:" + livro.getNumPaginas() + "\n" +
					"R$.................:" + livro.getValorCompra()
					);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
