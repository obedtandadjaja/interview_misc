/*
  Difficulty: Hard

  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

  For example,
  [2,3,4], the median is 3

  [2,3], the median is (2 + 3) / 2 = 2.5

  Design a data structure that supports the following two operations:

  void addNum(int num) - Add a integer number from the data stream to the data structure.
  double findMedian() - Return the median of all elements so far.

  Example:

  addNum(1)
  addNum(2)
  findMedian() -> 1.5
  addNum(3)
  findMedian() -> 2

  Follow up:

  If all integer numbers from the stream are between 0 and 100, how would you optimize it?
  If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

 */

class MedianFinder {
  /** initialize your data structure here. */
  PriorityQueue<Integer> qLow;
  PriorityQueue<Integer> qHigh;

  public MedianFinder() {
    this.qLow = new PriorityQueue<Integer>(Collections.reverseOrder());
    this.qHigh = new PriorityQueue<Integer>();
  }

  public void addNum(int num) {
    if(qHigh.isEmpty()) {
      qHigh.add(num);
    } else if(qLow.size() == qHigh.size()) {
      if(num < qLow.peek()) {
        qLow.add(num);
        qHigh.add(qLow.poll());
      } else {
        qHigh.add(num);
      }
    } else {
      if(num > qHigh.peek()) {
        qHigh.add(num);
        qLow.add(qHigh.poll());
      } else {
        qLow.add(num);
      }
    }
  }

  public double findMedian() {
    if(qHigh.size() == qLow.size()) {
      return (qHigh.peek() + qLow.peek()) / 2.0;
    } else {
      return qHigh.peek();
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
