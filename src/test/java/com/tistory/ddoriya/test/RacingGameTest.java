/*
 * @(#) RacingGameTest.java 2021. 05. 02.
 */
package com.tistory.ddoriya.test;

import com.tistory.ddoriya.RacingGameService;
import com.tistory.ddoriya.RacingGameValidator;
import com.tistory.ddoriya.model.RacingGameGroupBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author 이상준
 */
public class RacingGameTest {
	private RacingGameService racingGameService;
	private String carNames;
	private int racingCount;
	static private String errorMessage = "입력값이 올바르지 않습니다.";

	@BeforeEach
	void setUp() {
		carNames = "pobi,crong,jun";
		racingCount = 5;
	}

	@Test
	@DisplayName("레이싱게임 자동차 문자가 5자 이상일 경우 Exception 테스트")
	public void input_car_name_exception_test() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			String carNames = "abcd,abcdef";
			int racingCount = 5;
			new RacingGameService(new RacingGameGroupBuilder().setCarNames(carNames).setMaxMoveCount(racingCount).build());
		}).withMessageMatching(errorMessage);
	}

	@Test
	@DisplayName("레이싱게임 자동차 대수가 1대 일 경우 Exception 테스트")
	public void input_IllegalArgumentException_test() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			String carNames = "abc12";
			int racingCount = 5;
			new RacingGameService(new RacingGameGroupBuilder().setCarNames(carNames).setMaxMoveCount(racingCount).build());
		}).withMessageMatching(errorMessage);
	}

	@Test
	@DisplayName("레이싱게임 우승자 테스트")
	public void game_completed_test() {
		racingGameService = new RacingGameService(new RacingGameGroupBuilder()
				.setCarNames(carNames)
				.setMaxMoveCount(racingCount)
				.setStartMoveCount(racingCount)
				.build());

		assertThat(racingGameService.getGameVictoryCarNameList().get(0)).isEqualTo("pobi");
		assertThat(racingGameService.getGameVictoryCarNameList().get(1)).isEqualTo("crong");
		assertThat(racingGameService.getGameVictoryCarNameList().get(2)).isEqualTo("jun");
	}

	@Test
	@DisplayName("레이싱게임 게임 메시지 테스트")
	public void game_message_test() {
		racingGameService = new RacingGameService(new RacingGameGroupBuilder()
				.setCarNames(carNames)
				.setMaxMoveCount(racingCount)
				.setStartMoveCount(3)
				.build());

		List<String> mesageList = racingGameService.getGameMessages();
		assertThat(mesageList.get(0)).isEqualTo("pobi : ---");
		assertThat(mesageList.get(1)).isEqualTo("crong : ---");
		assertThat(mesageList.get(2)).isEqualTo("jun : ---");
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "a56:false"}, delimiter = ':')
	@DisplayName("입력값이 숫자인지 테스트")
	public void number_valid_test(String input, boolean expected) {
		assertThat(RacingGameValidator.isNumberValid(input)).isEqualTo(expected);
	}


	@ParameterizedTest
	@CsvSource(value = {"abc:true", "jon:true", "sangjun:false"}, delimiter = ':')
	@DisplayName("자동차 이름이 5글자 이상인지 아닌지 테스트")
	public void name_size_valid_test(String input, boolean expected) {
		assertThat(RacingGameValidator.isSizeNameValid(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"abc,jon,jun:true", "abc,jon,jun,jon:false"}, delimiter = ':')
	@DisplayName("자동차 이름이 중복인지 테스트")
	public void name_duplicate_valid_test(String input, boolean expected) {
		assertThat(RacingGameValidator.isDuplicateNameValid(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"abc,jon,jun:true", "abc:false"}, delimiter = ':')
	@DisplayName("Split으로 배열값이 2개 이상인지 체크 테스트")
	public void name_split_valid_test(String input, boolean expected) {
		assertThat(RacingGameValidator.isSplitNameValid(input)).isEqualTo(expected);
	}
}
