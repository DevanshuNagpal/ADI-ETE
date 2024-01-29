import  java.util.*;

public class WordBreak {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        int n = scanner.nextInt();
        List<String> wordDict = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            wordDict.add(scanner.next());
        }

        if (wordBreak(s, wordDict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] mem = new int[s.length()];
        return backtracking(s, 0, wordDict, mem);
    }

    private static boolean backtracking(String s, int i, List<String> wordDict, int[] mem) {
        if (i == s.length()) {
            return true;
        }
        if (mem[i] != 0) {
            return mem[i] == 1;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, i) && backtracking(s, i + word.length(), wordDict, mem)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = -1;
        return false;
    }
}
