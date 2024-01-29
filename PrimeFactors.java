import java.util.Scanner;

class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        printPrimeFactors(N);
    }

    static void sieveOfEratosthenes(int N, boolean[] isPrime) {
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static void printPrimeFactors(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        sieveOfEratosthenes(N, isPrime);

        for (int i = 2; i <= N; i++) {
            while (N % i == 0 && isPrime[i]) {
                System.out.print(i + " ");
                N /= i;
            }
        }
    }
    /*
     static void printPrimeFactors(int N) {
        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                System.out.print(i + " ");
                N /= i;
            }
        }
    }
     */
}

