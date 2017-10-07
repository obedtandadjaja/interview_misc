import java.util.*;
public class NextPermutation {
  public void permute(char input[]) {
    Map<Character, Integer> countMap = new TreeMap<>();
    for(char ch : input) {
      countMap.compute(ch, (key, val) -> {
        if(val == null) {
          return 1;
        } else {
          return val + 1;
        }
      });
    }
    char[] str = new char[countMap.size()];
    int[] count = new int[countMap.size()];
    int index = 0;
    for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
      str[index] = entry.getKey();
      count[index] = entry.getValue();
      index++;
    }
    char result[] = new char[input.length];
    permuteUtil(str, count, result, 0);
  }

  public void permuteUtil(char[] str, int[] count, char[] result, int level) {
    if(level == result.length) {
      System.out.println(Arrays.toString(result));
    } else {
      for(int i = 0; i < str.length; i++) {
        result[level] = str[i];
        count[i]--;
        permuteUtil(str, count, result, level+1);
        count[i]++;
      }
    }
  }
}
