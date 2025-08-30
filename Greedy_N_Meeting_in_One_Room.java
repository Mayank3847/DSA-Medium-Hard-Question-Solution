import java.util.*;

public class Greedy_N_Meeting_in_One_Room {
   static  class Meeting {
        int start, end, pos;

        public Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static ArrayList<Integer> meetingInOneRoom(int start[], int end[], int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }
        meetings.sort((a, b) -> a.end - b.end);
        ArrayList<Integer> answer = new ArrayList<>();
        int lastOne = -1;
        for (int i = 0; i < meetings.size(); i++) {
            Meeting m = meetings.get(i);
            if (m.start > lastOne) {
                answer.add(m.pos);
                lastOne = m.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 5, 7, 9, 9 };
        int n = 6;
        ArrayList<Integer> result = meetingInOneRoom(start, end, n);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}
