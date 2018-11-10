package simpleGa;

import java.util.Date;

public class MainTest {
	//8��benchmark:1�����Σ�2�м�����3��������˰��4���Լ����5��һ�գ�6ð������7���ֵ��Сֵ
	private static final int RUN = 100 ;  //the number of the program run .
	private static final int populationSize = 10000;  //the number of the population .
	private static final int fun_num = 1 ;  //the serial number of the target benchmark function.
	
	static double start;            //the beginning time of the program run
	static double finish;           //the finish time of the program run
	static float[] coverage = new float[RUN];
	static double[] runtime = new double[RUN];
	static int[] generation_num = new int[RUN];
	public static void main(String[] args) {

		// ѡ��һ�������Ļ������С���������Լ����ⶨ
//		FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
		for(int run = 0 ; run < RUN ; run++ )
		{
			Date mydate = new Date();
			start= mydate.getTime();       //begin to calculate the time
			// ��ʼ��һ����Ⱥ
			Population myPop = new Population(populationSize, true);
	
			// ���ε��������н��������� ֱ���ҵ������Ļ�������
			int generationCount = 0;
			while (myPop.getPath(fun_num,3) < populationSize) {
//			while (myPop.getFittest(fun_num).getFitness(fun_num) < 5) {
				
//				System.out.println("Generation: " + generationCount + " Fittest: "
//						+ myPop.getFittest(fun_num).getFitness(fun_num));
//				System.out.println("path0:" + myPop.getPath(fun_num,0) + "  path1:" + myPop.getPath(fun_num,1) + "  path2:" + myPop.getPath(fun_num,2) + "  path3:" + myPop.getPath(fun_num,3));
//				System.out.println("******************************");
				myPop = Algorithm.evolvePopulation(myPop,fun_num);
				generationCount++;
			}
			Date mydate2 = new Date() ;
			finish=mydate2.getTime();  //��ʱ����
			runtime[run]=finish-start; 
			generation_num[run] = generationCount;
//			System.out.println("Generation: " + generationCount + " Fittest: "
//					+ myPop.getFittest(fun_num).getFitness(fun_num));
//			System.out.println("path0:" + myPop.getPath(fun_num,0) + "  path1:" + myPop.getPath(fun_num,1) + "  path2:" + myPop.getPath(fun_num,2) + "  path3:" + myPop.getPath(fun_num,3));
//			System.out.println("******************************");
			System.out.println("Solution found!");
			System.out.println("Generation: " + generationCount);
//			System.out.println("Final Fittest Genes:");
//			System.out.println(myPop.getFittest(fun_num));
			System.out.println("��" + run + "������ʱ��=" + runtime[run] + "ms");  //�������ʱ�� 
			System.out.println("******************************");
		}
		double time_sum = 0 , time_average ;
		int generation_sum = 0 , generation_average;
		for ( int run = 0 ; run < RUN ; run++)
		{
		     time_sum = time_sum + runtime[run] ;		     
		     generation_sum = generation_sum + generation_num[run] ;
		}
		time_average = time_sum / RUN ;		
		generation_average = generation_sum / RUN;
		System.out.println("time_sum = " + time_sum + "ms");
		System.out.println("time_average = " + time_average + "ms");
//		System.out.println("cycle_sum = " + cycle_sum );
//		System.out.println("cycle_average = " + cycle_average );
		System.out.println("generation_sum = " + generation_sum );
		System.out.println("generation_average = " + generation_average );
	}
}