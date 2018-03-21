/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        int origLength = intervals.size();
        
        // loop twice and find merging intervals for each
        for(int i = 0; i < intervals.size(); i++) {
            for(int j = 0; j < intervals.size(); j++) {
                if(i == j) continue;
                
                Interval i1 = intervals.get(i);
                Interval i2 = intervals.get(j);
                
                if(i1.end >= i2.start && i1.start <= i2.end) {
                    i1.start = Math.min(i1.start, i2.start);
                    i1.end = Math.max(i1.end, i2.end);
                    intervals.remove(j);
                    j--;
                }
            }
            if(intervals.size() < origLength) {
                origLength = intervals.size();
                i--;
            }
        }
        
        return intervals;
    }
    
    // faster - more optimized
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        // populate starts and ends array
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        // sort starts and ends separately
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { 
            // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
