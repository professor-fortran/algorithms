package org.zcorp.algorithms.primes;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Алгоритм "Решето Эратосфена"
 */
public class EratosthenesSieve {
    public static void main(String[] args) {
        Util.sift(args, EratosthenesSieve::sieve);
    }

    /**
     * Реализация решета Эратосфена
     *
     * @param n положительное целое число >= 2
     * @return список простых чисел, меньших или равных n
     */
    private static List<Integer> sieve(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Число должно быть >= 2!");
        }

        // Создаем массив с индексами от 0 до n включительно
        Integer[] a = new Integer[n + 1];
        // Все элементы автоматически были заполнены null-ами, но для читабельности обнуляю первые 2 элемента явным образом
        a[0] = a[1] = null;
        // Заполняю массив по принципу:
        // каждое число p изначально считается простым до тех пор, пока не выяснится обратное,
        // и тогда в соотвествующий элемент массива будет занесен null
        for (int p = 2; p <= n; p++) {
            a[p] = p;
        }

        // Для любого числа p кратные ему числа - это 2*p, 3*p ... (p - 1)*p, p*p, (p + 1)*p ...
        //
        // Когда мы перебирали числа от 2 до текущего p, т.е. 2, 3 ... p - 1
        // числа вроде 2*p, 3*p ... (p - 1)*p уже были удалены из массива
        // и нам осталось удалить только p*p, (p + 1)*p ... вплоть до n
        //
        // При этом очевидно, что pMax*pMax <= n, чтобы не вылезти за пределы рассматриваемого интервала.
        // Следовательно, pMax <= Math.sqrt(n) и, следовательно, pMax = Math.floor(Math.sqrt(n))
        int pMax = (int) Math.floor(Math.sqrt(n));
        for (int p = 2; p <= pMax; p++) {
            // Если выполняется это условие, то число p - простое (prime),
            // т.к. оно не было удалено при рассмотрении чисел меньших p
            if (a[p] != null) {
                // А т.к. число p - простое, то смотрим нет ли чисел больших p, которые делятся на p и,
                // следовательно, не являющиеся простыми и, следовательно, подлежащие удалению из массива
                int j = p * p;
                while (j <= n) {
                    a[j] = null;
                    j = j + p;
                }
            }
        }

        return Arrays.stream(a)
                .filter(Objects::nonNull)
                .collect(toList());
    }
}
