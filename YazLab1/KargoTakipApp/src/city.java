
import javax.print.DocFlavor;


public class city {
    private static final double EARTH_EQUATORIAL_RADIUS=6378.1370D;
    private static final double CONVERT_DEGREES_TO_RADIANS=Math.PI/180D;
    private static final double CONVERT_KM_TO_MILES=0.621371;
    private double longitude;
    private double latitude;
    private String name;
    public city(String name,double latitude,double longitude){
        this.name=name;
        this.longitude=longitude*CONVERT_DEGREES_TO_RADIANS;
        this.latitude=latitude*CONVERT_DEGREES_TO_RADIANS;
    }
    public String getname(){
        return name;
    }
    public double getlatitude(){
        return this.latitude;
    }
    public double getlongitude(){
        return this.longitude;
    }
    public double measuredistance(city city1){
        double deltalongitude=(city1.getlongitude()-this.getlongitude());
        double deltalatitude=(city1.getlatitude()-this.getlatitude());
        double a=Math.pow(Math.sin(deltalatitude/2D),2D)+ Math.cos(this.getlatitude())*Math.cos(city1.getlatitude())*Math.pow(Math.sin(deltalongitude/2D), 2D);
        return CONVERT_KM_TO_MILES*EARTH_EQUATORIAL_RADIUS*2D*Math.atan2(Math.sqrt(a), Math.sqrt(1D-a));
    }
    public String toString(){
        return this.name;
    }
}
