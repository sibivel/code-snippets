import java.util.*;

class Factorial {
  final static HashMap<Long, Long> cache = new HashMap<>();
  static long fact(long x) {
    if (x <= 0) {
      return 1;
    }
    if (!cache.containsKey(x)) {
      cache.put(x, x * fact(x-1));
    }
    return cache.get(x);
  }
}