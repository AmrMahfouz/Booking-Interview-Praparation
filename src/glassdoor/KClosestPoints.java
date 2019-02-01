package glassdoor;

import java.util.*;

public class KClosestPoints {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1,5));
        points.add(new Point(20,25));
        points.add(new Point(11,15));
        points.add(new Point(12,53));
        points.add(new Point(-1,-5));
        points.add(new Point(-11,-55));
        points.add(new Point(31,25));
        points.add(new Point(61,54));
        points.add(new Point(21,25));
        points.add(new Point(21,51));
        points.add(new Point(-1,-55));
        points.add(new Point(-10,-50));
        points.add(new Point(12,15));
        points.add(new Point(11,51));
        kClosestPoints(points, 4, new Point(5,5)).forEach(System.out::println);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static Double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private static List<Point> kClosestPoints(List<Point> points, int k, Point source) {
        // maintaining a queue as max heap
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> getDistance(p2, source).compareTo(getDistance(p1, source)));

        for (Point p : points) {
            if (maxHeap.size() < k) {
                maxHeap.add(p);
            } else if (getDistance(source, p) < getDistance(source, maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.add(p);
            }
        }

        List<Point> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        return result;
    }

}
