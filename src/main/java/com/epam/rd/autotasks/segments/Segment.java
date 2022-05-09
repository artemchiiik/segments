package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if ((start.getX() == end.getX()) && (start.getY() == end.getY())) {
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.end = end;
    }

    double length() {
        return (sqrt(pow((end.getX() - start.getX()),2) + pow((end.getY() - start.getY()),2)));
    }

    Point middle() {
        return (new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2)));
    }

    Point intersection(Segment another) {
        double D = (this.start.getX() - this.end.getX()) * (another.start.getY() - another.end.getY()) - (this.start.getY() - this.end.getY()) * (another.start.getX() - another.end.getX());
        if (D == 0) {
            return null;
        }

        double t = ((this.start.getX() - another.start.getX()) * (another.start.getY() - another.end.getY()) - (this.start.getY() - another.start.getY()) * (another.start.getX() - another.end.getX())) / D;
        double u = ((this.start.getX() - another.start.getX()) * (this.start.getY() - this.end.getY()) - (this.start.getY() - another.start.getY()) * (this.start.getX() - this.end.getX()))/ D;

        double x = (this.start.getX() + t * (this.end.getX() - this.start.getX()));
        double y = (this.start.getY() + t * (this.end.getY() - this.start.getY()));

        if (t < 0 || t > 1){
            return null;
        }
        if (u < 0 || u > 1){
            return null;
        }

        return new Point(x, y);
    }

}
