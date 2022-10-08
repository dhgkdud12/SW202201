package Solution.Programmers.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class travleroute {
    static boolean[] visited;
    static ArrayList<String> arrayList;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN","JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        visited = new boolean[tickets.length];
        arrayList = new ArrayList();
        int cnt = 0;
        dfs("ICN", "ICN", tickets, cnt);

        String[] answer;
        answer = arrayList.get(0).split(" ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println(Arrays.toString(answer));

    }

    static void dfs(String start, String end, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            arrayList.add(end);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], end + " "+tickets[i][1], tickets,cnt+1);
                visited[i] = false;
            }
        }
    }
}
