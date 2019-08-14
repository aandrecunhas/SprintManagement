import java.util.ArrayList;



public class Chromosome implements Comparable<Chromosome> {
	
	
	private int size;
	
	private double fitness; //numero de rainhas em check
	
	private ArrayList<Integer> genes = new ArrayList<Integer>();
	
	private static ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	private static ArrayList<RecursoHumano> recursos = new ArrayList<RecursoHumano>();
	
	private static int tamanho;
	
	private double prazo;
	
	private double custo;
	
	public Chromosome(int size, int peso1, int peso2) {
		setSize(size);
		while(genes.size() < getSize()) {
			Integer gene = (int) (Math.random() * getSize());
			gene++;
			if(!genes.contains(gene)){
				genes.add(gene);
			}
		}
		setFitness(peso1, peso2);
	}
	
	public Chromosome(){
		
	}

	public ArrayList<Integer> getGenes() {
		return genes;
	}

	public void setGenes(ArrayList<Integer> genes, int peso1, int peso2) {
		this.genes = genes;
		setFitness(peso1, peso2);
	}

	public static int getSize() {
		return getTarefas().size();
	}
	
	public double getFitness(){
		return fitness;
	}
	
//	public void setFitness(){
//
//        int fitness = 0;
//        
//        for (int i = 0; i < getGenes().size(); i++) {
//			if(isCheck(getGenes(), i)){
//				fitness++;
//			}
//		}
//
//		this.fitness = fitness;
//	}
	
	public void setFitness(int pesoPrazo, int pesoCusto){
		int indice = 0;
		double prazoTotal = 0;
		double custoTotal = 0;
		for (Integer i : getGenes()) {
			double prazo = getTarefas().get(indice).getTamanho() * getRecursos().get(i - 1).getProdutividade();
			prazoTotal += prazo;
			custoTotal += prazo * getRecursos().get(i - 1).getCustoHora();
			indice++;
		}
		setPrazo(prazoTotal);
		setCusto(custoTotal);
		double fit = pesoPrazo / getPrazo() + pesoCusto / getCusto();
		this.fitness = fit;
	}
	
	
	public static boolean isCheck(ArrayList<Integer> array, int index){
		if(index == 0 || index == (array.size() - 1)) return false;
		if(array.get(index) == 1 || array.get(index) == array.size()) return false;
		for (Integer integer : array) {
			if(integer == array.get(index)) continue;
			if(Math.abs(array.indexOf(integer) - index) == Math.abs(integer - array.get(index))) return true;
		}
		return false;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Chromosome o) {
		if(this.getFitness() < o.getFitness()){
			return 1;
		} 
		if (this.getFitness() > o.getFitness()){
			return -1;
		}
		return 0;
	}

	public static ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}

	public static void setTarefas(ArrayList<Tarefa> tarefas1) {
		tarefas = tarefas1;
	}

	public static ArrayList<RecursoHumano> getRecursos() {
		return recursos;
	}

	public static void setRecursos(ArrayList<RecursoHumano> recursos1) {
		recursos = recursos1;
	}

	public double getPrazo() {
		return prazo;
	}

	public void setPrazo(double prazo) {
		this.prazo = prazo;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fitness: "+ getFitness() +"\n"+
				"Prazo Total: "+getPrazo() +" horas\n"+
				"Custo Total: "+getCusto() +" reais\n"+
				getRelacao();
	}
	
	public String getRelacao(){
		String relacao = "";
		int index = 0;
		for (Integer integer : getGenes()) {
			relacao += Chromosome.getTarefas().get(index) +"<->"+ Chromosome.getRecursos().get(integer - 1)+"\n";
			index++;
		}
		return relacao;
	}

	public static int getTamanho() {
		return tamanho;
	}

	public static void setTamanho(int tamanho) {
		Chromosome.tamanho = tamanho;
	}
	
	
}
