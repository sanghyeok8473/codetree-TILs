import java.util.*;

class Marble {
    int x;
    int y;
    int dir;

    public Marble(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Marble marble = (Marble) obj;
        return x == marble.x && y == marble.y;
    }
}

public class Main {
    public static int t, n, m;
    public static int[] answer;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        answer = new int[t];

        for (int caseNum = 0; caseNum < t; caseNum++) {
            n = sc.nextInt();
            m = sc.nextInt();
            ArrayList<Marble> marbles = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int nowX = sc.nextInt() - 1;
                int nowY = sc.nextInt() - 1;
                int nowDir = 0;
                char nowD = sc.next().charAt(0);

                switch (nowD) {
                    case 'L':
                        nowDir = 3;
                        break;
                    case 'R':
                        nowDir = 1;
                        break;
                    case 'U':
                        nowDir = 0;
                        break;
                    case 'D':
                        nowDir = 2;
                        break;
                }
                marbles.add(new Marble(nowX, nowY, nowDir));
            }

            for (int time = 0; time < n * 2; time++) {
                HashMap<Marble, Integer> positionCount = new HashMap<>();
                ArrayList<Marble> newMarbles = new ArrayList<>();

                for (Marble marble : marbles) {
                    int[] nextXYDir = move(marble.x, marble.y, marble.dir);
                    Marble newMarble = new Marble(nextXYDir[0], nextXYDir[1], nextXYDir[2]);

                    positionCount.put(newMarble, positionCount.getOrDefault(newMarble, 0) + 1);
                    newMarbles.add(newMarble);
                }

                marbles.clear();
                for (Marble marble : newMarbles) {
                    if (positionCount.get(marble) == 1) {
                        marbles.add(marble);
                    }
                }
            }

            answer[caseNum] = marbles.size();
        }

        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    public static int[] move(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (rangeValid(nx, ny)) {
            return new int[]{nx, ny, dir};
        } else {
            return new int[]{x, y, (dir + 2) % 4};
        }
    }

    public static boolean rangeValid(int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}