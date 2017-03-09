package iterator.ir.a042;

import java.util.ArrayList;

/**
 * Created by mahmood on 3/9/17.
 */

public class HeaderInfo {

    public String getProvoniceName() {
        return provoniceName;
    }

    public void setProvoniceName(String provoniceName) {
        this.provoniceName = provoniceName;
    }

    private String provoniceName;

    public int getPopulation() {
        return population;
    }

    private int population;

    public ArrayList<DetailInfo> getCities() {
        return cities;
    }

    public void setCities(ArrayList<DetailInfo> cities) {
        this.cities = cities;

        int pop=0;

        for (DetailInfo info:cities)
        {
            pop+=info.getPopulation();
        }

        this.population=pop;
    }

    private ArrayList<DetailInfo> cities=new ArrayList<>();

}
