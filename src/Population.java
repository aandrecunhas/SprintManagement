import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Population {
	
	public static void main(String[] args) {
//		Population p = new Population(10, 8, 2, 1);
//		for (int i = 0; i < 100; i++) {
//			System.out.println("Geração "+ Population.getNumberOfGeneration());
//			System.out.println("Média do Fitness: "+ p.mediaFitness());
//			p.newUsingCrossover();
//		}
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setNome("Desenvolver Modelo de Banco de Dados");
		tarefa1.setTamanho(5);
		Tarefa tarefa2 = new Tarefa();
		tarefa2.setNome("Implementar o Banco de Dados");
		tarefa2.setTamanho(10);
		Tarefa tarefa3 = new Tarefa();
		tarefa3.setNome("Desenvolver GUI");
		tarefa3.setTamanho(15);
		Tarefa tarefa4 = new Tarefa();
		tarefa4.setNome("Integracao");
		tarefa4.setTamanho(20);
		Tarefa tarefa5 = new Tarefa();
		tarefa5.setNome("Teste");
		tarefa5.setTamanho(5);
		
		RecursoHumano recurso1 = new RecursoHumano();
		recurso1.setNome("Joao");
		recurso1.setProdutividade(2);
		recurso1.setCustoHora(60);
		RecursoHumano recurso2 = new RecursoHumano();
		recurso2.setNome("Bob");
		recurso2.setProdutividade(3);
		recurso2.setCustoHora(20);
		RecursoHumano recurso3 = new RecursoHumano();
		recurso3.setNome("Max");
		recurso3.setProdutividade(4);
		recurso3.setCustoHora(25);
		RecursoHumano recurso4= new RecursoHumano();
		recurso4.setNome("Anne");
		recurso4.setProdutividade(1);
		recurso4.setCustoHora(100);
		RecursoHumano recurso5 = new RecursoHumano();
		recurso5.setNome("Hugo");
		recurso5.setProdutividade(3);
		recurso5.setCustoHora(30);
		
		
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas.add(tarefa1);
		tarefas.add(tarefa2);
		tarefas.add(tarefa3);
		tarefas.add(tarefa4);
		tarefas.add(tarefa5);
		ArrayList<RecursoHumano> humanos = new ArrayList<RecursoHumano>();
		humanos.add(recurso1);
		humanos.add(recurso2);
		humanos.add(recurso3);
		humanos.add(recurso4);
		humanos.add(recurso5);
		
		Population pop = new Population(10, 5, 2, 3, tarefas, humanos);
		pop.setProbMutation(0.05);
		pop.setProbCrossover(0.90);
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Geração "+ Population.getNumberOfGeneration());
			System.out.println("Média do Fitness: "+ pop.mediaFitness());
			pop.newUsingCrossover();
			pop.newUsingMutation();
		}
		
		System.out.println(pop.getIndividuos().get(0).toString());
		
	}
	private double probMutation;
	
	private double probCrossover;
	
	private int pesoCusto;
	
	private int pesoPrazo;
	
	private int size;
	
	private static int numberOfGeneration = 1;
	
	private ArrayList<Chromosome> individuos = new ArrayList<Chromosome>();
	
	public Population(int size, int sizeChromosome, int peso1, int peso2, ArrayList<Tarefa> tarefas, ArrayList<RecursoHumano> humanos) {
		setSize(size);
		setPesoPrazo(peso1);
		setPesoCusto(peso2);
		Chromosome.setRecursos(humanos);
		Chromosome.setTarefas(tarefas);
		for (int i = 0; i < getSize(); i++) {
			individuos.add(new Chromosome(sizeChromosome, getPesoPrazo(), getPesoCusto()));
		}
		
	}
	
	public Population(){
		
	}

	public ArrayList<Chromosome> getIndividuos() {
		return individuos;
	}
	
	public void newUsingCrossover(){
		Chromosome bestOne = new Chromosome();
		Chromosome bestTwo = new Chromosome();
		this.SortByFitness();
		bestOne.setGenes(this.getIndividuos().get(0).getGenes(), getPesoPrazo(), getPesoCusto());
		bestTwo.setGenes(this.getIndividuos().get(1).getGenes(), getPesoPrazo(), getPesoCusto());
		Chromosome newChildOne = new Chromosome();
		newChildOne.setGenes(Genetic.crossover(bestOne.getGenes(), bestTwo.getGenes()), getPesoPrazo(), getPesoCusto());
		Chromosome newChildTwo = new Chromosome();
		newChildTwo.setGenes(Genetic.crossover(bestTwo.getGenes(), bestOne.getGenes()), getPesoPrazo(), getPesoCusto());
		this.getIndividuos().set(getSize() - 1, newChildTwo);
		this.getIndividuos().set(getSize() - 2, newChildOne);
		numberOfGeneration++;
	}
	
	public void newUsingMutation(){
		ArrayList<Chromosome> ind = new ArrayList<Chromosome>();
		for (Chromosome c : getIndividuos()) {
			Chromosome newChromo = new Chromosome();
			newChromo.setGenes(Genetic.mutation(c.getGenes(), getProbMutation()), getPesoPrazo(), getPesoCusto());
			ind.add(newChromo);
		}
		this.setIndividuos(ind);
		numberOfGeneration++;
	}
	
	public double mediaFitness(){
		double soma = 0;
		for (Chromosome c : getIndividuos() ) {
			soma = soma + c.getFitness();
		}
		soma = soma / getSize();
		return soma;
	}
	
	public double desvioFitness(){ //falta
		return 0;
	}
	
	public void SortByFitness(){
		Collections.sort(getIndividuos());
	}

	public void setIndividuos(ArrayList<Chromosome> individuos) {
		this.individuos = individuos;
	}

	public double getProbMutation() {
		return probMutation;
	}

	public void setProbMutation(double probMutation) {
		this.probMutation = probMutation;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static int getNumberOfGeneration() {
		return numberOfGeneration;
	}

	public static void setNumberOfGeneration(int numberOfGeneration) {
		Population.numberOfGeneration = numberOfGeneration;
	}

	public double getProbCrossover() {
		return probCrossover;
	}

	public void setProbCrossover(double probCrossover) {
		this.probCrossover = probCrossover;
	}

	public int getPesoCusto() {
		return pesoCusto;
	}

	public void setPesoCusto(int pesoCusto) {
		this.pesoCusto = pesoCusto;
	}

	public int getPesoPrazo() {
		return pesoPrazo;
	}

	public void setPesoPrazo(int pesoPrazo) {
		this.pesoPrazo = pesoPrazo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+getSize();
	}

}
