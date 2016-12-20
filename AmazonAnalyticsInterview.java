//pijain@amazon.com
public static void generate(String res, int max) {
  if(res.length() == max*2) System.out.println(res);
  else {
    int count1 = res.length()-res.replace("(","").length();
    int count2 = res.length()-res.replace(")","").length();
    if(count1 < max) {
      generate(res+"(", max);
    }
    if(count1 > count2) {
      generate(res+")", max);
    }
  }
}