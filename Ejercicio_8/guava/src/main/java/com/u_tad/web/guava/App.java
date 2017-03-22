package com.u_tad.web.guava;

import java.util.Arrays;
import java.util.Collection;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class App 
{
    public static void main( String[] args )
    {
    	String primero = null;

    	if(Strings.isNullOrEmpty(primero)){
    		System.out.println("El primer string es null o esta vacio.");
    	}
    	
        Multimap<String, String> outdoorElements = ArrayListMultimap.create();
        outdoorElements.put("fish", "walleye");
        outdoorElements.put("fish", "muskellunge");
        outdoorElements.put("fish", "bass");
        outdoorElements.put("insect", "ants");
        outdoorElements.put("insect", "water boatman");
        outdoorElements.put("insect", "Lord Howe Island stick insect");
        outdoorElements.put("tree", "oak");
        outdoorElements.put("tree", "birch");

        Collection<String> fishies = outdoorElements.get("fish");

        System.out.println(Arrays.toString(fishies.toArray()));
        
    }
}
