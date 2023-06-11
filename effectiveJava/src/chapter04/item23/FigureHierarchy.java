package chapter02.item23;

// 태그 달린 클래스를 계층구조로 변환
public class FigureHierarchy {
    abstract static class Figure {
        abstract double area();
    }

    static class Circle extends Figure {
        final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * (radius * radius);
        }
    }

    static class Rectangle extends Figure {
        final double length;
        final double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }

    static class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }
    }
}
