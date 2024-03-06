package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
	private final String string1 = "1";
	private final String string2 = "2";
	private final String stringWithComma = string1 + "," + string2;
	private final String stringWithCommaAndBracket = "(" + stringWithComma + ")";
	private final String string3 = "abc";

	@Test
	@DisplayName("split() 메소드를 이용하여 콤마를 기준으로 문자열을 분리한다.")
	void splitByComma() {
		assertThat(stringWithComma.split(",")).containsExactly(string1, string2);
		assertThat((string1).split(",")).containsExactly(string1);
	}

	@Test
	@DisplayName("substring() 메소드를 이용하여 앞 뒤의 괄호를 제거한다.")
	void removeBracketBySubstring() {
		assertThat(stringWithCommaAndBracket.substring(1, 4)).isEqualTo(stringWithComma);
	}

	@Test
	@DisplayName("charAt() 메소드를 이용하여 특정 위치의 문자를 조회할 수 있다.")
	void getChatByCharAt() {
		assertThat(string3.charAt(1)).isEqualTo('b');
	}

	@Test
	@DisplayName("charAt() 메소드를 이용하여 위치 값이 벗어난 문자를 조회할 경우 실패한다.")
	void failToGetCharByChatAt() {
		assertThatThrownBy(() -> string3.charAt(-1)).isInstanceOfAny(IndexOutOfBoundsException.class);
	}
}
