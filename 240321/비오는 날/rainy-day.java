import java.util.Scanner;
import java.util.Arrays;

class dateWeather {
    String date;
    String day;
    String weather;

    public dateWeather(String date, String d, String w){
        this.date = date;
        this.day = d;
        this.weather = w;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dateWeather[] dw = new dateWeather[n];

        for(int i = 0 ; i < n ; i++){
            String nowDate = sc.next();
            String nowDay = sc.next();
            String nowWeather = sc.next();

            dw[i] = new dateWeather(nowDate, nowDay, nowWeather);
        }
        //여기까지는 문제없음

        String[] dates = new String[n];
        int idx = 0;

        for(int i = 0 ; i < n ; i++){
            if(dw[i].weather.equals("Rain")){
                dates[idx] = dw[i].date;
                idx++;
            }
        }

        Arrays.sort(dates, 0, idx);

       for(int i = 0 ; i < n ; i++){
            if(dw[i].date == dates[0]){
                System.out.print(dw[i].date+" "+dw[i].day+" "+dw[i].weather);
            }
        }

    }
}