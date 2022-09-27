package com.nextstep.javaRacing.racing.race;

import com.nextstep.javaRacing.racing.race.Race;
import com.nextstep.javaRacing.racing.race.RaceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,4", "5,6"})
    @DisplayName("생성자로 전달받은 입력으로 레이스를 생성한다")
    void prepareRace(int cars, int turns) {
        Race race = RaceFactory.prepareRace(cars, turns);
        assertThat(race.cars.size()).isEqualTo(cars);
        assertThat(race.turns).isEqualTo(turns);
    }
}