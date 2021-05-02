/*
 * @(#) Car.java 2021. 05. 01.
 */
package com.tistory.ddoriya.model;

import com.tistory.ddoriya.constants.GameRule;

/**
 * @author 이상준
 */
public class Car {
	private String name;
	private Integer moveCount;

	public Car(String name, Integer moveCount) {
		this.name = name;
		this.moveCount = moveCount;
	}

	public void move() {
		this.moveCount++;
	}

	public String getName() {
		return name;
	}

	public Integer getMoveCount() {
		return moveCount;
	}

	public String getMoveText() {
		String moveText = "";
		for (int i = 0; i < moveCount; i++) {
			moveText += GameRule.RACING_CAR_MOVE_TEXT;
		}
		return moveText;
	}

	public void setMoveCount(Integer moveCount) {
		this.moveCount = moveCount;
	}
}
