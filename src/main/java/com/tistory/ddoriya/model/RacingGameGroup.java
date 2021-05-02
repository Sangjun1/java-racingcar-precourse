/*
 * @(#) RacingGameGroup.java 2021. 05. 01.
 */
package com.tistory.ddoriya.model;

/**
 * @author 이상준
 */
public class RacingGameGroup {
	private String carNames;
	private Integer maxMoveCount;

	public RacingGameGroup(String carNames, Integer maxMoveCount) {
		this.carNames = carNames;
		this.maxMoveCount = maxMoveCount;
	}

	public String getCarNames() {
		return carNames;
	}

	public Integer getMaxMoveCount() {
		return maxMoveCount;
	}
}
