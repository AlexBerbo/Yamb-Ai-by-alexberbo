package com.comtrade.yamb.player;

public class Test {

	public static void main(String[] args) {
		SingletonExample se = SingletonExample.getInstance();
		SingletonExample se2 = SingletonExample.getInstance();
		
		System.out.println(se.increment());
		System.out.println(se2.increment());
		System.out.println(se.increment());
	}

}
