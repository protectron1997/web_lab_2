package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dot implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean status;
    private String time;
    private final String date;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Dot(double x, double y, double r, boolean status){
        this.x = x;
        this.y = y;
        this.r = r;
        this.status = status;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        this.date = LocalDateTime.now().format(dtf);

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString(){
        return getX() + " " + getY() + " " + getR() + "\n";
    }
}
