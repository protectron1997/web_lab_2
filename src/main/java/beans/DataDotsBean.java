package beans;

import java.io.Serializable;
import java.util.ArrayList;


public class DataDotsBean implements Serializable {
    private ArrayList<Dot> dataDots;

    public DataDotsBean(){
        this.dataDots = new ArrayList<>();
    }

    public void addDot(Dot dot){
        this.dataDots.add(dot);
    }

    public ArrayList<Dot> getDataDots() {
        return dataDots;
    }

    @Override
    public String toString(){
        String result = "";
        for (Object tmpDot : dataDots.toArray()){
            result += tmpDot.toString();
            result += "\n";
        }
        return result;
    }

}
