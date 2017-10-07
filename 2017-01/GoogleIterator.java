interface Iterator<T> {
  boolean hasNext();
  T next();
}

public class MyIterator implements Iterator<Integer> {
  int[] array;
  int curr_index;
  public MyIterator(int[] array) {
    this.curr_index = 0;
    this.array = array;
  }
  public boolean hasNext() {
    while(array[curr_index] == 0) {
curr_index += 2;
if(curr_index < array.length-1) return false;
}
    return true;
  }
  public Integer next() {
    array[curr_index]--;
    return array[curr_index+1];
  }
}

Iterator it = ..;
while(it.hasNext()) {
  print(it.next());
}

[3,8,0,9,2,12] -> 8,8,8,12,12

3 - print fizz
5 - print buzz
both - print fizz of buzz
else - print number

int fizz(int i);
int buzz(int i);
void print(int i);

for(int i = 1; i <= 100; i++) {
  if(i % 3 == 0 && i % 5 == 0) print(fizz(buzz(i)));
  else if(i % 3 == 0) print(fizz(i));
  else if(i % 5 == 0) print(buzz(i));
  else print(i);
}
