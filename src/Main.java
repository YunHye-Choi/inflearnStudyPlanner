import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int MIN = 28;

        System.out.println("Hello world!");
        List<Lecture> lectures = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sectionNum = 0;
        sc.nextLine();
        while (true) {
            String next = sc.nextLine().trim();
            if (next.startsWith("섹션")) {
                for (int i = 0; i < 2; i ++)
                    next = sc.nextLine();
                sectionNum ++;
            } else {
                String timeStr = sc.nextLine();
                String[] arr = timeStr.split(":");
                int min = Integer.parseInt(arr[0].trim());
                int sec = Integer.parseInt(arr[1].trim());
                int time = min * 60 + sec;

                int tenMinutes = 10 * 60 + 59;
                if (time > tenMinutes) {
                    int dividedLecNum = time / tenMinutes + 1;
                    for (int i = 0; i < dividedLecNum; i++) {
                        time /= dividedLecNum;
                        lectures.add(new Lecture("섹션 " + sectionNum, next + "(" + (i + 1) + "/" + dividedLecNum + ")", time));
                    }
                } else {
                    lectures.add(new Lecture("섹션 " + sectionNum, next, time));
                }
                if (next.trim().endsWith("다음으로"))
                    break;
            }
        }

        int sum = 0;
        int minSeconds = 60 * MIN;
        int index = 0;
        int day = 1;
        int lecCount = 0;
        for (Lecture lecture : lectures){
            index ++;
            sum += lecture.getTime();
            if (sum > minSeconds) {
                System.out.print("DAY" + day);
                System.out.print("\t" + lectures.get(index - lecCount - 1).getName());
                System.out.print("\t" + lecture.getName());
                System.out.print("\t" + (sum / 60) + "분 " + (sum % 60) + "초 \n");
                sum = 0;
                day++;
                lecCount = 0;
            } else {
                lecCount ++;
            }
        }

    }

    static class Lecture {
        String section;
        String name;
        int time; // sec

        public Lecture (String s, String n, int time){
            this.section = s;
            this.name = n;
            this.time = time;
        }

        public int getTime() {
            return time;
        }

        public String getName() {
            return section + ". " + name;
        }

    }
}