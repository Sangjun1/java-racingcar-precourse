/*
 * @(#) CarBuilder.java 2021. 04. 30.
 */
package com.tistory.ddoriya.model;

/**
 * @author 이상준
 */
public class CarBuilder {
	private String name;
	private Integer moveCount;

	public CarBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CarBuilder setMoveCount(Integer moveCount) {
		this.moveCount = moveCount;
		return this;
	}

	public Car build() {
		return new Car(name, moveCount);
	}
}
