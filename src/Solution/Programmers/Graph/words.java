package Solution.Programmers.Graph;

public class words {
    static boolean visited[];
    static int answer;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
         visited = new boolean[words.length];

        dfs(0, begin, target, words);
        System.out.println(answer);
    }
    static void dfs(int cnt, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            int k = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == words[i].length()-1) {
                visited[i] = true;
                dfs(cnt+1, words[i], target, words);
                visited[i] = false;
            }
        }
    }
}
