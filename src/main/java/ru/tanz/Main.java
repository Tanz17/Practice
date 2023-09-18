package ru.tanz;

import ru.tanz.lab4.transport.car.Car;
import ru.tanz.lab4.transport.driver.CarDriver;
import ru.tanz.lab4.transport.driver.ServiceCarDriver;
import ru.tanz.lab4.transport.driver.TaxiDriver;
import ru.tanz.lab5.Container;
import ru.tanz.lab7.Codable;
import ru.tanz.lab7.MorseCode;
import ru.tanz.lab7.scheme.Scheme;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    //lab1-2

//    public static void main(String[] args) {
//        System.out.println("Создаем переменную типа Parallelogram");
//        Parallelogram shape;
//        System.out.println("Inициализируем переменную и вызываем конструктор");
//        shape = new Parallelogram(6.2, 4.2, 110);
//        System.out.println("Создали объект типа Parallelogram и передали в конструктор значения");
//        System.out.println("bottomSide: 6.2, leftSide: 4.2, angle: 110");
//        System.out.println("Площадь фигуры: " + shape.getArea());
//        System.out.println("Вызов сборщика мусора");
//        shape = null;
//        System.gc();
//        System.out.println(shape);
//
//    }

//    public static void main(String[] args) {
//        Circle circle = new Circle(5, 5, 3);
//    }


//    //Lab 4 (1)
//    public static void main(String[] args) {
////        Triangle triangle = new Triangle(3, 3, 5);
////        RightTriangle secondTriangle = new RightTriangle(3, 4, 5);
////        System.out.println(secondTriangle.isRight());
////        System.out.println(triangle.existTriangle());
////        System.out.println(triangle.getAngleBetweenFirstAndSecondSide());
////        System.out.println(triangle.getAngleBetweenSecondAndThirdSide());
////        System.out.println(triangle.getAngleBetweenFirstAndThirdSide());
////        System.out.println(triangle.getArea());
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите значение N: ");
//        int N = scanner.nextInt();
//        System.out.println("Введите значение M: ");
//        int M = scanner.nextInt();
//        Set<Triangle> triangles = new HashSet<>();
//        Set<RightTriangle> rightTriangles = new HashSet<>();
//        for (int i = 0; i < N; i++) {
//            triangles.add(new Triangle(ThreadLocalRandom.current().nextInt(1, 100 + 1),
//                                        ThreadLocalRandom.current().nextInt(1, 100 + 1),
//                                        ThreadLocalRandom.current().nextInt(1, 100 + 1)));
//        }
//        for (int i = 0; i < M; i++) {
//            rightTriangles.add(new RightTriangle(ThreadLocalRandom.current().nextInt(1, 10 + 1),
//                    ThreadLocalRandom.current().nextInt(1, 10 + 1),
//                    ThreadLocalRandom.current().nextInt(1, 10 + 1)));
//        }
//        val triangleWithMaxArea = triangles.stream()
//                .filter(Triangle::existTriangle)
//                .mapToDouble(Triangle::getArea)
//                .max().orElse(0);
//        val rightTriangleWithMinHypotenuse = rightTriangles.stream()
//                .filter(RightTriangle::isRight)
//                .mapToDouble(RightTriangle::getHypotenuse)
//                .min().orElse(0);
//        System.out.println("Треугольник с максимальной площадью: " + triangleWithMaxArea);
//        System.out.println("Прямоугольный треугольник с наименьшой гипотенузой: "
//                + rightTriangleWithMinHypotenuse);
//        }


