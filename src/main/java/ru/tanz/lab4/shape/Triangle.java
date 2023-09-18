package ru.tanz.lab4.shape;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.tanz.Shape;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Triangle implements Shape {
    double firstSide;
    double secondSide;
    double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        if (firstSide > 0)  this.firstSide = firstSide; else firstSide = 1;
        if (secondSide > 0)  this.secondSide = secondSide; else secondSide = 1;
        if (thirdSide > 0)  this.thirdSide = thirdSide; else thirdSide = 1;
//        if (firstSide + secondSide < thirdSide ||
//            firstSide + thirdSide < secondSide ||
//            secondSide + thirdSide < firstSide) {
////            throw new RuntimeException("Треугольник с данным сторонами не существует");
////        }
    }
    public boolean existTriangle(){
        return !(firstSide + secondSide < thirdSide) &&
                !(firstSide + thirdSide < secondSide) &&
                !(secondSide + thirdSide < firstSide);
    }
    public double getAngleBetweenFirstAndSecondSide(){
        return Math.ceil(Math.acos((Math.pow(firstSide, 2) + Math.pow(secondSide, 2) - Math.pow(thirdSide, 2))
                / (2 * firstSide * secondSide)) * 57.3);
    }
    public double getAngleBetweenSecondAndThirdSide(){
        return Math.ceil(Math.acos((Math.pow(thirdSide, 2) + Math.pow(secondSide, 2) - Math.pow(firstSide, 2))
                / (2 * thirdSide * secondSide)) * 57.3);
    }
    public double getAngleBetweenFirstAndThirdSide(){
        return 180 - getAngleBetweenFirstAndSecondSide() - getAngleBetweenSecondAndThirdSide();
    }

    @Override
    public double getPerimeter(){
        return firstSide + secondSide + thirdSide;
    }
    @Override
    public double getArea(){
        double halfPerimeter = Math.ceil(getPerimeter() / 2);
        return Math.ceil(Math.sqrt(halfPerimeter
                * (halfPerimeter - firstSide)
                * (halfPerimeter - secondSide)
                * (halfPerimeter - thirdSide)
        ));
    }
}
