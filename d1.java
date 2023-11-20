import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, m, k;
        do {
            n = initSizeN();
            System.out.println();
            m = initSizeM();
        } while (!checkCondition(n, m));

        System.out.println();
        k = initSizeK(n);

        do {
            System.out.println("Множества \n");

            int sizeA = n;
            int sizeB = m;
            int[] a = initArray(n, n);
            int[] b = initArray(m, n);

            System.out.println("Сгенерированные множества A и B \n");
            System.out.print("Множество A = ");
            bubbleSort(a);
            showSet(a);

            System.out.print("Множество B = ");
            bubbleSort(b);
            showSet(b);
            System.out.println("\n\n");

            System.out.println("Первое задание: \n");
            task1(a, sizeA, b, sizeB);

            System.out.println("\n\nВторое задание: \n");
            task2(a, sizeA, b, sizeB);

            System.out.println("\n\nТретье задание: \n");
            task3(a, sizeA, b, sizeB);

            System.out.println("\n\nЧетвертое задание: \n");
            task4(b, sizeB, a, sizeA);

            System.out.println("\n\nПятое задание: \n");
            task5(a, sizeA, n, k);
        } while (menu(scanner, m, n, k));

        System.out.println();
        scanner.close();
    }

    private static boolean menu(Scanner scanner, int n, int m, int k) {
        do {
            System.out.println("\n\nВыберите следующее выполнение программы: \n"
                    + "[1] - Инициализировать переменную N \n"
                    + "[2] - Инициализировать переменную M \n"
                    + "[3] - Инициализировать переменную K \n"
                    + "[4] - Выполнить задание повторно \n"
                    + "[5] - Завершить работу программы \n\n");

            int choice;
            do {
                System.out.print("Введите номер пункта меню => ");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5)
                    System.out.println("Ошибка! Повторите ввод! \n");
            } while (choice < 1 || choice > 5);

            switch (choice) {
                case 1:
                    do {
                        System.out.println();
                        n = initSizeN();
                    } while (!checkCondition(n, m));
                    break;
                case 2:
                    do {
                        System.out.println();
                        m = initSizeM();
                    } while (!checkCondition(n, m));
                    break;
                case 3:
                    System.out.println();
                    k = initSizeK(n);
                    break;
                case 4:
                    return true;
                default:
                    return false;
            }
        } while (true);
    }

    private static void task1(int[] a, int sizeA, int[] b, int sizeB) {
        if (subset(b, sizeB, a, sizeA))
            System.out.println("Множество B является подмножеством A! \n");
        else
            System.out.println("Множество B не является подмножеством A! \n");
    }

    private static void task2(int[] a, int sizeA, int[] b, int sizeB) {
        int[] c = intersection(a, sizeA, b, sizeB);
        System.out.print("Пересечение множеств A и B = ");
        bubbleSort(c);
        showSet(c);
    }

    private static void task3(int[] a, int sizeA, int[] b, int sizeB) {
        int[] d = unification(a, sizeA, b, sizeB);
        System.out.print("Объединение множеств A и B = ");
        bubbleSort(d);
        showSet(d);
    }

    private static void task4(int[] a, int sizeA, int[] b, int sizeB) {
        int[] e = difference(a, sizeA, b, sizeB);
        System.out.print("Разность множеств B и A = ");
        bubbleSort(e);
        showSet(e);
    }

    private static void task5(int[] a, int sizeA, int n, int k) {
        k -= 1;
        System.out.print("Разбиение множества А на K подмножеств = ");
        int i = 0;

        System.out.print("{");
        while (i < k)
            System.out.print("{" + a[i++] + "}, ");
        System.out.print("{" + a[i++]);
        while (i < sizeA)
            System.out.print(", " + a[i++]);
        System.out.println("}}; \n");
    }

    private static int[] intersection(int[] arrayA, int sizeA, int[] arrayB, int sizeB) {
        int[] arrayNew = new int[0];
        for (int i = 0; i < sizeB; i++)
            if (exist(arrayA, sizeA, arrayB[i]))
                arrayNew = pushBack(arrayNew, arrayB[i]);
        return arrayNew;
    }

    private static int[] unification(int[] arrayA, int sizeA, int[] arrayB, int sizeB) {
        int[] arrayNew = new int[0];
        for (int i = 0; i < sizeA; i++)
            if (!exist(arrayNew, arrayA[i]))
                arrayNew = pushBack(arrayNew, arrayA[i]);
        for (int i = 0; i < sizeB; i++)
            if (!exist(arrayNew, arrayB[i]))
                arrayNew = pushBack(arrayNew, arrayB[i]);
        return arrayNew;
    }

    private static int[] difference(int[] arrayA, int sizeA, int[] arrayB, int sizeB) {
        int[] arrayNew = new int[0];
        for (int i = 0; i < sizeA; i++)
            if (!exist(arrayB, arrayA[i]))
                arrayNew = pushBack(arrayNew, arrayA[i]);
        return arrayNew;
    }

    private static boolean subset(int[] arrayA, int sizeA, int[] arrayB, int sizeB) {
        for (int i = 0; i < sizeA; i++)
            if (!exist(arrayB, arrayA[i]))
                return false;
        return true;
    }

    private static void showSet(int[] set) {
        int size = set.length;
        if (size == 0) System.out.println("{};");
        else if (size == 1) System.out.println("{" + set[0] + "};");
        else {
            System.out.print("{");
            for (int i = 0; i < size; i++) {
                if (i == 0) System.out.print("{" + set[i]);
                else if (i == size - 1) System.out.print(", " + set[i] + "}; \n");
                else System.out.print(", " + set[i]);
            }
        }
    }

    private static int[] initArray(int size, int n) {
        Random random = new Random();
        n += 6;
        int number;
        int[] array = new int[0];
        for (int realSize = 0; realSize < size;) {
            do {
                number = random.nextInt(n);
            } while (exist(array, number));
            array = pushBack(array, number);
            realSize++;
        }
        return array;
    }

    private static int[] pushBack(int[] array, int num) {
        int[] arrayNew = Arrays.copyOf(array, array.length + 1);
        arrayNew[array.length] = num;
        return arrayNew;
    }

    private static boolean exist(int[] array, int num) {
        for (int value : array)
            if (value == num) return true;
        return false;
    }

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++)
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    private static boolean checkCondition(int n, int m) {
        if (m > n) {
            System.out.println("Ошибка! Значение переменной N должно быть больше значения M или быть равным ему!");
            return false;
        }
        return true;
    }

    private static int initSizeN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер первого множества N из интервала [6, 10]. \n\n");
        int n;
        do {
            System.out.print("Введите натуральное значение N => ");
            n = scanner.nextInt();
            if (n < 6 || n > 10)
                System.out.println("Ошибка! Указанное значение не входит в заданный диапазон!");
        } while (n < 6 || n > 10);
        return n;
    }

    private static int initSizeM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер второго множества M из интервала [4, 8]. \n");
        System.out.println("Значение переменной M должно быть меньше или равно значению переменной N. \n\n");
        int m;
        do {
            System.out.print("Введите натуральное значение M => ");
            m = scanner.nextInt();
            if (m < 4 || m > 8)
                System.out.println("Ошибка! Указанное значение не входит в заданный диапазон!");
        } while (m < 4 || m > 8);
        return m;
    }

    private static int initSizeK(int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер третьего множества K из интервала [2, " + (n - 2) + "] \n");
        System.out.println("Значение переменной K должно быть меньше или равно значению переменной N. \n\n");
        int k;
        do {
            System.out.print("Введите натуральное значение K => ");
            k = scanner.nextInt();
            if (k < 2 || k > n - 2)
                System.out.println("Ошибка! Указанное значение не входит в заданный диапазон!");
        } while (k < 2 || k > n - 2);
        return k;
    }
}
