


import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class JFrameGraph extends JFrame {
	private JPanel panel;
	
	public static void main(String[] args) {
		JFrameGraph frame = new JFrameGraph();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	
	public JFrameGraph() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		//criaGrafico();
	}
	
	private CategoryDataset createDatasetMedia(List<StaticalData> datas) { 
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Integer cont = 0;
		for (StaticalData staticalData : datas) {
			dataset.addValue(staticalData.getMedia(), "Media", cont);
			cont++;
			}
		
		return dataset; 
	}
	
	private CategoryDataset createDatasetVariance(List<StaticalData> datas) { 
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Integer cont = 0;
		for (StaticalData staticalData : datas) {
			dataset.addValue(staticalData.getVariancia(), "Variancia", cont);
			cont++;
			}
		
		return dataset; 
	}

	public void criaGraficoMedia(List<StaticalData> datas, String title) {
		CategoryDataset cds = createDatasetMedia(datas);
		String titulo = title;
		String eixoy = "Média";
		String txt_legenda = "Ledenda:";
		boolean legenda = true;
		boolean tooltips = true;
		boolean urls = true;
		
		JFreeChart graf = ChartFactory.createLineChart(titulo, "Número de Gerações", eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
		ChartPanel myChartPanel = new ChartPanel(graf, true);
		panel.setSize(300, 300);
		myChartPanel.setSize(panel.getWidth(),panel.getHeight());
		myChartPanel.setVisible(true); 
		panel.removeAll();
		panel.add(myChartPanel); 
		panel.revalidate();
		panel.repaint(); 
	}
	
	public void criaGraficoVariancia(List<StaticalData> datas, String title) {
		CategoryDataset cds = createDatasetVariance(datas);
		String titulo = title;
		String eixoy = "Variancia";
		String txt_legenda = "Ledenda:";
		boolean legenda = true;
		boolean tooltips = true;
		boolean urls = true;
		
		JFreeChart graf = ChartFactory.createLineChart(titulo, "Número de Gerações", eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
		ChartPanel myChartPanel = new ChartPanel(graf, true);
		panel.setSize(300, 300);
		myChartPanel.setSize(panel.getWidth(),panel.getHeight());
		myChartPanel.setVisible(true); 
		panel.removeAll();
		panel.add(myChartPanel); 
		panel.revalidate();
		panel.repaint(); 
	}


}
