import java.util.Random;

class WeatherReport {
    private String[] city;
    private int[][] temperature;

    WeatherReport(String[] city) {
        this.city = city;
        temperature = new int[city.length][31];
        Random r = new Random();
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < 31; j++) {
                temperature[i][j] = r.nextInt(50);
            }
        }
    }

    void display() {
        System.out.println("The weather report for the cities are: ");
        System.out.print("Day\t");
        for (int i = 0; i < city.length; i++) {
            System.out.print(city[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < 31; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < city.length; j++) {
                System.out.print(temperature[j][i] + "\t");
            }
            System.out.println();
        }
    }

    void highestTemp() {
        int max = Integer.MIN_VALUE;
        int maxCity = 0;
        int maxDay = 0;
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < 31; j++) {
                if (temperature[i][j] > max) {
                    max = temperature[i][j];
                    maxCity = i;
                    maxDay = j;
                }
            }
        }
        System.out.println("The highest temperature is " + max + " in " + city[maxCity] + " on " + (maxDay + 1));
    }

    void lowestTemp() {
        int min = Integer.MAX_VALUE;
        int minCity = 0;
        int minDay = 0;
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < 31; j++) {
                if (temperature[i][j] < min) {
                    min = temperature[i][j];
                    minCity = i;
                    minDay = j;
                }
            }
        }
        System.out.println("The lowest temperature is " + min + " in " + city[minCity] + " on " + (minDay + 1));
    }

    void highestTempDay(int day) {
        int max = Integer.MIN_VALUE;
        int maxCity = 0;
        for (int i = 0; i < city.length; i++) {
            if (temperature[i][day - 1] > max) {
                max = temperature[i][day - 1];
                maxCity = i;
            }
        }
        System.out.println("The highest temperature on day " + day + " is " + max + " in " + city[maxCity]);
    }

    void lowestTempDay(int day) {
        int min = Integer.MAX_VALUE;
        int minCity = 0;
        for (int i = 0; i < city.length; i++) {
            if (temperature[i][day - 1] < min) {
                min = temperature[i][day - 1];
                minCity = i;
            }
        }
        System.out.println("The lowest temperature on day " + day + " is " + min + " in " + city[minCity]);
    }
}

public class WeatherDemo {
    public static void main(String[] args) {
        String[] city = {"Chennai", "Mumbai", "Delhi", "Kolkata", "Bangalore"};
        WeatherReport w = new WeatherReport(city);
        w.display();
        w.highestTemp();
        w.lowestTemp();
        w.highestTempDay(5);
        w.lowestTempDay(5);
    }
}
