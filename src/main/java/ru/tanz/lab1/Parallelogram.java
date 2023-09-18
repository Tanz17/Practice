package ru.tanz.lab1;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.tanz.Shape;

@Getter@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Parallelogram implements Shape {
    double bottomSide;
    double leftSide;
    double angle;

    public Parallelogram(double bottomSide, double leftSide, double angle) {
        if (bottomSide > 0) this.bottomSide = bottomSide; else this.bottomSide = 1;
        if (leftSide > 0) this.leftSide = leftSide; else this.leftSide = 1;
        if (angle > 0) this.angle = angle; else this.angle = 90;
    }

    public double getHeight() {
        return getArea() / bottomSide;
    }

    public void increaseBottomSide(double percent){
        bottomSide = bottomSide + (bottomSide + (percent / 100));
    }
    public void decreaseBottomSide(double percent){
        bottomSide-= bottomSide + (percent / 100);
    }
    public void increaseLeftSide(double percent){
        leftSide+= leftSide + (percent / 100);
    }
    public void decreaseLeftSide(double percent){
        leftSide-= leftSide + (percent / 100);
    }
    public double getFirstDiagonal(){
        return Math.sqrt((leftSide * leftSide) + (bottomSide * bottomSide)
                - 2 * leftSide * bottomSide * Math.ceil(Math.cos(angle)));
    }
    public double getSecondDiagonal(){
        return Math.sqrt((2 * Math.pow(bottomSide, 2))
                - (2 * Math.pow(leftSide, 2)) - Math.pow(getFirstDiagonal(), 2));
    }
    @Override
    public double getArea() {
        return bottomSide * leftSide * Math.ceil(Math.sin(90));
    }
    @Override
    public double getPerimeter() {
        return (bottomSide + leftSide) * 2;
    }
}