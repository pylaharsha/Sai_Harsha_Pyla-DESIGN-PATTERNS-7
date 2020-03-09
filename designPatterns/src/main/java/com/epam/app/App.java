package com.epam.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.logging.Level; 
//import java.util.logging.Logger;

interface Trip {

public void plan();
}
class Normal_Trip implements Trip {

public void plan() {
System.out.print("Trip:\n");
}

}

class Vacation implements Trip {

protected Trip Trip;

public Vacation(Trip h){
this.Trip=h;
}


public void plan() {
this.Trip.plan();
}

}
 class National extends Vacation {

public National(Trip h) {
super(h);
}


public void plan(){
super.plan();
System.out.print("Plan for national trip.\n");
}
}
 class International extends Vacation {

public International(Trip h) {
super(h);
}


public void plan(){
super.plan();
System.out.print("Plan for International trip.\n");
}
}


public class App
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
   
    public static void main( String[] args )
    {
       LOGGER.log(null, null, Level.INFO,"use of memento,behaviour patterns and decorate,structural patterns.\n");
       Trip national = new National(new Normal_Trip());
       Trip international =new International(new Normal_Trip());
national.plan();
                international.plan();
System.out.println("\n*****");

Trip World_wide = new National(new International(new Normal_Trip()));
World_wide.plan();
       LOGGER.log(null, null, Level.INFO,"program terminated.\n");
       
    }
}
