/*
 * @(#) RacingGameGroupBuilder.java 2021. 05. 01.
 *
 * Copyright 2021. PlayD Corp. All rights Reserved.
 */
package com.tistory.ddoriya.model;

import com.tistory.ddoriya.constants.GameRule;

/**
 * @author 이상준
 */
public class RacingGameGroupBuilder {
	private String carNames;
	private Integer maxMoveCount;
	private Integer startMoveCount;

	public RacingGameGroupBuilder setCarNames(String carNames) {
		this.carNames = carNames;
		return this;
	}

	public RacingGameGroupBuilder setMaxMoveCount(Integer maxMoveCount) {
		this.maxMoveCount = maxMoveCount;
		return this;
	}

	public RacingGameGroupBuilder setStartMoveCount(Integer startMoveCount) {
		this.startMoveCount = startMoveCount;
		return this;
	}

	public RacingGameGroup build() {
		if (startMoveCount == null) {
			startMoveCount = GameRule.RACING_START;
		}

		return new RacingGameGroup(carNames, maxMoveCount, startMoveCount);
	}
}
