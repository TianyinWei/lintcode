/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Point {
    int time;
    int takeoff;
    
    Point(int time, int takeoff) {
        this.time = time;
        this.takeoff = takeoff;
    }
}
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here By Xiao Tianyin
        
        if (airplanes == null || airplanes.size() == 0) return 0;
        Queue<Point> minHeap = new PriorityQueue<Point>(airplanes.size()*2, 
            new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    if (a.time != b.time) {
                        return a.time - b.time;
                    }   else {
                        return a.takeoff - b.takeoff;
                        //若同时有多架飞机起降，则先减去降落的飞机。
                    }
                }
            }
            );
            
        for (Interval plane : airplanes) {
            minHeap.offer(new Point(plane.start, 1));
            minHeap.offer(new Point(plane.end, -1));
        }
        
        int res = 0, cnt = 0;
        int size = minHeap.size();  //IMPORTANT
        for (int i = 0; i < size; i++) {
            Point point = minHeap.poll();
            cnt += point.takeoff;
            res = Math.max(res, cnt);
        }
        
        return res;
    }
}
