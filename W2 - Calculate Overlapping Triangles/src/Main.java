
public class Main {
	public static void main(String[] args) {
		 // do something here...
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
		// To do contain operation
		System.out.println("Triangle t1 created, area is " + t1.getArea() + " perimeter is " + t1.getPerimeter());
		MyPoint temp = new MyPoint(3,3);
	    System.out.println("Point 3,3 is inside the triange:  " +   t1.contains(temp));
	    System.out.println("t1 contains new triangle (2.9, 2), (4,1), (1, 3.4) :  " +  
	    t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
	    System.out.println("t1 overlaps new triangle (2, 5.5), (4,-3), (2, 6.5) :  " +  
	    	    t1.overlaps(new Triangle2D(new MyPoint(2, 5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
	    
	    
	    
		Triangle2D t2 = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 2), new MyPoint(2, 0));
		
		System.out.println("Triangle t2 created, area is " + t2.getArea() + " perimeter is " + t2.getPerimeter());
		temp = new MyPoint(1,1);
	    System.out.println("Point 1,1 is inside the triange:  " +   t2.contains(temp));
	    System.out.println("t2 contains new triangle (4, 5), (10.5, 3.2), (-.05, -10.5) :  " +  
	    	    t2.contains(new Triangle2D(new MyPoint(4, 5), new MyPoint(10.5, 3.2), new MyPoint(-.5, -10.5))));
		
	    System.out.println("t2 overlaps new triangle (1, 1.7), (-1, 1.7), (0, -3) :  " +  
	    	    t1.overlaps(new Triangle2D(new MyPoint(1, 1.7 ), new MyPoint(-1, 1.7), new MyPoint(0, -3))));
	    
	}
};
