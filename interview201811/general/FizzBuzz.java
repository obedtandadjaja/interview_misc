/*
  Difficulty: Easy

  Write a program that outputs the string representation of numbers from 1 to n.

  But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

  Example:

  n = 15,

  Return:
  [
  "1",
  "2",
  "Fizz",
  "4",
  "Buzz",
  "Fizz",
  "7",
  "8",
  "Fizz",
  "Buzz",
  "11",
  "Fizz",
  "13",
  "14",
  "FizzBuzz"
  ]
 */

class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();

    for(int i = 1; i <= n; i++) result.add(Integer.toString(i));
    for(int i = 2; i < n; i += 3) result.set(i, "Fizz");
    for(int i = 4; i < n; i += 5) {
      if(result.get(i).equals("Fizz")) result.set(i, "FizzBuzz");
      else result.set(i, "Buzz");
    }

    return result;
  }

  public List<String> fizzBuzz2(int n) {
    List<String> result = new ArrayList<>();

    for(int i = 1; i <= n; i++) {
      if(i % 3 == 0 && i % 5 == 0) result.add("FizzBuzz");
      else if(i % 3 == 0) result.add("Fizz");
      else if(i % 5 == 0) result.add("Buzz");
      else result.add("" + i);
    }

    return result;
  }
}
