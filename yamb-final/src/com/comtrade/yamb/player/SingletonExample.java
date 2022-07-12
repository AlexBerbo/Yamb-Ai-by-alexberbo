package com.comtrade.yamb.player;

public class SingletonExample {
	private int x = 0;
	private SingletonExample() {}
	
	private static SingletonExample instance;
	
	public static SingletonExample getInstance() {
		if (instance == null)
			instance = new SingletonExample();
		return instance;
	}
	
	public int increment() {
		return x++;
	}
}
