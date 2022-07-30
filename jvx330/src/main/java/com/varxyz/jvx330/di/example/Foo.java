package com.varxyz.jvx330.di.example;

public class Foo {
	private Bar bar;
	
	public Foo() {
		System.out.println("Foo() constructor is called");
	}
	
	public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) is called");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() is called");
	}
	
	public String toString() {
		return "[Foo: " + hashCode() + "]";
	}
}
