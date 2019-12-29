import java.awt.geom.Line2D;

public class Triangle2D {

	MyPoint p1;
	MyPoint p2;
	MyPoint p3;
	
	static double  side1length, side2length, side3length;
	
	public Triangle2D(){
		p1 = new MyPoint(0,0);
		p2 = new MyPoint(1,1);
		p3 = new MyPoint(2,5);
		setSideLength();
	}
	
	
	public Triangle2D( MyPoint t1, MyPoint t2, MyPoint t3 ){
		p1 = t1;
		p2 = t2;
		p3 = t3;
		setSideLength();
	}
		
	
	public double getArea(){
		//To do calculate area	
		double s = getPerimeter()/2;
		
		double area = Math.sqrt(s*(s - side1length)*(s-side2length)*(s - side3length));
		
		return area;
	};
	
	
	
	
	public void setSideLength() {
		side1length = p1.Distance(p2);
		side2length = p1.Distance(p3);
		side3length = p3.Distance(p2);
	}
	
	
	public double getPerimeter() {
		//To do calculate perimeter	by adding up all 3 sides
		
		double perimeter = side1length + side2length + side3length;
		
		return perimeter;
	}
	
	
	public boolean contains(MyPoint p){
		//To do calculate
		double area = getArea();
		double t12pArea = (new Triangle2D(p, p1, p2)).getArea();
		double t13pArea = (new Triangle2D(p, p1, p3)).getArea();
		double t23pArea = (new Triangle2D(p, p2, p3)).getArea();
		double sumArea = t12pArea + t13pArea + t23pArea;
		
		if (area == sumArea) {
			return true;
			
		}else if (Math.abs(area - sumArea) < .001) {
			return true;
		
		}else {
			return false;
		}
	}
	
	public boolean contains(Triangle2D t) {
		boolean point1 = contains(t.p1);
		boolean point2 = contains(t.p2);
		boolean point3 = contains(t.p3);
		
		if(point1 == true && point2 == true && point3 == true) {
			return true;
		}else{
			return false;
		}
	}

	
	  public boolean overlaps(Triangle2D t) { boolean point1 = contains(t.p1);
	  boolean point2 = contains(t.p2); boolean point3 = contains(t.p3); boolean
	  sideCheck = overlaps2(t);
	  
	  
	  
	  if(point1 == true || point2 == true || point3 == true || sideCheck == true) {
	  return true; }else{ return false; }
	 }
	
	
	
	public boolean overlaps2(Triangle2D t) {
		
		boolean overlap1 = Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, t.p1.x, t.p1.y, t.p2.x, t.p2.y);
		boolean overlap2 = Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, t.p1.x, t.p1.y, t.p3.x, t.p3.y);
		boolean overlap3 = Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, t.p2.x, t.p2.y, t.p3.x, t.p3.y);
		//second line triangle 1
		
		boolean overlap4 = Line2D.linesIntersect(p1.x, p1.y, p3.x, p3.y, t.p1.x, t.p1.y, t.p2.x, t.p2.y);
		boolean overlap5 = Line2D.linesIntersect(p1.x, p1.y, p3.x, p3.y, t.p1.x, t.p1.y, t.p3.x, t.p3.y);
		boolean overlap6 = Line2D.linesIntersect(p1.x, p1.y, p3.x, p3.y, t.p2.x, t.p2.y, t.p3.x, t.p3.y);
		//third line
		boolean overlap7 = Line2D.linesIntersect(p2.x, p2.y, p3.x, p3.y, t.p1.x, t.p1.y, t.p2.x, t.p2.y);
		boolean overlap8 = Line2D.linesIntersect(p2.x, p2.y, p3.x, p3.y, t.p1.x, t.p1.y, t.p3.x, t.p3.y);
		boolean overlap9 = Line2D.linesIntersect(p2.x, p2.y, p3.x, p3.y, t.p2.x, t.p2.y, t.p3.x, t.p3.y);
		
		if(overlap1 == true || overlap2 == true || overlap3 == true || overlap4 == true || overlap5 == true 
				|| overlap6 == true || overlap7 == true || overlap8 == true || overlap9 == true  ){
		
			return true;
		}else{
			
			return false;
		}
	
	}

}


