class Solution {
    public int findMinArrowShots(int[][] points) {
if (points == null || points.length == 0) return 0;
        
        // Sort the balloons by their end coordinates
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int arrows = 1;
        int prevEnd = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the previous balloon ends,
            // we need an additional arrow
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }
        
        return arrows;
    }
}
