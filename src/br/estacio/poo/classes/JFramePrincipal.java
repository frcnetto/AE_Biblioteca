package br.estacio.poo.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

import br.estacio.poo.util.JMoneyField;
import br.estacio.poo.util.ValidaCampos;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JFramePrincipal extends JFrame implements ActionListener, MouseListener, KeyListener{
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
	private JFormattedTextField tfISBN;
	private MaskFormatter mascISBN;
	private JTextField tfNumeroPaginas;
	private JMoneyField tfValor;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JLabel lblNumeroDePaginas;
	private JLabel lblValor;
	private Biblioteca biblioteca;
	private JButton btnEditar;
	private Livro existente;
	private JButton btnAtualizar;
	private ValidaCampos valida;
	private JButton btnLimparDetalhes;
	private JScrollPane scrollPane;
	private JLabel lblQtdTotal;
	
	public JFramePrincipal() {
		initComponents();
	}
	
	private void initComponents(){
		getContentPane().setLayout(null);
		
		valida = new ValidaCampos();
		
		biblioteca = new Biblioteca();
		biblioteca.setNome("Biblioteca");
        biblioteca.setLocal("FIC");
        biblioteca.setCapacidade(25);
		
		lblListaDeLivros = new JLabel("Lista de Livros cadastrados");
		lblListaDeLivros.setBounds(10, 11, 158, 16);
		getContentPane().add(lblListaDeLivros);
		
		spListaDeLivros = new JScrollPane();
		spListaDeLivros.setBounds(10, 34, 207, 410);
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
		
		btnRemoverLivroSelecionado = new JButton("Remover livro selecionado");
		btnRemoverLivroSelecionado.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/delete.gif")));
		btnRemoverLivroSelecionado.addActionListener(this);
		btnRemoverLivroSelecionado.setBounds(227, 408, 207, 28);
		getContentPane().add(btnRemoverLivroSelecionado);
		
		btnRemoverTodos = new JButton("Remover todos");
		btnRemoverTodos.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/1cancel.png")));
		btnRemoverTodos.addActionListener(this);
		btnRemoverTodos.setBounds(227, 442, 207, 28);
		getContentPane().add(btnRemoverTodos);
		
		lbAdicionarLivro = new JLabel("Adicionar Livro");
		lbAdicionarLivro.setBounds(448, 11, 205, 14);
		getContentPane().add(lbAdicionarLivro);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/0cad.gif")));
		btnAdicionar.setSelectedIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/0cad.gif")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(444, 305, 238, 26);
		getContentPane().add(btnAdicionar);
		
		btnAdicionarDepoisDo = new JButton("Adicionar depois do selecionado");
		btnAdicionarDepoisDo.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/insert_right.gif")));
		btnAdicionarDepoisDo.addActionListener(this);
		btnAdicionarDepoisDo.setBounds(444, 374, 238, 26);
		getContentPane().add(btnAdicionarDepoisDo);
		
		btnAdicionarAntesDo = new JButton("Adicionar antes do selecionado");
		btnAdicionarAntesDo.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/insert_left.gif")));
		btnAdicionarAntesDo.addActionListener(this);
		btnAdicionarAntesDo.setBounds(444, 408, 238, 26);
		getContentPane().add(btnAdicionarAntesDo);
		
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/clear.png")));
		btnLimparCampos.addActionListener(this);
		btnLimparCampos.setBounds(444, 442, 143, 26);
		getContentPane().add(btnLimparCampos);
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/exit.png")));
		btnSair.addActionListener(this);
		btnSair.setBounds(591, 442, 91, 26);
		getContentPane().add(btnSair);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(448, 36, 205, 14);
		getContentPane().add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(444, 57, 238, 20);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(448, 84, 205, 14);
		getContentPane().add(lblAutor);
		
		tfAutor = new JTextField("");
		tfAutor.addKeyListener(this);
		tfAutor.setBounds(444, 104, 238, 20);
		getContentPane().add(tfAutor);
		tfAutor.setColumns(10);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(448, 133, 205, 14);
		getContentPane().add(lblIsbn);
		
		try {
			mascISBN = new MaskFormatter("### - ## - ### - #### - #");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tfISBN = new JFormattedTextField(mascISBN);
		tfISBN.setBounds(444, 153, 238, 20);
		getContentPane().add(tfISBN);
		tfISBN.setColumns(10);
		
		lblNumeroDePaginas = new JLabel("Numero de Paginas");
		lblNumeroDePaginas.setBounds(448, 184, 205, 14);
		getContentPane().add(lblNumeroDePaginas);
		
		tfNumeroPaginas = new JTextField();
		tfNumeroPaginas.setColumns(10);
		tfNumeroPaginas.addKeyListener(this);
		tfNumeroPaginas.setBounds(444, 204, 238, 20);
		getContentPane().add(tfNumeroPaginas);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(448, 235, 205, 14);
		getContentPane().add(lblValor);
		
		tfValor = new JMoneyField();
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValor.setBounds(444, 260, 238, 20);
		getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		btnEditar = new JButton("Editar Livro");
		btnEditar.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/edit.png")));
		btnEditar.addActionListener(this);
		btnEditar.setBounds(227, 374, 207, 28);
		getContentPane().add(btnEditar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/refresh.png")));
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(this);
		btnAtualizar.setBounds(444, 340, 238, 26);
		getContentPane().add(btnAtualizar);
		
		btnLimparDetalhes = new JButton("Limpar detalhes");
		btnLimparDetalhes.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/br/estacio/poo/images/clear.png")));
		btnLimparDetalhes.addActionListener(this);
		btnLimparDetalhes.setBounds(227, 340, 207, 28);
		getContentPane().add(btnLimparDetalhes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 34, 211, 294);
		getContentPane().add(scrollPane);
		
		taDetalhes = new JTextArea("");
		scrollPane.setViewportView(taDetalhes);
		taDetalhes.setEditable(false);
		
		lblQtdTotal = new JLabel(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
		lblQtdTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQtdTotal.setBounds(10, 445, 207, 16);
		getContentPane().add(lblQtdTotal);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(725, 501);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("S.O.L - Sistema de Organização de Livros. " + biblioteca.getNome() + " - " + biblioteca.getLocal());
		setVisible(true);
	}
	
	private boolean validaCampos(){
		return (tfTitulo.getText().isEmpty()) || (tfAutor.getText().isEmpty()) || (tfISBN.getText().equals(" -  -  -  - ") || (tfNumeroPaginas.getText().isEmpty())) || (tfValor.getText().isEmpty());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionar){
			if(!validaCampos() && (mdlListaDeLivros.getSize() < biblioteca.getCapacidade())){
				Livro livro = new Livro();
				
				livro.setCodigo(mdlListaDeLivros.size() + 1);
	            livro.setTitulo(tfTitulo.getText());
	            livro.setAutor(tfAutor.getText());
	            livro.setISBN(tfISBN.getText());
	            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
	            livro.setValorCompra(tfValor.getText());
				
	            biblioteca.criaLivro(livro);
	            mdlListaDeLivros.addElement(livro.getTitulo());
	            lblQtdTotal.setText(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
	            lblQtdTotal.repaint();
			} else{
				JOptionPane.showMessageDialog(null, "Algum campo em branco ou biblioteca lotada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnAdicionarAntesDo){
			if(!validaCampos() && (mdlListaDeLivros.getSize() < biblioteca.getCapacidade())){
				Livro livro = new Livro();       
				
	            livro.setCodigo(mdlListaDeLivros.size() + 1);
	            livro.setTitulo(tfTitulo.getText());
	            livro.setAutor(tfAutor.getText());
	            livro.setISBN(tfISBN.getText());
	            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
	            livro.setValorCompra(tfValor.getText());
	            
	            biblioteca.criaLivro(livro);
	            mdlListaDeLivros.add(lstListaDeLivros.getSelectedIndex(),livro.getTitulo());
	            lblQtdTotal.setText(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
	            lblQtdTotal.repaint();
			} else{
				JOptionPane.showMessageDialog(null, "Algum campo em branco ou biblioteca lotada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnAdicionarDepoisDo){
			if(!validaCampos() && (mdlListaDeLivros.getSize() < biblioteca.getCapacidade())){
				Livro livro = new Livro();   
				
	            livro.setCodigo(mdlListaDeLivros.size() + 1);
	            livro.setTitulo(tfTitulo.getText());
	            livro.setAutor(tfAutor.getText());
	            livro.setISBN(tfISBN.getText());
	            livro.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
	            livro.setValorCompra(tfValor.getText());
	            
	            biblioteca.criaLivro(livro);
	            mdlListaDeLivros.add(lstListaDeLivros.getSelectedIndex() + 1,livro.getTitulo());
	            lblQtdTotal.setText(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
	            lblQtdTotal.repaint();
			} else{
				JOptionPane.showMessageDialog(null, "Algum campo em branco ou biblioteca lotada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnAtualizar){
			if(!validaCampos()){
				existente.setTitulo(tfTitulo.getText());
				existente.setAutor(tfAutor.getText());
				existente.setISBN(tfISBN.getText());
				existente.setNumPaginas(Integer.parseInt(tfNumeroPaginas.getText()));
				existente.setValorCompra(tfValor.getText());
				
				biblioteca.addEm(existente.getCodigo() - 1, existente);
				biblioteca.removeEm(existente.getCodigo());
				mdlListaDeLivros.add(existente.getCodigo() - 1, existente.getTitulo());
				mdlListaDeLivros.remove(existente.getCodigo());
				btnAtualizar.setEnabled(false);
				btnAdicionar.setEnabled(true);
			} else{
				JOptionPane.showMessageDialog(null, "Algum campo em branco!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnLimparDetalhes){
			taDetalhes.setText("");
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
				JOptionPane.showMessageDialog(null, "Nenhum livro aberto! Clique duas vezes para abrir um livro.", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(e.getSource() == btnRemoverLivroSelecionado){
			if((lstListaDeLivros.getSelectedIndex() >= 0) && (lstListaDeLivros.getSelectedIndex() < mdlListaDeLivros.getSize())){
				if(JOptionPane.showConfirmDialog(null, "Deseja apagar o livro selecionado?", "Excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					biblioteca.removeEm(lstListaDeLivros.getSelectedIndex());
					mdlListaDeLivros.remove(lstListaDeLivros.getSelectedIndex());
					lblQtdTotal.setText(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
		            lblQtdTotal.repaint();
				}
			} else{
				JOptionPane.showMessageDialog(null, "Nenhum livro selecionado", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnRemoverTodos){
			if(mdlListaDeLivros.getSize() > 0){
				if(JOptionPane.showConfirmDialog(null, "Deseja apagar todos os valores?", "Excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					biblioteca.limpaLivros();
					mdlListaDeLivros.clear();
					lblQtdTotal.setText(mdlListaDeLivros.getSize() + "/" + biblioteca.getCapacidade());
		            lblQtdTotal.repaint();
				}
			} else{
				JOptionPane.showMessageDialog(null, "Biblioteca vazia!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnSair){
			if(JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
				System.exit(0);
			}
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
			if(e.getClickCount() == 2){
				Livro livro = biblioteca.buscaCod(lstListaDeLivros.getSelectedIndex() + 1);
				taDetalhes.setText(
						"Codigo:\t" + livro.getCodigo() + "\n" +
						"Titulo:\t" + livro.getTitulo() + "\n" +
						"Autor:\t" + livro.getAutor() + "\n" +
						"ISBN:\t" + livro.getISBN() + "\n" +
						"N. de Paginas:\t" + livro.getNumPaginas() + "\n" +
						"R$:\t" + livro.getValorCompra()
						);
			}
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == tfNumeroPaginas){
			valida.validaSomenteCom(valida.NUMEROS, e);
		} else if(e.getSource() == tfAutor){
			valida.validaSomenteCom(valida.LETRAS + valida.ACENTOS + valida.ESPACO + ".,", e);
		}
	}
}
