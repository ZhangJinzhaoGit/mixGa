package simpleGa;

public class Population {

    Individual[] individuals;

    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        if (initialise) {
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest(int fun_num) {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness(fun_num) <= getIndividual(i).getFitness(fun_num)) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }
    public int getPath(int fun_num,int index) {
    	int[] path = new int[4];
    	for(int i = 0; i < 4; i++){
    		path[i] = 0;
    	}
        // Loop through individuals to find path
    	if(fun_num == 1){
	        for (int i = 0; i < size(); i++) {
	            if (getIndividual(i).getFitness(fun_num) == 2) {
	                path[3] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) == 1.5) {
	                path[2] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) < 1.5 && getIndividual(i).getFitness(fun_num) > 1) {
	                path[1] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) < 1) {
	                path[0] += 1;
	            }
	        }
    	}
    	if(fun_num == 2 || fun_num == 3){
    		for (int i = 0; i < size(); i++) {
	            if (getIndividual(i).getFitness(fun_num) == 1) {
	                path[0] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) < 1) {
	                path[1] += 1;
	            }
	        }
    	}
    	if(fun_num == 4){
    		for(int i = 0; i < size(); i++){
    			if (getIndividual(i).getFitness(fun_num) < 1) {
	                path[0] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) > 1 && getIndividual(i).getFitness(fun_num) < 1.1) {
	                path[1] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) > 1.1 && getIndividual(i).getFitness(fun_num) < 2) {
	                path[2] += 1;
	            }
	            if(getIndividual(i).getFitness(fun_num) == 2) {
	                path[3] += 1;
	            }
    		}
    	}
    	if(fun_num == 5){
    		for(int i = 0; i < size(); i++){
	    		if (getIndividual(i).getFitness(fun_num) == 1) {
	                path[0] += 1;
	            }
    		}
    	}
    	if(fun_num == 6){
    		for(int i = 0; i < size(); i++){
	    		if (getIndividual(i).getFitness(fun_num) == 30) {
	                path[0] += 1;
	            }
    		}
    	}
    	if(fun_num == 7){
    		for(int i = 0; i < size(); i++){
	    		if (getIndividual(i).getFitness(fun_num) == 6) {
	                path[0] += 1;
	            }
    		}
    	}
        return path[index];
    }
    public float getTotalFitness(int fun_num){
    	float totalFitness = 0;
    	for(Individual indiv : individuals){
    		totalFitness += indiv.getFitness(fun_num);
    	}
    	return totalFitness;
    }
    // Get population size
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}