/*
 * @(#) RacingGameValidator.java 2021. 05. 01.
 */
package com.tistory.ddoriya;

import com.tistory.ddoriya.constants.GameRule;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 이상준
 */
public class RacingGameValidator {

	public static boolean isNamesValid(String input) {
		if (isSplitNameValid(input) && isDuplicateNameValid(input)) {
			for (String name : input.split(",")) {
				if (!isSizeNameValid(name)) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public static boolean isNumberValid(String input) {
		String regExp = "^[1-9]+$";
		return input.matches(regExp);
	}

	public static boolean isSizeNameValid(String input) {
		if (input != null && input.length() <= GameRule.RACING_CAR_NAME_MAX_LENGTH) {
			return true;
		}

		return false;
	}

	public static boolean isDuplicateNameValid(String input) {
		Set<String> nameSet = new HashSet<>();
		for (String name : input.split(",")) {
			if (!nameSet.add(name)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isSplitNameValid(String input) {
		if (input.split(",").length > 1) {
			return true;
		}

		return false;
	}

}
