public class StringFun {
  public static String toLowercase(String s) {
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < s.length(); index = index + 1) {
      char c = s.charAt(index);
      if ('A' <= c && c <= 'Z') 
        c = (char) (c - 'A' + 'a');
      builder.append(c);
    }
    return builder.toString();
  }
  public static String shout(String s, int n) {
    StringBuilder builder = new StringBuilder();
    for(int index = 0; index < s.length() + n; index = index + 1) {
      if (index < s.length())
        builder.append(s.charAt(index));
      else
        builder.append("!");
    }
    return builder.toString();
  }
  public static int counter() {
    int count = 1;
    int result = 0;
    while(count <= 10) {
      result = result + count;
      count = count + 1;
    }
    return result;
  }
  public static int forCounter() {
  int count = 1;
  int result = 0;
  for (int forCount = 1; forCount <= 10; forCount = forCount + 1)
    result = result + forCount;
  return result;
  }
}