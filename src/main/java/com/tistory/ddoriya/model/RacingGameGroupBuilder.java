/*
 * @(#) RacingGameGroupBuilder.java 2021. 05. 01.
 *
 * Copyright 2021. PlayD Corp. All rights Reserved.
 */
package com.tistory.ddoriya.model;

/**
 * @author 이상준
 */
public class RacingGameGroupBuilder {
	private String carNames;
	private Integer maxMoveCount;

	public RacingGameGroupBuilder setCarNames(String carNames) {
		this.carNames = carNames;
		return this;
	}

	public RacingGameGroupBuilder setMaxMoveCount(Integer maxMoveCount) {
		this.maxMoveCount = maxMoveCount;
		return this;
	}

	public RacingGameGroup build() {
		return new RacingGameGroup(carNames, maxMoveCount);
	}
}
