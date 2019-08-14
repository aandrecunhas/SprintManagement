import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class InterfaceGrafica extends JFrame {
	private JTextField jTextFieldNomeTarefa;
	private JTextField jTextFieldDescricaoTarefa;
	private JTextField jTextFieldPontoFTarefa;
	private JTextField jTextFieldNomeRH;
	private JTextField jTextFieldPFH;
	private JTextField jTextFieldCustoHora;
	private JTextField jTextFieldTamPopulacao;
	private JTextField jTextFieldQuantGeracoes;
	private JTextField jTextFieldTaxaCrossover;
	private JTextField jTextFieldTaxaMutacao;
	private DefaultListModel listModelTarefa;
	private DefaultListModel listModelRecursoHumano;
	private JButton btnSalvarRH;
	private JButton btnOk;
	private JTable table;
	private Vector data;
	private DefaultTableModel tableModelHistorico;
	private Vector<String> columns;
	private JTextField jTextFieldPesoPrazo;
	private JTextField jTextFieldPesoCusto;
	private List<List<StaticalData>> listStatical = new ArrayList<List<StaticalData>>();
	public static void main(String[] args) {
		InterfaceGrafica frame = new InterfaceGrafica();
		frame.setVisible(true);
	}
	public InterfaceGrafica() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		JLabel lblNome = new JLabel("Nome da Tarefa:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		getContentPane().add(lblNome, gbc_lblNome);
		
		jTextFieldNomeTarefa = new JTextField();
		GridBagConstraints gbc_jTextFieldNomeTarefa = new GridBagConstraints();
		gbc_jTextFieldNomeTarefa.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldNomeTarefa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldNomeTarefa.gridx = 1;
		gbc_jTextFieldNomeTarefa.gridy = 0;
		getContentPane().add(jTextFieldNomeTarefa, gbc_jTextFieldNomeTarefa);
		jTextFieldNomeTarefa.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		listModelTarefa = new DefaultListModel();
		JList listTarefas = new JList(listModelTarefa);
		scrollPane.setViewportView(listTarefas);
		
		JLabel lblDescrio = new JLabel("Descricao:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.WEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 1;
		getContentPane().add(lblDescrio, gbc_lblDescrio);
		
		jTextFieldDescricaoTarefa = new JTextField();
		GridBagConstraints gbc_jTextFieldDescricaoTarefa = new GridBagConstraints();
		gbc_jTextFieldDescricaoTarefa.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldDescricaoTarefa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldDescricaoTarefa.gridx = 1;
		gbc_jTextFieldDescricaoTarefa.gridy = 1;
		getContentPane().add(jTextFieldDescricaoTarefa, gbc_jTextFieldDescricaoTarefa);
		jTextFieldDescricaoTarefa.setColumns(10);
		
		JLabel lblPontosPorFuno = new JLabel("Pontos por Funcao (PF):");
		GridBagConstraints gbc_lblPontosPorFuno = new GridBagConstraints();
		gbc_lblPontosPorFuno.anchor = GridBagConstraints.WEST;
		gbc_lblPontosPorFuno.insets = new Insets(0, 0, 5, 5);
		gbc_lblPontosPorFuno.gridx = 0;
		gbc_lblPontosPorFuno.gridy = 2;
		getContentPane().add(lblPontosPorFuno, gbc_lblPontosPorFuno);
		
		jTextFieldPontoFTarefa = new JTextField();
		GridBagConstraints gbc_jTextFieldPontoFTarefa = new GridBagConstraints();
		gbc_jTextFieldPontoFTarefa.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldPontoFTarefa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldPontoFTarefa.gridx = 1;
		gbc_jTextFieldPontoFTarefa.gridy = 2;
		getContentPane().add(jTextFieldPontoFTarefa, gbc_jTextFieldPontoFTarefa);
		jTextFieldPontoFTarefa.setColumns(10);
		
		JButton btnSalvarTarefa = new JButton("Salvar");
		btnSalvarTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonSalvarTarefa();
			}
		});
		GridBagConstraints gbc_btnSalvarTarefa = new GridBagConstraints();
		gbc_btnSalvarTarefa.fill = GridBagConstraints.BOTH;
		gbc_btnSalvarTarefa.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvarTarefa.gridx = 2;
		gbc_btnSalvarTarefa.gridy = 2;
		getContentPane().add(btnSalvarTarefa, gbc_btnSalvarTarefa);
		
		JLabel lblNewLabel = new JLabel("------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNome_1 = new JLabel("Nome do RH:");
		GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
		gbc_lblNome_1.anchor = GridBagConstraints.WEST;
		gbc_lblNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome_1.gridx = 0;
		gbc_lblNome_1.gridy = 4;
		getContentPane().add(lblNome_1, gbc_lblNome_1);
		
		jTextFieldNomeRH = new JTextField();
		GridBagConstraints gbc_jTextFieldNomeRH = new GridBagConstraints();
		gbc_jTextFieldNomeRH.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldNomeRH.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldNomeRH.gridx = 1;
		gbc_jTextFieldNomeRH.gridy = 4;
		getContentPane().add(jTextFieldNomeRH, gbc_jTextFieldNomeRH);
		jTextFieldNomeRH.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 4;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		listModelRecursoHumano = new DefaultListModel();
		JList listRecursosHumanos = new JList(listModelRecursoHumano);
		scrollPane_1.setViewportView(listRecursosHumanos);
		
		JLabel lblPontosPorFuno_1 = new JLabel("Horas por Ponto de Funcao (H/PF):");
		GridBagConstraints gbc_lblPontosPorFuno_1 = new GridBagConstraints();
		gbc_lblPontosPorFuno_1.anchor = GridBagConstraints.WEST;
		gbc_lblPontosPorFuno_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPontosPorFuno_1.gridx = 0;
		gbc_lblPontosPorFuno_1.gridy = 5;
		getContentPane().add(lblPontosPorFuno_1, gbc_lblPontosPorFuno_1);
		
		jTextFieldPFH = new JTextField();
		GridBagConstraints gbc_jTextFieldPFH = new GridBagConstraints();
		gbc_jTextFieldPFH.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldPFH.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldPFH.gridx = 1;
		gbc_jTextFieldPFH.gridy = 5;
		getContentPane().add(jTextFieldPFH, gbc_jTextFieldPFH);
		jTextFieldPFH.setColumns(10);
		
		JLabel lblCustoPorHora = new JLabel("Custo por Hora (R$/H)");
		GridBagConstraints gbc_lblCustoPorHora = new GridBagConstraints();
		gbc_lblCustoPorHora.anchor = GridBagConstraints.WEST;
		gbc_lblCustoPorHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustoPorHora.gridx = 0;
		gbc_lblCustoPorHora.gridy = 6;
		getContentPane().add(lblCustoPorHora, gbc_lblCustoPorHora);
		
		jTextFieldCustoHora = new JTextField();
		GridBagConstraints gbc_jTextFieldCustoHora = new GridBagConstraints();
		gbc_jTextFieldCustoHora.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldCustoHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldCustoHora.gridx = 1;
		gbc_jTextFieldCustoHora.gridy = 6;
		getContentPane().add(jTextFieldCustoHora, gbc_jTextFieldCustoHora);
		jTextFieldCustoHora.setColumns(10);
		
		btnSalvarRH = new JButton("Salvar");
		btnSalvarRH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonSalvarRH();
			}
		});
		GridBagConstraints gbc_btnSalvarRH = new GridBagConstraints();
		gbc_btnSalvarRH.fill = GridBagConstraints.BOTH;
		gbc_btnSalvarRH.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvarRH.gridx = 2;
		gbc_btnSalvarRH.gridy = 6;
		getContentPane().add(btnSalvarRH, gbc_btnSalvarRH);
		
		JLabel lblNewLabel_1 = new JLabel("------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 7;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblTamanhoPopulacao = new JLabel("Tamanho Populacao:");
		GridBagConstraints gbc_lblTamanhoPopulacao = new GridBagConstraints();
		gbc_lblTamanhoPopulacao.anchor = GridBagConstraints.WEST;
		gbc_lblTamanhoPopulacao.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamanhoPopulacao.gridx = 0;
		gbc_lblTamanhoPopulacao.gridy = 8;
		getContentPane().add(lblTamanhoPopulacao, gbc_lblTamanhoPopulacao);
		
		jTextFieldTamPopulacao = new JTextField();
		GridBagConstraints gbc_jTextFieldTamPopulacao = new GridBagConstraints();
		gbc_jTextFieldTamPopulacao.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldTamPopulacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldTamPopulacao.gridx = 1;
		gbc_jTextFieldTamPopulacao.gridy = 8;
		getContentPane().add(jTextFieldTamPopulacao, gbc_jTextFieldTamPopulacao);
		jTextFieldTamPopulacao.setColumns(10);
		
		JLabel lblQuantidadeGeracoes = new JLabel("Quantidade Geracoes:");
		GridBagConstraints gbc_lblQuantidadeGeracoes = new GridBagConstraints();
		gbc_lblQuantidadeGeracoes.anchor = GridBagConstraints.WEST;
		gbc_lblQuantidadeGeracoes.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidadeGeracoes.gridx = 0;
		gbc_lblQuantidadeGeracoes.gridy = 9;
		getContentPane().add(lblQuantidadeGeracoes, gbc_lblQuantidadeGeracoes);
		
		jTextFieldQuantGeracoes = new JTextField();
		GridBagConstraints gbc_jTextFieldQuantGeracoes = new GridBagConstraints();
		gbc_jTextFieldQuantGeracoes.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldQuantGeracoes.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldQuantGeracoes.gridx = 1;
		gbc_jTextFieldQuantGeracoes.gridy = 9;
		getContentPane().add(jTextFieldQuantGeracoes, gbc_jTextFieldQuantGeracoes);
		jTextFieldQuantGeracoes.setColumns(10);
		
		JLabel lblTaxaCrossoverdecimal = new JLabel("Taxa Crossover (decimal):");
		GridBagConstraints gbc_lblTaxaCrossoverdecimal = new GridBagConstraints();
		gbc_lblTaxaCrossoverdecimal.anchor = GridBagConstraints.WEST;
		gbc_lblTaxaCrossoverdecimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaxaCrossoverdecimal.gridx = 0;
		gbc_lblTaxaCrossoverdecimal.gridy = 10;
		getContentPane().add(lblTaxaCrossoverdecimal, gbc_lblTaxaCrossoverdecimal);
		
		jTextFieldTaxaCrossover = new JTextField();
		GridBagConstraints gbc_jTextFieldTaxaCrossover = new GridBagConstraints();
		gbc_jTextFieldTaxaCrossover.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldTaxaCrossover.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldTaxaCrossover.gridx = 1;
		gbc_jTextFieldTaxaCrossover.gridy = 10;
		getContentPane().add(jTextFieldTaxaCrossover, gbc_jTextFieldTaxaCrossover);
		jTextFieldTaxaCrossover.setColumns(10);
		
		JLabel lblTaxaMutacaodecimal = new JLabel("Taxa Mutacao (decimal):");
		GridBagConstraints gbc_lblTaxaMutacaodecimal = new GridBagConstraints();
		gbc_lblTaxaMutacaodecimal.anchor = GridBagConstraints.WEST;
		gbc_lblTaxaMutacaodecimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaxaMutacaodecimal.gridx = 0;
		gbc_lblTaxaMutacaodecimal.gridy = 11;
		getContentPane().add(lblTaxaMutacaodecimal, gbc_lblTaxaMutacaodecimal);
		
		jTextFieldTaxaMutacao = new JTextField();
		GridBagConstraints gbc_jTextFieldTaxaMutacao = new GridBagConstraints();
		gbc_jTextFieldTaxaMutacao.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldTaxaMutacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldTaxaMutacao.gridx = 1;
		gbc_jTextFieldTaxaMutacao.gridy = 11;
		getContentPane().add(jTextFieldTaxaMutacao, gbc_jTextFieldTaxaMutacao);
		jTextFieldTaxaMutacao.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonOk();
			}
		});
		
		JLabel lblPesoParaPrazo = new JLabel("Peso para Prazo:");
		GridBagConstraints gbc_lblPesoParaPrazo = new GridBagConstraints();
		gbc_lblPesoParaPrazo.anchor = GridBagConstraints.WEST;
		gbc_lblPesoParaPrazo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoParaPrazo.gridx = 0;
		gbc_lblPesoParaPrazo.gridy = 12;
		getContentPane().add(lblPesoParaPrazo, gbc_lblPesoParaPrazo);
		
		jTextFieldPesoPrazo = new JTextField();
		jTextFieldPesoPrazo.setColumns(10);
		GridBagConstraints gbc_jTextFieldPesoPrazo = new GridBagConstraints();
		gbc_jTextFieldPesoPrazo.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldPesoPrazo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldPesoPrazo.gridx = 1;
		gbc_jTextFieldPesoPrazo.gridy = 12;
		getContentPane().add(jTextFieldPesoPrazo, gbc_jTextFieldPesoPrazo);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 13;
		getContentPane().add(btnOk, gbc_btnOk);
		
		JLabel lblPesoParaCusto = new JLabel("Peso para Custo:");
		GridBagConstraints gbc_lblPesoParaCusto = new GridBagConstraints();
		gbc_lblPesoParaCusto.anchor = GridBagConstraints.WEST;
		gbc_lblPesoParaCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoParaCusto.gridx = 0;
		gbc_lblPesoParaCusto.gridy = 13;
		getContentPane().add(lblPesoParaCusto, gbc_lblPesoParaCusto);
		
		jTextFieldPesoCusto = new JTextField();
		jTextFieldPesoCusto.setColumns(10);
		GridBagConstraints gbc_jTextFieldPesoCusto = new GridBagConstraints();
		gbc_jTextFieldPesoCusto.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldPesoCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldPesoCusto.gridx = 1;
		gbc_jTextFieldPesoCusto.gridy = 13;
		getContentPane().add(jTextFieldPesoCusto, gbc_jTextFieldPesoCusto);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 4;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 14;
		getContentPane().add(scrollPane_2, gbc_scrollPane_2);
		
		columns = new Vector();
		data = new Vector();
		
		columns.add("Tam. Populacao");
		columns.add("Quant. Geracoes");
		columns.add("Taxa Mutacao");
		columns.add("Taxa Crossover");
		columns.add("Media Fitness");
		columns.add("Grafico");
		columns.add("Melhor Solucao");
		tableModelHistorico = modelTable(columns, data);
		
		table = new JTable(tableModelHistorico);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTableMouseClicked(arg0);
			}
		});
		scrollPane_2.setViewportView(table);
	}
	
	protected void jTableMouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 2){
			int opcao = table.getSelectedColumn();
			int linha = table.getSelectedRow();
			JFrameGraph frame = new JFrameGraph();
			frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setSize(800, 500);
			if(opcao == 5){
				frame.criaGraficoMedia(listStatical.get(linha), "Gráfico das Medias");
				frame.setVisible(true);
			} else if(opcao == 6){
				String informacoes = "";
				Population population = (Population) tableModelHistorico.getValueAt(linha, 0);
				Collections.sort(population.getIndividuos());
				JOptionPane.showMessageDialog(null, population.getIndividuos().get(0));
			}
		}
	}
	protected void jButtonOk() {
		int tamanho = Integer.parseInt(jTextFieldTamPopulacao.getText());
		int sizeCromossomo = Chromosome.getSize();
		int pesoPrazo = Integer.parseInt(jTextFieldPesoPrazo.getText());
		int pesoCusto = Integer.parseInt(jTextFieldPesoCusto.getText());
		Population pop = new Population(tamanho, sizeCromossomo, pesoPrazo, pesoCusto, Chromosome.getTarefas(), Chromosome.getRecursos());
		
		int quantRept = Integer.parseInt(jTextFieldQuantGeracoes.getText());
		List<StaticalData> datas = new ArrayList<StaticalData>();
		for (int i = 0; i < quantRept; i++) {
			List<Double> fitnesses = new ArrayList<Double>();
			for (Chromosome c : pop.getIndividuos()) {
				fitnesses.add(c.getFitness());
			}
			StaticalData data = new StaticalData(fitnesses);
			datas.add(data);
			pop.newUsingCrossover();
			pop.newUsingMutation();
		}
		
		popularTabela(datas, pop);
		
	}
	private void popularTabela(List<StaticalData> datas, Population pop) {
		String tamanho = jTextFieldTamPopulacao.getText();
		String geracoes = jTextFieldQuantGeracoes.getText();
		String taxaMutacao = jTextFieldTaxaMutacao.getText();
		String taxaCrossover = jTextFieldTaxaCrossover.getText();
		
		tableModelHistorico.addRow(new Object[]{pop, geracoes, taxaMutacao, taxaCrossover, datas.get(datas.size() - 1), new ImageIcon(ImageIcon.class.getResource("/graph.png")), new ImageIcon(ImageIcon.class.getResource("/best.png"))});
		listStatical.add(datas);
	}
	protected void jButtonSalvarRH() {
		RecursoHumano rh = new RecursoHumano();
		rh.setNome(jTextFieldNomeRH.getText());
		rh.setProdutividade(Double.parseDouble(jTextFieldPFH.getText()));
		rh.setCustoHora(Double.parseDouble(jTextFieldCustoHora.getText()));
		Chromosome.getRecursos().add(rh);
		atualizaJListRecursoHumanos();
		
	}
	
	private void atualizaJListRecursoHumanos() {
		listModelRecursoHumano.clear();
		for (RecursoHumano recurso : Chromosome.getRecursos()) {
			listModelRecursoHumano.addElement(recurso);
		}
		repaint();
	}
	private void atualizaJListTarefas() {
		listModelTarefa.clear();
		for (Tarefa tarefa : Chromosome.getTarefas()) {
			listModelTarefa.addElement(tarefa);
		}
		repaint();
	}
	protected void jButtonSalvarTarefa() {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(jTextFieldNomeTarefa.getText());
		tarefa.setDescricao(jTextFieldDescricaoTarefa.getText());
		tarefa.setTamanho(Integer.parseInt(jTextFieldPontoFTarefa.getText()));
		Chromosome.getTarefas().add(tarefa);
		atualizaJListTarefas();
	}
	public static DefaultTableModel modelTable(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		 String.class, String.class, String.class, String.class, StaticalData.class, ImageIcon.class, ImageIcon.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false,
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }

}
