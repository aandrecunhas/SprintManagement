


import java.util.ArrayList;
import java.util.List;

public class StaticalData {
	private List<Double> notaMax = new ArrayList<Double>();
	private int tamPop;
	private int quantRept;
	private double media;
	private double variancia;
	
	//Constructor
	public StaticalData(List<Double> notas) {
		setNotaMax(notas);
		calcularMedia();
		calcularVariancia();
	}
	
	private void calcularVariancia() {
		double soma = 0;
		for (Double nota : getNotaMax()) {
			double a = Math.sqrt(nota - getMedia());
			soma += Math.round(a * 100) / 100d;   
		}
		setVariancia(soma/(notaMax.size() - 1));
		
	}
	

	private void calcularMedia() {
		double soma = 0;
		for (Double nota : getNotaMax()) {
			soma += nota;
		}
		setMedia(soma/notaMax.size());
		
		
	}

	// Setters and Getters
	public List<Double> getNotaMax() {
		return notaMax;
	}


	public void setNotaMax(List<Double> notaMax) {
		this.notaMax = notaMax;
	}

	public double getMedia() {
		return media;
	}

	private void setMedia(double media) {
		this.media = media;
	}

	public double getVariancia() {
		return variancia;
	}

	private void setVariancia(double variancia) {
		this.variancia = variancia;
	}

	public int getTamPop() {
		return tamPop;
	}

	public void setTamPop(int tamPop) {
		this.tamPop = tamPop;
	}

	public int getQuantRept() {
		return quantRept;
	}

	public void setQuantRept(int quantRept) {
		this.quantRept = quantRept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+getMedia();
	}

}