//    //lab (2)
//    public static void main(String[] args) {
//        Car car = new Car("Lada", "Granta", 2011 , 200);
//        CarDriver carDriver = new CarDriver("Володя", 30, car);
//        ServiceCarDriver serviceCarDriver = new ServiceCarDriver("Санёк", 25, car, 1299);
//        TaxiDriver taxiDriver = new TaxiDriver("Мишаня", 40, car, "Yandex");
//
//        System.out.println("Водитель №1");
//        carDriver.getInfo();
//        System.out.println();
//
//        System.out.println("Водитель №2");
//        serviceCarDriver.getInfo();
//        System.out.println();
//
//        System.out.println("Водитель №3");
//        taxiDriver.getInfo();
//        System.out.println();
//    }


    //lab5
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Container list1 = new Container();
//        Container list2 = new Container();
//        int choice = 0;
//        do {
//            System.out.println("1. Добавить элементы в первый список");
//            System.out.println("2. Добавить элементы во второй список");
//            System.out.println("3. Получить элемент по индексу");
//            System.out.println("4. Определить размер списка");
//            System.out.println("5. Сложить два списка");
//            System.out.println("6. Перейти влево на n элементов");
//            System.out.println("7. Выход");
//            System.out.print("Выберите действие: ");
//            try {
//                choice = scanner.nextInt();
//                switch (choice) {
//                    case 1 -> {
//                        System.out.print("Введите количество элементов: ");
//                        int n1 = scanner.nextInt();
//                        for (int i = 0; i < n1; i++) {
//                            System.out.print("Введите элемент: ");
//                            int value = scanner.nextInt();
//                            list1.add(value);
//                        }
//                    }
//                    case 2 -> {
//                        System.out.print("Введите количество элементов: ");
//                        int n2 = scanner.nextInt();
//                        for (int i = 0; i < n2; i++) {
//                            System.out.print("Введите элемент: ");
//                            int value = scanner.nextInt();
//                            list2.add(value);
//                        }
//                    }
//                    case 3 -> {
//                        System.out.print("Введите индекс: ");
//                        int index = scanner.nextInt();
//                        System.out.print("Выберите номер списка: ");
//                        int n2 = scanner.nextInt();
//                        switch (n2){
//                            case 1 -> {
//                                if (index < 0 || index >= list1.getSize()) {
//                                    throw new IndexOutOfBoundsException("индекс выходит за границы списка");
//                                }
//                                System.out.println("Элемент: " + list1.get(index));
//                            }
//                            case 2 -> {
//                                if (index < 0 || index >= list2.getSize()) {
//                                    throw new IndexOutOfBoundsException("индекс выходит за границы списка");
//                                }
//                                System.out.println("Элемент: " + list2.get(index));
//                            }
//                            default -> System.out.println("Списка с таким номером нету");
//                        }
//                    }
//                    case 4 -> {
//                        System.out.print("Выберите номер списка: ");
//                        int n2 = scanner.nextInt();
//                        switch (n2){
//                            case 1 -> System.out.println("Размер списка: " + list1.getSize());
//                            case 2 -> System.out.println("Размер списка: " + list2.getSize());
//                            default -> System.out.println("Списка с таким номером нету");
//                        }
//                    }
//
//                    case 5 -> {
//                        if (list1.getSize() != list2.getSize()) {
//                            throw new IllegalArgumentException("Списки имеют разный размер");
//                        }
//                        Container result = list1.add(list2);
//                        for (int i = 0; i < result.getSize(); i++) {
//                            System.out.print(result.get(i) + " ");
//                        }
//                        System.out.println();
//                    }
//                    case 6 -> {
//                        System.out.print("Введите количество элементов: ");
//                        int n = scanner.nextInt();
//                        if (n < 0 || n >= list1.getSize()) {
//                            throw new IllegalArgumentException("Некорректное значение n");
//                        }
//                        list1.shiftLeft(n);
//                    }
//                    case 7 -> System.out.println("Выход");
//                    default -> System.out.println("Некорректный выбор");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Ошибка: введено некорректное значение");
//                scanner.nextLine();
//            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
//                System.out.println("Ошибка: " + e.getMessage());
//            }
//        } while (choice != 7);
//    }


    //lab6
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int choice = 0;
//
//        do {
//            System.out.println("Введите текст: ");
//            String input = scanner.nextLine();
//            System.out.println("Выберите номер задания: ");
//            System.out.println("1. Задание №1");
//            System.out.println("2. Задание №2");
//            System.out.println("3. Выход");
//            choice = scanner.nextInt();
//            Set<Character> symbols = new HashSet<>();
//            switch (choice){
//                case 1 -> {
//                    symbols.clear();
//                    for (int i = 0; i < input.length(); i++) {
//                        char symbol = input.charAt(i);
//                        if (symbol == '!' ||
//                            symbol == '@' ||
//                            symbol == '#' ||
//                            symbol == '$' ||
//                            symbol == '%' ||
//                            symbol == '^') {
//                            symbols.add(symbol);}
//                    }
//                    System.out.println("Полученное множество элементов: " + symbols);
//                }
//                case 2 -> {
//                    for (int i = 0; i < input.length(); i++) {
//                        char symbol = input.charAt(i);
//                        if (Character.isDigit(symbol)){
//                            symbols.add(symbol);
//                        }
//                    }
//                    System.out.println("Полученное множество цифр: " + symbols);
//                }
//                case 3 -> System.out.println("Выходим");
//            }
//        } while (choice != 3);
//    }

    public static void main(String[] args) {
        Codable codable = new MorseCode(Scheme.RUSSIAN);
        String text = "Привет, мир!";
        System.out.println(text);
        System.out.println(codable.encode(text));
        System.out.println(codable.decode(codable.encode(text)));


    }

}