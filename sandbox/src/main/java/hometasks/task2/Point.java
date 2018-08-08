package hometasks.task2;

public class Point {
  double x;
  double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance(Point p){
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }

  public void printDistanceInfo(Point p){

    System.out.println("Метод printDistanceInfo");
    System.out.println("Дано: точки с координатами " + "(" + this.x + "; " + this.y + ") и ("+ p.x + "; " + p.y + ")");
    System.out.println("Расстояние между точками равно:");
    System.out.println("Используя функцию distance: " + ProgramDistanceBetweenPoints.distance(this, p));
    System.out.println("Используя метод distance: " + this.distance(p) + "\n");
  }
}
