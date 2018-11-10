package simpleGa;

public class Algorithm {

    private static final double uniformRate = 0.8;
    private static final double mutationRate = 0.008;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    private static double SARate = 0;
    private static double t = 100;
    private static final double a = 0.9;

    public static Population evolvePopulation(Population pop, int fun_num) {

        Population newPopulation = new Population(pop.size(), false);

        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest(fun_num));
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {

//            Individual indiv1 = tournamentSelection(pop,fun_num);
//            Individual indiv2 = tournamentSelection(pop,fun_num);
        	// git test
        	// 1
            Individual indiv1 = getParentChromosome(pop,fun_num);
            Individual indiv2 = getParentChromosome(pop,fun_num);

            Individual newIndiv = crossover(indiv1, indiv2,fun_num,t);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population  Í»±ä
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
//        	if(newPopulation.getIndividual(i).getFitness(fun_num) < fittest){
        		mutate(newPopulation.getIndividual(i),fun_num);
//        	}
        }

        t = a*t;
        return newPopulation;
    }

    private static Individual crossover(Individual indiv1, Individual indiv2,int fun_num,double t) {
        Individual newSol = new Individual();
        for (int i = 0; i < indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        double max_fitness = Math.max(Math.max(indiv1.getFitness(fun_num), indiv2.getFitness(fun_num)),newSol.getFitness(fun_num));
        SARate = Math.exp(-(max_fitness - newSol.getFitness(fun_num))/t);
        if(max_fitness == newSol.getFitness(fun_num))
        	return newSol;
        else  if(max_fitness == indiv1.getFitness(fun_num)){
        	if(Math.random() <= SARate)
        		return newSol;
        	else
        		return indiv1;
        }
        else {
        	if(Math.random() <= SARate)
        		return newSol;
        	else
        		return indiv2;
        }
//        return newSol;
    }

    private static void mutate(Individual indiv,int fun_num) {
//    	float old_fitness = indiv.getFitness(fun_num);
//    	System.out.println("old_fitness:" + old_fitness);
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
//                System.out.println(old_fitness + "indiv" + indiv.getFitness(fun_num));
//                if(indiv.getFitness(fun_num) > old_fitness){
//                	indiv.setGene(i, gene);
//                }
//                indiv.setGene(i, gene);
            }
//            System.out.println(old_fitness);
        }
    }

    private static Individual tournamentSelection(Population pop, int fun_num) {
        // Create a tournament population
        Population tournamentPop = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournamentPop.saveIndividual(i, pop.getIndividual(randomId));
        }
        Individual fittest = tournamentPop.getFittest(fun_num);
        return fittest;
    }

    @SuppressWarnings("unused")
	private static Individual getParentChromosome (Population pop, int fun_num){
    	float totalFitness = pop.getTotalFitness(fun_num);
//    	float averageFitness = totalFitness / pop.size();
//    	double slice = Math.random() * totalFitness;
    	double sum = 0;
//    	System.out.println(totalFitness);
//    	System.out.println(averageFitness);
//    	System.out.println(slice);
    	for (int i = 0; i < pop.size(); i++) {
    		sum += pop.getIndividual(i).getFitness(fun_num) / totalFitness;
    		if (Math.random() <= sum) {
//    			System.out.println(i);
    			return pop.getIndividual(i);
    		}
    	}
    	return pop.getIndividual(0);
    }
}