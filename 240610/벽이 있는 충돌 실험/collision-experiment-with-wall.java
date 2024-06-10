import java.util.*;

class Marble {
    int x;
    int y;
    int dir;

    public Marble(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marble marble = (Marble) o;
        return x == marble.x && y == marble.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dir);
    }
};

public class Main {
    public static int t, n, m;
    public static int[] answer;
    public static int[][] board;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
                            // 상 우 하 좌
                            // 반대방향으로 전환 dir = (dir+2)%4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt(); answer = new int[t];
        for(int caseNum = 0 ; caseNum < t ; caseNum ++){
            n = sc.nextInt(); m = sc.nextInt();
            board = new int[n][n];
            ArrayList<Marble> marbles = new ArrayList<>();
            for(int i = 0 ; i < m ; i++){
                int nowX = sc.nextInt();
                int nowY = sc.nextInt();
                nowX--; nowY--;
                int nowDir = 0;
                char nowD = sc.next().charAt(0);
                switch(nowD){
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
                Marble nowMarble = new Marble(nowX, nowY, nowDir);
                marbles.add(nowMarble);
                
            }
            for(int time = 0 ; time < 95 ; time ++){
                for(int j = 0 ; j < marbles.size() ; j++){
                    int[] nextXYDir = move(marbles.get(j).x, marbles.get(j).y, marbles.get(j).dir);
                    marbles.get(j).x = nextXYDir[0];
                    marbles.get(j).y = nextXYDir[1];
                    marbles.get(j).dir = nextXYDir[2];
                }
                for(int k = 0 ; k < marbles.size()-1 ; k++){
                    for(int j = k+1 ; j < marbles.size() ; j++){
                        if(marbles.get(k).x == marbles.get(j).x && marbles.get(k).y == marbles.get(j).y){
                            int removeX = marbles.get(k).x, removeY = marbles.get(k).y;
                            marbles.remove(new Marble(removeX, removeY, 0));
                            marbles.remove(new Marble(removeX, removeY, 1));
                            marbles.remove(new Marble(removeX, removeY, 2));
                            marbles.remove(new Marble(removeX, removeY, 3));
                            break;
                        }
                    }
                }
            }
            answer[caseNum] = marbles.size();
        }
        for(int ans : answer)
            System.out.println(ans);
        // 정답 출력
    }

    public static int[] move(int x, int y, int dir){
        int[] temp = new int[3];
        switch(dir){
            case 0: // 상
                if(rangeValid(x-1, y)){
                    temp[0] = x-1; temp[1] = y; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 1: // 우
                if(rangeValid(x, y+1)){
                    temp[0] = x; temp[1] = y+1; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 2: // 하
                if(rangeValid(x+1, y)){
                    temp[0] = x+1; temp[1] = y; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 3: // 좌
                if(rangeValid(x, y-1)){
                    temp[0] = x; temp[1] = y-1; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
        }
        return temp;
    }

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}

/*import java.util.*;

public class Main {
    public static int t, n, m;
    public static int[] answer, marbleX, marbleY, marbleDir;
    public static int[][] board, count, nextCount;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
                            // 상 우 하 좌
                            // 반대방향으로 전환 dir = (dir+2)%4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt(); answer = new int[t];

        for(int caseNum = 0 ; caseNum < t ; caseNum ++){
            n = sc.nextInt(); m = sc.nextInt();
            board = new int[n][n];
            marbleX = new int[m]; marbleY = new int[m]; marbleDir = new char[m];
            for(int i = 0 ; i < m ; i++){
                marbleX[i] = sc.nextInt();
                marbleY[i] = sc.nextInt();
                board[marbleX[i]][marbleY[i]] = 1;
                char nowDir = sc.next().charAt(0);
                switch(nowDir){
                    case 'L':
                        marbleDir[i] = 3;
                        break;
                    case 'R':
                        marbleDir[i] = 1;
                        break;
                    case 'U':
                        marbleDir[i] = 0;
                        break;
                    case 'D':
                        marbleDir[i] = 2;
                        break;
                }
            }
            for(int time = 0 ; time < 8 ; time ++){
                nextCount = new int[n][n];
                for(int i = 0 ; i < m ; i++){
                    int[] nextXandYandDir = move(marbleX[i], marbleY[i], marbleDir[i]);
                    marbleX[i] = nextXandYandDir[0];
                    marbleY[i] = nextXandYandDir[1];
                    marbleDir[i] = nextXandYandDir[2];
                    nextCount[marbleX[i]][marbleY[i]]++;
                }
                for(int i = 0 ; i < n ; i++){
                    for(int j = 0 ; j < n ; j++){
                        if(nextCount[i][j] > 1)
                            nextCount[i][j] = 0;
                    }
                }
                board = copy(nextCount);
            }
        }
    }

    public static int[] move(int x, int y, int dir){
        int temp = new int[3];
        switch(dir){
            case 0: // 상
                if(rangeValid(x-1, y)){
                    temp[0] = x-1; temp[1] = y; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 1: // 우
                if(rangeValid(x, y+1)){
                    temp[0] = x; temp[1] = y+1; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 2: // 하
                if(rangeValid(x+1, y)){
                    temp[0] = x+1; temp[1] = y; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
            case 3: // 좌
                if(rangeValid(x, y-1)){
                    temp[0] = x; temp[1] = y-1; temp[2] = dir;
                }
                else{
                    temp[0] = x; temp[1] = y; temp[2] = (dir+2)%4;    // 방향만 반대로
                }
                break;
        }
        return temp;
    }

    public static int[][] copy(int[][] arr){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
        
    }

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}*/