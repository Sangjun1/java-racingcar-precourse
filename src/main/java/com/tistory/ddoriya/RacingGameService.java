/*
 * @(#) RacingGameServie.java 2021. 05. 01.
 */
package com.tistory.ddoriya;

import com.tistory.ddoriya.constants.GameRule;
import com.tistory.ddoriya.model.Car;
import com.tistory.ddoriya.model.CarBuilder;
import com.tistory.ddoriya.model.RacingGameGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 이상준
 */
public class RacingGameService {
	private RacingGameGroup racingGameGroup;
	private List<Car> carList;
	private Random random = new Random();

	public RacingGameService(RacingGameGroup racingGameGroup) throws IllegalArgumentException {
		if (!RacingGameValidator.isNamesValid(racingGameGroup.getCarNames())) {
			throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
		}

		this.racingGameGroup = racingGameGroup;
		initRacingGame();
	}

	private void initRacingGame() {
		carList = new ArrayList<>();
		String[] carNames = racingGameGroup.getCarNames().split(",");
		for (String carName : carNames) {
			carList.add(new CarBuilder().setName(carName).setMoveCount(racingGameGroup.getStartMoveCount()).build());
		}
	}

	//게임을 실행.
	public void executeGame() {
		for (Car car : carList) {
			if (isMove()) {
				car.move();
			}
		}
	}

	public List<String> getGameCompletedCarNameList() {
		List<String> completedCarNameList = new ArrayList<>();
		for (Car car : carList) {
			if (car.getMoveCount() == racingGameGroup.getMaxMoveCount()) {
				completedCarNameList.add(car.getName());
			}
		}

		return completedCarNameList;
	}

	//게임 완료 여부를 체크.
	public boolean isGameCompleted() {
		for (Car car : carList) {
			if (car.getMoveCount() == racingGameGroup.getMaxMoveCount()) {
				return true;
			}
		}
		return false;
	}

	//게임 메시지를 전달.
	public List<String> getGameMessages() {
		List<String> gameMessageList = new ArrayList<>();
		for (Car car : carList) {
			gameMessageList.add(String.format("%s : %s", car.getName(), car.getMoveText()));
		}

		return gameMessageList;
	}

	private boolean isMove() {
		int random = getRandomNumber();
		if (random >= 4) {
			return true;
		}

		return false;
	}

	//랜덤수를 전달.
	private int getRandomNumber() {
		return random.nextInt(GameRule.RACING_MAX_NUMBER);
	}
}
