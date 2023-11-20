import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class MySet {
    private List<Integer> set = new ArrayList<>();

    public int size() {
        return set.size();
    }

    public boolean contains(int number) {
        return set.contains(number);
    }

    public void swap(MySet other) {
        set.clear();
        set.addAll(other.set);
        Collections.sort(set);
    }

    public int get(int index) {
        return set.get(index);
    }

    public void insert(int number) {
        if (!contains(number)) {
            set.add(number);
            Collections.sort(set);
        }
    }

    public void add(MySet other) {
        for (int number : other.set) {
            insert(number);
        }
    }

    public String showToString() {
        StringBuilder str = new StringBuilder("{ ");
        for (int i = 0, end = size() - 1; i < size(); i++) {
            str.append(set.get(i));
            if (i < end) {
                str.append(", ");
            }
        }
        str.append(" }");
        return str.toString();
    }

    public void sort() {
        Collections.sort(set);
    }
}

public class Main {
    public static final int N = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        MySet m = new MySet();
        for (int size = 5; m.size() < size; m.insert(random.nextInt(21) - 10));

        System.out.println("Отношение R = { (x,y) E А^2 | x+y>3, x<y} ");
        System.out.println("Сгенерированное множество М = " + m.showToString());
        System.out.println("\n\n");

        menu();
        int option = scanner.nextInt();

        while (option == 1 || option == 2) {
            if (option == 1) {
                MySet a = new MySet();
                for (int size = 5; a.size() < size; a.insert(random.nextInt(21) - 10));
                m.swap(a);
                System.out.println("Вы перегенерировали множество М.");
                System.out.println("Теперь множество М имеет вид: " + m.showToString());
            } else if (option == 2) {
                allFunctionList(m);
            }

            System.out.println("\n\n");
            menu();
            option = scanner.nextInt();
        }

        System.out.println("\n\nВы завершили работу программы! Спасибо за использование!");
    }





     private static void dual(boolean[][] array) {
        transposed(array);
        addition(array);
    }

    private static void transposed(boolean[][] array) {
        boolean temp;
        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }

    private static void addition(boolean[][] array) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = !array[i][j];
            }
        }
    }

    private static boolean[][] intersection(boolean[][] a, boolean[][] b) {
        boolean[][] result = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = a[i][j] && b[i][j];
            }
        }
        return result;
    }

    private static void showMatrixSimple(boolean[][] array) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((array[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    private static boolean relation(int x, int y) {
        return x + y > 3 && x < y;
    }

    // ... (остальной код)

    public static void main(String[] args) {
        // ... (остальной код)
        
        System.out.println("\n\nВы завершили работу программы! Спасибо за использование!\n\n");
    }













  

    private static void menu() {
        System.out.println("Что будем делать?");
        System.out.println("[1] - Перегенерировать множество;");
        System.out.println("[2] - Начать выполнение заданий;");
        System.out.println("[любой символ] - Завершение работы;\n\nВведите номер пункта меню => ");
    }

    private static void allFunctionList(MySet m) {
        System.out.println("Множество М имеет вид: " + m.showToString());
        System.out.println("R = { (x,y) E А^2 | x+y>3, x<y}. ");
        System.out.println("\n\n");

        // Реализация остальных функций...
    }
  private static void PropertyValidation(boolean[][] matrix) {
        if (isReflexivity(matrix)) {
            getGreenStr("[1] -> Свойство рефлексивности присутствует! \n");
        } else {
            getRedStr("[1] -> Свойство рефлексивности отсутствует! \n");
        }

        if (isAntiReflexivity(matrix)) {
            getGreenStr("[2] -> Свойство антирефлексивности присутствует! \n");
        } else {
            getRedStr("[2] -> Свойство антирефлексивности отсутствует! \n");
        }

        if (isIrReflexivity(matrix)) {
            getGreenStr("[3] -> Свойство иррефлексивности присутствует! \n");
        } else {
            getRedStr("[3] -> Свойство иррефлексивности отсутствует! \n");
        }

        if (isSymmetric(matrix)) {
            getGreenStr("[4] -> Свойство симметричности присутствует! \n");
        } else {
            getRedStr("[4] -> Свойство симметричности отсутствует! \n");
        }

        if (isAntiSymmetric(matrix)) {
            getGreenStr("[5] -> Свойство антисимметричности присутствует! \n");
        } else {
            getRedStr("[5] -> Свойство антисимметричности отсутствует! \n");
        }

        if (isAsymmetric(matrix)) {
            getGreenStr("[6] -> Свойство асимметричности присутствует! \n");
        } else {
            getRedStr("[6] -> Свойство асимметричности отсутствует! \n");
        }

        if (isTransitive(matrix)) {
            getGreenStr("[7] -> Свойство транзитивности присутствует! \n");
        } else {
            getRedStr("[7] -> Свойство транзитивности отсутствует! \n");
        }
    }

    private static boolean isReflexivity(boolean[][] rel) {
        for (int i = 0; i < N; i++) {
            if (!rel[i][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAntiReflexivity(boolean[][] rel) {
        for (int i = 0; i < N; i++) {
            if (rel[i][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIrReflexivity(boolean[][] rel) {
        for (int i = 0; i < N; i++) {
            if (rel[i][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSymmetric(boolean[][] rel) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rel[i][j] != rel[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAntiSymmetric(boolean[][] rel) {
        boolean[][] relTrans = transpose(rel);
        boolean[][] relInt = intersection(rel, relTrans);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && relInt[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAsymmetric(boolean[][] rel) {
        return isAntiReflexivity(rel) && isAntiSymmetric(rel);
    }

    private static boolean isTransitive(boolean[][] rel) {
        boolean[][] square = multiplication(rel, rel);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] > rel[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean[][] transpose(boolean[][] array) {
        boolean[][] transposedArray = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                transposedArray[i][j] = array[j][i];
                transposedArray[j][i] = array[i][j];
            }
        }
        return transposedArray;
    }

    private static boolean[][] intersection(boolean[][] a, boolean[][] b) {
        boolean[][] result = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = a[i][j] && b[i][j];
            }
        }
        return result;
    }

    private static boolean[][] multiplication(boolean[][] a, boolean[][] b) {
        boolean[][] result = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = result[i][j] || (a[i][k] && b[k][j]);
                }
            }
        }
        return result;
    }
}
