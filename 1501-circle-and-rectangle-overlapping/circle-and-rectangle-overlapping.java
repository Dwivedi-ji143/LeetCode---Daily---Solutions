class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center,
                                int x1, int y1, int x2, int y2) {
        int closestX = clamp(x_center, x1, x2);
        int closestY = clamp(y_center, y1, y2);
        int distanceX = x_center - closestX;
        int distanceY = y_center - closestY;
        return (distanceX * distanceX + distanceY * distanceY)
                <= (radius * radius);
    }
    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}