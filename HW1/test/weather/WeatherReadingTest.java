package weather;

import org.junit.Before;
import org.junit.Test;

public class WeatherReadingTest {
  private WeatherReading weatherReading;
  @Before
  public void setUp() throws Exception {
    weatherReading = new WeatherReading(23, 12, 3, 12);

  }

  @Test
  public void getTemperature() {
    System.out.println("Temperature:" + weatherReading.getTemperature());
  }

  @Test
  public void getDewPoint() {
    System.out.println("DewPoint:"+ weatherReading.getDewPoint());
  }

  @Test
  public void getWindSpeed() {
    System.out.println("WindSpeed:" + weatherReading.getWindSpeed());
  }

  @Test
  public void getTotalRain() {
    System.out.println("TotalRain:" + weatherReading.getTotalRain());
  }

  @Test
  public void getRelativeHumidity() {
    System.out.println("RelativeHumidity:" + weatherReading.getRelativeHumidity());
  }

  @Test
  public void getHeatIndex() {
    System.out.println("HeatIndex:" + weatherReading.getHeatIndex());
  }
  @Test
  public void test(){
    return;
  }

  @Test
  public void getWindChill() {
    System.out.println("WindChill:" + weatherReading.getWindChill());
  }

  @Test
  public void testToString() {
    System.out.println(weatherReading);
  }
}
