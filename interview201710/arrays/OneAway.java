import java.util.*;
import java.lang.Math;

public class OneAway {
  public static void main(String[] args) {
    System.out.println("asdf, asdf: " + isOneAway("asdf", "asdf"));
    System.out.println("asdf, asd: " + isOneAway("asdf", "asd"));
    System.out.println("asdf, asf: " + isOneAway("asdf", "asf"));
    System.out.println("asdf, adf: " + isOneAway("asdf", "adf"));
    System.out.println("asdf, sdf: " + isOneAway("asdf", "sdf"));
    System.out.println("asdf, asdg: " + isOneAway("asdf", "asdg"));
    System.out.println("asdf, asxf: " + isOneAway("asdf", "asxf"));
    System.out.println("asdf, axdf: " + isOneAway("asdf", "axdf"));
    System.out.println("asdf, xsdf: " + isOneAway("asdf", "xsdf"));
    System.out.println("asdf, xsdf: " + isOneAway("asdf", "xdf"));
  }

  public static boolean isOneAway(String str1, String str2) {
    if(str1.equals(str2)) return true;
    if(Math.abs(str1.length() - str2.length()) > 1) return false;

    int i = 0;
    for(i = 0; i < str1.length(); i++) {
      if(i == str1.length() || i == str2.length()) break;
      if(str1.charAt(i) != str2.charAt(i)) break;
    }

    boolean returnValue = true;

    // add and remove
    if(str1.length() > str2.length()) {
      returnValue &= str1.substring(i+1, str1.length()).equals(str2.substring(i, str2.length()));
    } else {
      returnValue &= str2.substring(i+1, str2.length()).equals(str1.substring(i, str1.length()));
    }

    // update
    if(!returnValue)
      if(i < str1.length() && i < str2.length())
        returnValue = str1.substring(i+1, str1.length()).equals(str2.substring(i+1, str2.length()));

    return returnValue;
  }
}
