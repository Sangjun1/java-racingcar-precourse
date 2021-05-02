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
	private Integer startMoveCount;

	public RacingGameGroup(String carNames, Integer maxMoveCount, Integer startMoveCount) {
		this.carNames = carNames;
		this.maxMoveCount = maxMoveCount;
		this.startMoveCount = startMoveCount;
	}

	public String getCarNames() {
		return carNames;
	}

	public Integer getMaxMoveCount() {
		return maxMoveCount;
	}

	public Integer getStartMoveCount() {
		return startMoveCount;
	}
}
