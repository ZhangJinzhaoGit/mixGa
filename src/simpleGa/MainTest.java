package simpleGa;

import java.util.Date;

public class MainTest {
	//8个benchmark:1三角形，2中间数，3个人所得税，4最大公约数，5下一日，6冒泡排序，7最大值最小值
	private static final int RUN = 100 ;  //the number of the program run .
	private static final int populationSize = 10000;  //the number of the population .
	private static final int fun_num = 1 ;  //the serial number of the target benchmark function.
	
	static double start;            //the beginning time of the program run
	static double finish;           //the finish time of the program run
	static float[] coverage = new float[RUN];
	static double[] runtime = new double[RUN];
	static int[] generation_num = new int[RUN];
	public static void main(String[] args) {

		// 选择一个期望的基因序列。这个是由自己任意定
//		FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
		for(int run = 0 ; run < RUN ; run++ )
		{
			Date mydate = new Date();
			start= mydate.getTime();       //begin to calculate the time
			// 初始化一个种群
			Population myPop = new Population(populationSize, true);
	
			// 不段迭代，进行进化操作。 直到找到期望的基因序列
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
			finish=mydate2.getTime();  //计时结束
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
			System.out.println("第" + run + "次运行时间=" + runtime[run] + "ms");  //输出运行时间 
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