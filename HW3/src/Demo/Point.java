package src.Demo;

public class Point {
    private int x = 0;
    private int y = 0;

    public Point(int x, int y) {
    this.x = x;
    this.y = y;
    }

    public void Set(int vertical, int horizontal) {
        this.x = vertical;
        this.y = horizontal;
        System.out.println(this.x + " " + this.y);
    }

    public void Move(int x, int y) {
        this.x += x;
        this.y += y;
        System.out.println(this.x + " " + this.y);
    }

    public void Rotate() {
        int swapTemp = this.x;
        this.x = y;
        this.y = -swapTemp;
        System.out.println(this.x + " " + this.y);
    }

    public int RetreiveVertical() {
        return this.x;
    }

    public int RetreiveHorizontal() {
        return this.y;
    }

    public int calculateManhattanDistance(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    public double ChebyshevDistance(Point other) {
        return Math.max(Math.abs(this.x - other.x), Math.abs(this.y - other.y));
    }
}
