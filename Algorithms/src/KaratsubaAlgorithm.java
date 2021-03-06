import java.util.Scanner;

public class KaratsubaAlgorithm {

    public static int getSize(long number) {
        int basePower = 0;
        while (number != 0) {
            basePower++;
            number /= 10;
        }
        return basePower;
    }

    public static long multiplyByKaratsubaAlgorithm(long x, long y) {
        // Ref.: https://en.wikipedia.org/wiki/Karatsuba_algorithm
        if (x < 10 || y < 10) {
            return x * y;
        }

        int xSize = getSize(x);
        int ySize = getSize(y);
        int maxSize = Math.max(xSize, ySize);
        int size = maxSize / 2 + maxSize % 2;
        long multiplier = (long) Math.pow(10, size);

        long xFirstPart = x / multiplier;
        long xSecondPart = x - (xFirstPart * multiplier);
        long yFirstPart = y / multiplier;
        long ySecondPart = y - (yFirstPart * multiplier);

        long z0 = multiplyByKaratsubaAlgorithm(xSecondPart, ySecondPart);
        long z1 = multiplyByKaratsubaAlgorithm(xFirstPart + xSecondPart, yFirstPart + ySecondPart);
        long z2 = multiplyByKaratsubaAlgorithm(xFirstPart, yFirstPart);

        return z2 * ((long) Math.pow(10, size * 2)) +  (z1 - z2 - z0) * multiplier + z0;
    }

    public static void main(String[] args) {
        // Cases:
        // x = 4,     y = 5
        // x = 40444, y = 50555 ---> 2044646420
        // x = 40444, y = 5555  ---> 224666420
        /*
        long x = 4;
        long y = 5;
        */
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two long numbers\n");
        long x = scan.nextLong();
        long y = scan.nextLong();

        long startTime1 = System.currentTimeMillis();
        long result1 = x*y;
        System.err.println(System.currentTimeMillis() - startTime1);

        long startTime2 = System.currentTimeMillis();
        long result2 = StandardMultiplication.multiplyByGradeSchoolApgorithm(x, y);
        System.err.println(System.currentTimeMillis() - startTime2);

        long startTime3 = System.currentTimeMillis();
        long result3 = KaratsubaAlgorithm.multiplyByKaratsubaAlgorithm(x, y);
        System.err.println(System.currentTimeMillis() - startTime3);

        System.out.printf("The product of %d and %d is %d\n", x, y, result1);
        System.out.printf("The product of %d and %d is %d (Standard Algorithm)\n", x, y, result2);
        System.out.printf("The product of %d and %d is %d (Karatsuba Algorithm)\n", x, y, result3);
        System.out.println(result1 == result3);
    }
}
