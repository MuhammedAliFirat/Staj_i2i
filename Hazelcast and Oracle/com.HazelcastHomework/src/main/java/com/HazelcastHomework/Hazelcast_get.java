package com.HazelcastHomework;

import java.util.Random;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Hazelcast_get {
	
	
	public static void main(String[] args ) {
		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		IMap<Object,Object> map = instance.getMap("mapTest");
		
		Random random = new Random();
		long startTime = System.nanoTime();
		for(int i = 0;i<100000;i++) {
			map.put(i, random.nextInt(20000));
		}
		long endTime = System.nanoTime()-startTime;
		double second = (double)endTime /1000000000.0;
		System.out.print("Hazelcast 100000 time = "+second);
		
	}

}
