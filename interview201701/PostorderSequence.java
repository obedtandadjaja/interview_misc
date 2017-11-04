public class PostorderSequence {
  boolean VerifySquenceOfBST(int sequence[], int length)
  {
    if(sequence == null || length <= 0)
      return false;

    int root = sequence[length - 1];

      // nodes in left sub-tree are less than root node
    int i = 0;
    for(; i < length - 1; ++ i)
    {
      if(sequence[i] > root)
        break;
    }

      // nodes in right sub-tree are greater than root node
    int j = i;
    for(; j < length - 1; ++ j)
    {
      if(sequence[j] < root)
        return false;
    }

      // Is left sub-tree a binary search tree?
    boolean left = true;
    if(i > 0)
      left = VerifySquenceOfBST(sequence, i);

      // Is right sub-tree a binary search tree?
    boolean right = true;
    if(i < length - 1)
      right = VerifySquenceOfBST(sequence, length - i - 1);

    return (left && right);
  }
}
