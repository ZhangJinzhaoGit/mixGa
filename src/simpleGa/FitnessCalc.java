package simpleGa;

public class FitnessCalc {

    static double getFitness(Individual individual,int fun_num) {
    	double fitness = 0;
    	double f1 = 0,f2 = 0; // f3 = 0,f4 = 0,f5 = 0;
    	if(fun_num == 1){     // Triangle
			int a = Integer.parseInt(individual.toString().substring(0,6),2) ;
			int b = Integer.parseInt(individual.toString().substring(6,12),2) ;
			int c = Integer.parseInt(individual.toString().substring(12,18),2) ;
//			System.out.println(individual);
//			System.out.println("a:" + a + "  b:" + b + "  c:" + c);

			f1 = Math.max(Math.max(a - b - c + 1, b - a - c + 1), c - a - b + 1);
			if((a<(b+c)) && (b<(a+c)) && (c<(a+b)))
			{
				int mid = (a + b + c)/3;
				f2 = Math.abs(a - mid) + Math.abs(b - mid) + Math.abs(c - mid);
//				f5 = Math.max(Math.abs(a - b), Math.abs(b - c));
			    if (((a==b) && (a!=c)) || ((a==c)&&(a!=b)) || ((b==c)&&(b!=a))){
			    	f2 = Math.min(f2, 1);
//			    	System.out.println("This is a isosceles triangle!");
			    }
//			    if ( (a==b) && (a==c) )
//			    	System.out.println("This is a equilateral triangle!");
//			    if ((a!=b) && (a!=c) && (b!=c))
//			    	System.out.println("This is a ordinary triangle!");
			    }
				else{
					f2 = Integer.MAX_VALUE;
//					System.out.println("This is not a triangle!");
				}
//			f2 = Math.abs(a - mid) + Math.abs(b - mid) + Math.abs(c - mid);
//			f2 = Math.min(Math.min(Math.max(Math.abs(a - b), Math.max(Integer.MIN_VALUE-Math.abs(a - c), 0)),Math.max(Math.abs(a - c), Math.max(Integer.MIN_VALUE-Math.abs(a - b), 0))),Math.max(Math.abs(c - b), Math.max(Integer.MIN_VALUE-Math.abs(a - c), 0)));
//		    if (((a==b) && (a!=c)) || ((a==c)&&(a!=b)) || ((b==c)&&(b!=a))){
//		    	System.out.println("This is a isosceles triangle!");
//		    }
//		    f2 = Math.max(Math.abs(a - b), Math.abs(b - c));
//		    if ( (a==b) && (a==c) )
//		    	System.out.println("This is a equilateral triangle!");
//		    f2 = Math.max( Math.max(Math.max(Integer.MIN_VALUE-Math.abs(a - b), 0),Math.max(Integer.MIN_VALUE-Math.abs(a - c), 0)),Math.max(Integer.MIN_VALUE-Math.abs(c - b), 0));
//		    if ((a!=b) && (a!=c) && (b!=c))
//		    	System.out.println("This is a ordinary triangle!");
			if(f1 < 0) f1 = 0;
			if(f2 < 0) f2 = 0;
//			if(f3 < 0) f3 = 0;
//			if(f4 < 0) f4 = 0;
//			if(f5 < 0) f5 = 0;
//			if(f1 > 0 || f2 > 0 || f3 > 0)  fitness = 0;
			fitness = 1/(1+f1) + 1/(1+f2);
//			System.out.println("fitness:" + fitness);
		}
//        for (int i = 0; i < individual.size() && i < solution.length; i++) {
//            if (individual.getGene(i) == solution[i]) {
//                fitness++;
//            }
//        }
    	if(fun_num == 2){
    		int a = Integer.parseInt(individual.toString().substring(0,6),2) ;
			int b = Integer.parseInt(individual.toString().substring(6,12),2) ;
			int c = Integer.parseInt(individual.toString().substring(12,18),2) ;
			int mid = b;
			f1 = Math.min(Math.max(a-b+0.5, c-a+0.5), Math.max(a-c+0.5, b-a+0.5));
			if((a < b && a > c) || (a < c && a > b)){
				mid = a;
			}
			if((b < a && b > c) || (b < c && b > a)){
				mid = b;
			}
			if((c < b && c > a) || (c < a && c > b)){
				mid = c;
			}
			if(f1 < 0) f1 = 0;
			fitness = 1/(1+f1);
    	}
    	if(fun_num == 3){
    		int a = Integer.parseInt(individual.toString().substring(0,18),2) ;
//    		System.out.println(individual);
//			System.out.println("a:" + a);

    		double t = 0;
    		int m = 0;
    		if(a > 100000){
    			m = a-10000;
    			t = m*0.45+20000*0.35+20000*0.3+20000*0.25+15000*0.2+3000*0.15+500*0.05;
    		}
    		if(a <= 100000 && a > 80000){
    			m = a-80000;
    			t = m*0.4+20000*0.35+20000*0.3+20000*0.25+15000*0.2+3000*0.15+1500*0.1+500*0.05;
    		}
    		if(a <= 80000 && a > 60000){
    			m = a-60000;
    			t = m*0.35+20000*0.3+20000*0.25+15000*0.2+3000*0.15+1500*0.1+500*0.05;
    		}
    		if(a <= 60000 && a > 40000){
    			m=a-40000;
    			t=m*0.3+20000*0.25+15000*0.2+3000*0.15+1500*0.1+500*0.05;
    		}
    		f1 = Math.max(a-40000+1,20000-a+1);
    		if(a <= 40000 && a > 20000){
    			m=a-20000;
    			t=m*0.25+15000*0.2+3000*0.15+1500*0.1+500*0.05;
    		}
    		if(a <= 20000 && a > 5000){
    			m=a-5000;
    			t=m*0.2+3000*0.15+1500*0.1+500*0.05;
    		}
    		if(a <= 5000 && a > 2000){
    			m=a-2000;
    			t=m*0.15+1500*0.1+500*0.05;
    		}
    		if(a <= 2000 && a > 500){
    			m=a-500;
    			t=m*0.1+500*0.05;
    		}
    		if(a <= 500){
    			m=a;
    			t=m*0.05;
    		}
    		if(f1 < 0) f1 = 0;
    		fitness = 1/(1+f1);
    	}
    	if(fun_num == 4){
    		int a = Integer.parseInt(individual.toString().substring(0,9),2) ;
			int b = Integer.parseInt(individual.toString().substring(9,18),2) ;
			if(a == 0 || b == 0){
				fitness = 0;
				return 0;
			}
			boolean d[] =new boolean[2] ;
			f1 = a - b + 0.5;
			if (a < b)
	   		{
				d[0] = true ;
	   			int t = b;
	   			b = a;
	   			a = t;
	   		}
			int r;
		   	r = a % b;
		    a = b;
		   	b = r;
		   	f2 = r;
		   	while (r != 0)
	   		{
		   		d[1] = true ;
	   		    r = a % b;
	   		    a = b;
	   		    b = r;
	   		    break ;
	   	    }
		   	if(f1 < 0) f1 = 0;
		   	if(f2 > 0) f2 = Integer.MAX_VALUE;
		   	fitness = 1/(1+f1) + 1/(1+f2);
    	}
    	if(fun_num == 5){  // ?һ????
    		int a = Integer.parseInt(individual.toString().substring(0,7),2) ;
    		int b = Integer.parseInt(individual.toString().substring(7,11),2) ;
    		int c = Integer.parseInt(individual.toString().substring(11,18),2) ;
    		if(((a % 4 == 0) && b == 2 && c > 29) || b > 12 || ((a % 4 == 0) && b == 2 && c > 28) || ((b == 4 || b == 6 || b == 9 || b == 11 ) && (c == 31))){

    		}
    		if(((a % 4 == 0) && b == 29) || ((a % 4 != 0) && b == 28) || ((b == 1 || b == 3 || b == 5 || b == 7 || b == 8 || b == 10) && (c == 31)) || ((b == 4 || b == 6 || b == 9 || b == 11 ) && (c == 30))){

    		}
    		f1 = Math.max(Math.abs(b-12), Math.abs(c-31));
    		if(b == 12 && c == 31){

    		}
    		fitness = 1/(1+f1);
    	}
    	if(fun_num == 6){
    		int[] a = new int[6];
    		int[][] f = new int[6][6];
//    		System.out.println(individual);
    		for(int i = 0; i < 6; i++){
    			a[i] = Integer.parseInt(individual.toString().substring(3*i,3*i+3),2) ;
//    			System.out.println(a[i]);
    		}
    		for(int j = 0; j < 6; j++){
    			for(int k = j; k < 6; k++){
    				f[j][k] = a[j] - a[k] + 1;
    				if(a[j] < a[k]){
    					int temp = a[j];
    					a[j] = a[k];
    					a[k] = temp;
    				}
    			}
    		}
    		for(int i = 0; i < 6; i++){
    			for(int j = 0; j< 6; j++){
        			if(f[i][j] < 0){
        				f[i][j] = 0;
        			}
        			fitness += 1/(1+f[i][j]);
    			}
    		}
    	}
    	if(fun_num == 7){
    		int[] a = new int[6];
    		int[] f = new int[6];
    		for(int i = 0; i < 6; i++){
    			a[i] = Integer.parseInt(individual.toString().substring(3*i,3*i+3),2) ;
    		}
    		int max = 0,min = 0;
    		for(int j = 0; j < 6; j++){
    			f[j] = max - a[j] + 1;
    			if(a[j] > max){
    				max = a[j];
    			}
//    			f2 = a[j] - min + 0.5;
    			if(a[j] < min){
    				min = a[j];
    			}
    			if(f[j] < 0){
    				f[j] = 0;
    			}
    			fitness += 1/(1+f[j]);
    		}
    	}
        return fitness;
    }

//    static int getMaxFitness() {
//        int maxFitness = solution.length;
//        return maxFitness;
//    }
}