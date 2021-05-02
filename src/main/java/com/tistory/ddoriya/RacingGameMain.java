/*
 * @(#) RacingCarGameMain.java 2021. 04. 30.
 */
package com.tistory.ddoriya;

import com.tistory.ddoriya.model.RacingGameGroupBuilder;

import java.util.Scanner;

/**
 * @author 이상준
 */
public class RacingGameMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		playGame(scanner);
	}

	private static void playGame(Scanner scanner) {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로 구분)");
			String carNames = scanner.nextLine();

			System.out.println("시도할 회수는 몇회인가요?");
			int racingCount = scanner.nextInt();
			RacingGameService racingGameService = new RacingGameService(new RacingGameGroupBuilder().setCarNames(carNames).setMaxMoveCount(racingCount).build());
			while (!racingGameService.isGameCompleted()) {
				racingGameService.executeGame();
				for (String message : racingGameService.getGameMessages()) {
					System.out.println(message);
				}

				System.out.println();
			}

			System.out.println(String.format("%s 가 최종우승하였습니다.", String.join(",", racingGameService.getGameCompletedCarNameList())));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
