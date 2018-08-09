package hometasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointTests {

  @Test
  public void testDistance() {
    Point pointA = new Point(1, 2);
    Point pointB = new Point(0, 0);
    Assert.assertEquals(pointA.distance(pointB), 2.23606797749979);
  }

  @Test
  public void testDistanceWithRounding() {
    Point pointA = new Point(1, 2);
    Point pointB = new Point(-10, -25);
    double distanceRound = new BigDecimal(pointA.distance(pointB)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    Assert.assertEquals(distanceRound, 29.155);
  }

  @Test
  public void testDistanceBetweenPointsWithSameCoordinates() {
    Point pointA = new Point(5.36, 0);
    Point pointB = new Point(5.36, 0);
    Assert.assertEquals(pointB.distance(pointA), 0.0);
  }
}
