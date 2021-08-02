package com.HazelcastHomework;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Hazlecast_put {
	public static void main(String[] args) {
		HazelcastInstance _HazelcastInstance = Hazelcast.newHazelcastInstance();
		IMap<Object, Object> map = _HazelcastInstance.getMap("mapTest");
		
		Object random =0;
		long startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			random=map.get(i);
		}
		long endTime =System.nanoTime()-startTime;
		double second =(double)endTime/100000000.0;
		System.out.print("Hazelcast 100000 time = " +second);
	}

}
