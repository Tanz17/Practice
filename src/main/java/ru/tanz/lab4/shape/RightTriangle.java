package ru.tanz.lab4.shape;

public class RightTriangle extends Triangle{
    public RightTriangle(double firstSide, double secondSide, double thirdSide) {
        super(firstSide, secondSide, thirdSide);
    }
    public boolean isRight() {

        return  Math.pow(getFirstSide(), 2) + Math.pow(getSecondSide(), 2) == Math.pow(getThirdSide(), 2) ||
                Math.pow(getFirstSide(), 2) + Math.pow(getThirdSide(), 2) == Math.pow(getSecondSide(), 2) ||
                Math.pow(getThirdSide(), 2) + Math.pow(getSecondSide(), 2) == Math.pow(getFirstSide(), 2);

    }
    public double getHypotenuse(){
        return Math.max(Math.max(getSecondSide(), getThirdSide()), getFirstSide());
    }

}
