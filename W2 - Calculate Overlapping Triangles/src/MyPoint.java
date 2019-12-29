
import java.lang.Math;

public class MyPoint {

	 double x;
	 double y;
	 
	 public MyPoint(){
		 x = 0;
		 y = 0;
	 }
	 
	 public MyPoint(double xCor, double yCor) {
		 x = xCor;
		 y = yCor;
		 
	 }
	 
	 
	 
	 //ToDO finish distance calculation
	public double Distance(MyPoint cor2){
		double x2 = cor2.x; 
		double y2 = cor2.y;
		double distance = Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
		return distance;
	}
	
}
