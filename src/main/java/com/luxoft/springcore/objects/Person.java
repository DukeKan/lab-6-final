package com.luxoft.springcore.objects;


public interface Person {
    public void setName(String name);
    public String getName ();

    City getCity();

    void setCity(City city);

    int getDistanceTravelled();

    void setDistanceTravelled(int distanceTravelled);
}