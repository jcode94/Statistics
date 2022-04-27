package src;

import java.util.*;

public class Regression {

  public static Double r_squared(List<Integer> y, List<Double> y_hat) {
    return 1 - relative_square_error(y, y_hat);
  }

  public static Double relative_square_error(
    List<Integer> y,
    List<Double> y_hat
  ) {
    List<Double> y_means = Collections.nCopies(
      y.size(),
      y.stream().mapToDouble(a -> a).average().orElse(0.0) // mean
    );

    return (summation(y, y_hat, "rse") / summation(y, y_means, "rse"));
  }

  public static Double relative_absolute_error(
    List<Integer> y,
    List<Double> y_hat
  ) {
    // Needs review. Big waste of space vs passing single mean
    List<Double> y_means = Collections.nCopies(
      y.size(),
      y.stream().mapToDouble(a -> a).average().orElse(0.0) // mean
    );

    return summation(y, y_hat, "rae") / summation(y, y_means, "rae");
  }

  public static Double root_mean_squared_error(
    List<Integer> y,
    List<Double> y_hat
  ) {
    return Math.sqrt(mean_squared_error(y, y_hat));
  }

  public static Double mean_squared_error(List<Integer> y, List<Double> y_hat) {
    String typeName = "mse";
    return summation(y, y_hat, typeName) / y.size();
  }

  public static Double mean_absolute_error(
    List<Integer> y,
    List<Double> y_hat
  ) {
    return summation(y, y_hat, "mae") / y.size();
  }

  private static Double summation(
    List<Integer> y,
    List<Double> y_hat,
    String typeName
  ) {
    Double sum = 0d;

    ListIterator<Integer> targetIterator = y.listIterator();
    ListIterator<Double> predictedIterator = y_hat.listIterator();

    // Mean absolute error
    if (typeName.equals("mae") || typeName.equals("rae")) {
      while (targetIterator.hasNext()) {
        sum += Math.abs(targetIterator.next() - predictedIterator.next());
      }
    }
    // Mean squared error
    else if (typeName.equals("mse") || typeName.equals("rse")) {
      while (targetIterator.hasNext()) {
        sum =
          sum + Math.pow(targetIterator.next() - predictedIterator.next(), 2);
      }
    }

    return sum;
  }
}
