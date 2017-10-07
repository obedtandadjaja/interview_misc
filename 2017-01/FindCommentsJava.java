import java.util.*;
public class FindCommentsJava {

  public static void main(String[] args) {
    String s =
      "/* //file created by aonecode.com\\n" +
      "welcome// to the tech blog */ \\n" +
      "// main /*method*/\\n"+
      "public static void main(String[] args) {\\n"+
      "  System.out.println(\"welcome\");//output\\n"+
      "}";
    try {
      ArrayList<String> comments = getComments(s);
      System.out.println(comments.toString());
    } catch (InvalidSyntaxException e) {
      System.out.println(e.getMessage());
    }
  }

  public static ArrayList<String> getComments(String s) throws InvalidSyntaxException {
    ArrayList<String> comments = new ArrayList<String>();
    boolean currentSingleComment = false;
    boolean currentMultiLineComment = false;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length()-1; i++) {
      if(s.charAt(i) == '\\' && s.charAt(i+1) == 'n' && currentSingleComment) {
        currentSingleComment = false;
        comments.add(sb.toString());
        sb = new StringBuilder();
        i++;
      } else if(s.charAt(i) == '*' && s.charAt(i+1) == '/' && currentMultiLineComment) {
        currentMultiLineComment = false;
        comments.add(sb.toString());
        sb = new StringBuilder();
        i++;
      } else if(currentSingleComment || currentMultiLineComment) {
        sb.append(s.charAt(i));
      } else if(s.charAt(i) == '/' && s.charAt(i+1) == '/') {
        currentSingleComment = true;
        i++;
      } else if(s.charAt(i) == '/' && s.charAt(i+1) == '*') {
        currentMultiLineComment = true;
        i++;
      }
    }
    if(sb.length() > 0) throw new InvalidSyntaxException("Comment syntax error");
    return comments;
  }

  public static class InvalidSyntaxException extends Exception {
    public InvalidSyntaxException(String message) {
      super(message);
    }
  }
}
