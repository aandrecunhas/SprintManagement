import java.util.ArrayList;


public class Genetic {
	
	public static ArrayList<Integer> crossover(ArrayList<Integer> c1, ArrayList<Integer> c2){
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		ArrayList<Integer> aux = new ArrayList<Integer>();
		
		if(c1.size() == c2.size()){
			int randomNumber = (int) (Math.random() * (c1.size()));
			c3.addAll(c1.subList(0, randomNumber));
			aux.addAll(c2.subList(randomNumber, c2.size()));
			aux.addAll(c2.subList(0, randomNumber));
			for(Integer i: aux){
				if(!c3.contains(i)){
					c3.add(i);
				}
				if(c3.size() == c1.size()) break;
			}
		}
			return c3;
	}
	
	public static ArrayList<Integer> mutation(ArrayList<Integer> c1, double percentagem){
		double random = Math.random();
		for(Integer index : c1){
			if(random < percentagem){
				int randomNumber = (int) (Math.random() * (c1.size()));	
				Integer aux = c1.get(randomNumber);
				c1.set(randomNumber, c1.get(index - 1));
				c1.set(index -1, aux);
				
				}
		}
		return c1;
	}
	
}
