package carracing.domain.record;

import carracing.domain.car.Car;
import carracing.domain.car.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundRecord {
    private final List<Car> cars = new ArrayList<>();

    private RoundRecord(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static RoundRecord from(List<Car> cars) {
        return new RoundRecord(cars);
    }

    public List<Car> getLeadingCar() {
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(calculateMaxPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    private Position calculateMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(Position::createMaxPosition)
                .orElse(Position.from(0));
    }

}
