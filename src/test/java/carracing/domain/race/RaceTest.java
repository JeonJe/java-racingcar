package carracing.domain.race;

import carracing.domain.car.Car;
import carracing.domain.car.Name;
import carracing.domain.car.Position;
import carracing.domain.record.RoundRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @DisplayName("이름 리스트로 자동차들을 초기화 할 수 있다")
    @Test
    void of() {
        List<String> carNames = List.of("green", "blue", "red");
        List<Car> expected = List.of(
                Car.of(Name.from("green"), Position.from(1)),
                Car.of(Name.from("blue"), Position.from(1)),
                Car.of(Name.from("red"), Position.from(1))
        );

        Race race = Race.of(carNames, 1, () -> false);

        assertThat(race.getCars())
                .hasSize(3)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 이동한 결과를 반환 받을 수 있다.")
    @Test
    void getCarRecords() {
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, 3, () -> true);

        List<RoundRecord> expected = List.of(
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(1)), Car.of(Name.from("blue"), Position.from(1)), Car.of(Name.from("red"), Position.from(1)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(2)), Car.of(Name.from("blue"), Position.from(2)), Car.of(Name.from("red"), Position.from(2)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(3)), Car.of(Name.from("blue"), Position.from(3)), Car.of(Name.from("red"), Position.from(3)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(4)), Car.of(Name.from("blue"), Position.from(4)), Car.of(Name.from("red"), Position.from(4))))
        );

        List<RoundRecord> result = race.start();

        assertThat(result)
                .hasSize(4)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}