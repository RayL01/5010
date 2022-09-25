package weather;
//Design and implement a class called WeatherReading that represents a single reading of a weather station in a Stevenson Station.
// Your constructor takes four parameters: the air temperature in Celsius,
// the dew point temperature in Celsius which cannot be greater than the air temperature,
// the non-negative wind speed in miles per hour,
// and the non-negative total rain received in the last 24 inches (Tom's note: this doesn't make sense to, crossing it out...) in millimeters. It should throw an IllegalArgumentException for invalid values.
//
//Methods that get different values from an object are called accessor methods or getters because they are named starting with "get". Your implementation should include each of the following: (Tom's note: getHeatIndex and getWindChill return double, others return int)
/*
Dew point is the temperature at below which water droplets (or dew) begin to form. The relationship between dew point (D), temperature in degrees Celsius (T), and relative humidity in percentage between 0 and 100 (R) is expressed in the following formula:
D = T - (100-R)/5

        Heat index is a measure of how hot it feels when relative humidity is factored in with the actual temperature. It is calculated in a number of different ways but for our example, consider the formula for heat index (HI):

        where T is the temperature in degrees Celsius, R is the relative humidity in percent, and the coefficients are: c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605, c5 = -0.012308094, c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, and c9 = -0.000003582.

        Wind chill is related to heat index and is used when the real-feel temperature is lower than the actual temperature. There is some variation on how it is calculated depending on where you are but here in the United States, it is calculated with this formula:

        where WC is the wind chill based on the air temperature in degrees Fahrenheit (T) and the wind speed in miles per hour (v).
*/
public class WeatherReading {
  private int Temperature;//unit: Celsius
  private int DewPoint;//unit: Celsius
  private int WindSpeed;//unit: Miles/Hour
  private int TotalRain;//unit: millimeter
  private static final double C1 = -8.78469475556;
  private static final double C2 = 1.61139411;
  private static final double C3 = 2.33854883889;
  private static final double C4 = -0.14611605;
  private static final double C5 = -0.012308094;
  private static final double C6 = -0.016428277778;
  private static final double C7 = 0.002211732;
  private static final double C8 = 0.00072546;
  private static final double C9 = -0.000003582;

  public WeatherReading(int temperature, int dewPoint, int windSpeed, int totalRain) {
    Temperature = temperature;
    if((DewPoint = dewPoint) > Temperature){
      throw new IllegalArgumentException("the value of Dew point can not be larger than that of Temperature");
    }
    if((WindSpeed = windSpeed) < 0){
      throw new IllegalArgumentException("The value of wind speed can't be negative!");
    }
    if((TotalRain = totalRain) < 0){
      throw new IllegalArgumentException("The value of Total rain can't be negative!");
    }

  }

  public int getTemperature() {
    return Temperature;
  }

  public int getDewPoint() {
    return DewPoint;
  }

  public int getWindSpeed() {
    return WindSpeed;
  }

  public int getTotalRain() {
    return TotalRain;
  }
  public int getRelativeHumidity(){//45
    return 100 + (getDewPoint() - getTemperature()) * 5;
  }
  public double getHeatIndex(){
    int T = getTemperature();
    int R = getRelativeHumidity();
    double T2 = Math.pow(getTemperature(),2);
    double R2 = Math.pow(getRelativeHumidity(),2);
    return (C1 + (C2 * T) + (C3 * R)
            + (C4 * T * R) + (C5 * T2)
            + (C6 * R2) + (C7 * T2 * R)
            +  (C8 * T * R2) + (C9 * T2 * R2));
  }
  public double getWindChill(){
    double t = 32 + (1.8 * getTemperature());

    int v = getWindSpeed();

    return 35.74 + (0.6215 * t) - (35.75 * Math.pow(v, 0.16) )+ (0.4275 * t * Math.pow(v, 0.16));
  }

  @Override
  public String toString() {
    return "Reading"
            + ":  " +
            "T = " + Temperature +
            ", D = " + DewPoint +
            ", v = " + WindSpeed +
            ", rain = " + TotalRain;
  }
}
