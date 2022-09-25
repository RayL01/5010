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
    System.out.println(weatherReading.getTemperature());
  }

  @Test
  public void getDewPoint() {
    System.out.println(weatherReading.getDewPoint());
  }

  @Test
  public void getWindSpeed() {
    System.out.println(weatherReading.getWindSpeed());
  }

  @Test
  public void getTotalRain() {
    System.out.println(weatherReading.getTotalRain());
  }

  @Test
  public void getRelativeHumidity() {
    System.out.println(weatherReading.getRelativeHumidity());
  }

  @Test
  public void getHeatIndex() {
    System.out.println(weatherReading.getHeatIndex());
  }

  @Test
  public void getWindChill() {
    System.out.println(weatherReading.getWindChill());
  }

  @Test
  public void testToString() {
    System.out.println(weatherReading);
  }
}