
public class Manage {

	Manage(double ele[]){
		System.out.println("max is : " + 	max.apply(ele));
		System.out.println("min is : " + 	min.apply(ele));
		System.out.println("sum is : " + 	sum.apply(ele));
		System.out.println("avg is : " + 	avg.apply(ele));
		
	}
	
	
	ArrayProcessor max = (double [] ele) -> {
		double max = 0;
		for(int i = 0; i < ele.length; i++) {
			
			if(i == 0) {
				max = ele[i];
			}
			
			if(ele[i] > max) {
				max = ele[i];
			}
			
		}
		return max;
	};
	
	
	ArrayProcessor min = (double [] ele) -> {
		double min = 0;
		for(int i = 0; i < ele.length; i++) {
			
			if(i == 0) {
				min = ele[i];
			}
			
			if(ele[i] < min) {
				min = ele[i];
			}
			
		}
		return min;
	};
	
	
	ArrayProcessor sum = (double [] ele) -> {
		double sum = 0;
		for(int i = 0; i < ele.length; i++) {
			
				sum += ele[i];
		}
		return sum;
	};
	
	
	ArrayProcessor avg = (double [] ele) -> {
		double sum = 0;
		for(int i = 0; i < ele.length; i++) {	
				sum += ele[i];
		}
		sum = sum / ele.length;
		return sum;
	};
	
	
	
	
	
}
