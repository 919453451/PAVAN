/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package City;

/**
 *
 * @author s518750
 */
public class City {
    private String name;
    private int population;
    private double latitude;
    private double longitude;
    private double homeOwnershipRate;
    
    public City()
            {
    name = "unknown";
    this.population = 0;
    this.latitude = 0.0;
    this.longitude = 0.0;
    this.homeOwnershipRate = 0.0;
    //System.out.println("No-arg Pop: "+this.population);
    }
    
    public City(String name,int population,double latitude,double longitude,double homeOwnershipRate)
    {
        this.name = name;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
        this.homeOwnershipRate = homeOwnershipRate;
        //System.out.println("Para Pop: "+this.population);
    }
    
    public String getname(){
        return name;
    }
    
    public int getpopulation(){
        //System.out.println("Pop: "+population);
        return population;
    }
    
    public double getlatitude(){
        return latitude;
    }
    
    public double getlongitude(){
        return longitude;
    }
    
    public double gethomeOwnershipRate(){
        return homeOwnershipRate;
    }
    
    public void setname(String name){
        this.name = name;
    }
    
    public void setpopulation(int population)
    {
        this.population = population;
    }
    
    public void setlatitude(double latitude){
        this.latitude = latitude;
        
    }
    
    public void setlongitude(double longitude){
        this.longitude =  longitude;
    }
    
    public void sethomeOwnershipRate(double homeOwnershipRate){
        this.homeOwnershipRate = homeOwnershipRate;
    }
    
    @Override
    public String toString()
    {
       
    String s=String.format("name:%20s population:%20d", name,population);
    String s1=String.format("latitude:%10.2f longitude:%10.2f", latitude,longitude);
    String s2=String.format("homeOwnershipRate:%10.2f", (homeOwnershipRate*100));
    return s+"\n"+s1+"\n"+s2+"%";
}
        
    public double calculateDistance(City c){
        double x;
        double y;
        double distanceInMiles;
        x = 69.2*(c.longitude-longitude)*Math.cos(Math.toRadians(c.latitude+latitude)/2);
        y = 69.1*(c.latitude-latitude);
        distanceInMiles = Math.sqrt(x*x+y*y);
        return distanceInMiles;
        
        
    }
    public boolean hasSmallerPopulation(City c)
{
 if(population<c.population)
     return true;
 else return false;
     
}
public boolean isNorthOf(City c)
{
    if(latitude>c.latitude)
        return true;
    else
        return false;
}
public boolean isEastOf(City c)
{
    if(longitude>c.longitude)
        return true;
    else
        return false;
}
public int numHomeOwners()
{
  return (int) (Math.round(population*homeOwnershipRate));
}
    
}
