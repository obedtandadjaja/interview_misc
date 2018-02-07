// Probability of reaching a point with 2 or 3 steps at a time
// A person starts walking from position X = 0, find the probability
// to reach exactly on X = N if she can only take either 2 steps or 3 steps.
// Probability for step length 2 is given i.e. P, probability for step length 3 is 1 – P.
//
// Input : N = 5, P = 0.20
// Output : 0.32
// Explanation :-
// There are two ways to reach 5.
// 2+3 with probability = 0.2 * 0.8 = 0.16
// 3+2 with probability = 0.8 * 0.2 = 0.16
// So, total probability = 0.32.

public class ReachingPointProbability {

  public static void main(String[] args) {
    System.out.println(getProbability(5, 0.2));
  }

  public static double getProbability(int n, double p) {
    double[] cache = new double[n+1];
    cache[0] = 1;
    cache[2] = p;
    cache[3] = 1.0-p;

    for(int i = 4; i <= n; i++) {
      cache[i] = cache[i-2] * p + cache[i-3] * (1.0-p);
    }

    return cache[n];
  }
}
