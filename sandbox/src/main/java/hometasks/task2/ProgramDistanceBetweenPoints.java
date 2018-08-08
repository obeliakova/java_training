package hometasks.task2;

public class ProgramDistanceBetweenPoints {

  public static void main(String[] args) {

    Point pointA = new Point(2.3, -1);
    Point pointB = new Point(0, 0);
    Point pointC = new Point(-10, -25);
    Point pointD = new Point(6.52, 0);

    printDistanceInfo(pointA, pointB);
    printDistanceInfo(pointC, pointA);
    printDistanceInfo(pointD, pointD);
    printDistanceInfo(pointD, pointA);

    pointA.printDistanceInfo(pointB);
    pointA.printDistanceInfo(pointC);
  }

  public static double distance(Point p1, Point p2){

    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }

  public static void printDistanceInfo(Point p1, Point p2){

    System.out.println("Функция printDistanceInfo");
    System.out.println("Дано: точки с координатами " + "(" + p1.x + "; " + p1.y + ") и ("+ p2.x + "; " + p2.y + ")");
    System.out.println("Расстояние между точками равно:");
    System.out.println("Используя функцию distance: " + distance(p1, p2));
    System.out.println("Используя метод distance: " + p1.distance(p2) + "\n");
  }

}
