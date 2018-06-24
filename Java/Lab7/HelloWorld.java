import java.awt.Point;



public class HelloWorld {
	public static void swap(Point points) {
		points.setLocation(points.getY(),points.getX());
	}
    public static void main( String[] args ) {
    	Point mypoint = new Point(1,2);
        System.out.println( swap(mypoint) );
        System.exit( 0 ); //success
    }
}
