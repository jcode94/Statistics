package tst;
import static org.junit.Assert.assertEquals;

import java.util.*;
import org.junit.Test;

import src.Regression;

public class RegressionTest {

  private static List<Integer> y = Arrays.asList(10, 20, 30, 40, 50);
  private static List<Double> y_hat = Arrays.asList(
    3.0,
    12.0,
    20.0,
    42.0,
    60.0
  );

  @Test
  public void test_mean_absolute_error() {
    assertEquals(Regression.mean_absolute_error(y, y_hat), Double.valueOf(7.4));
  }

  @Test
  public void test_mean_squared_error() {
    assertEquals(Regression.mean_squared_error(y, y_hat), Double.valueOf(63.4));
  }

  @Test
  public void test_root_mean_squared_error() {
    assertEquals(
      Regression.root_mean_squared_error(y, y_hat),
      Double.valueOf(7.962411694957753)
    );
  }

  @Test
  public void test_relative_absolute_error() {
    assertEquals(
      Double.valueOf(0.6166666666666667),
      Regression.relative_absolute_error(y, y_hat)
    );
  }

  @Test
  public void test_relative_square_error() {
    assertEquals(
      Double.valueOf(0.317),
      Regression.relative_square_error(y, y_hat)
    );
  }

  @Test
  public void test_rSquared() {
    assertEquals(Regression.r_squared(y, y_hat), Double.valueOf(0.683));
  }
}
