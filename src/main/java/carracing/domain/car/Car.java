package carracing.domain.car;

import java.util.Objects;

public class Car {
    private static final int ALLOWED_MINIMUM_DISTANCE = 4;

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.position = position;
        this.name = name;
    }

    public static Car of(Name name, Position position) {
        return new Car(name, position);
    }

    public static Car from(Name name) {
        return new Car(name, Position.create());
    }

    public Car move(int randomNumber) {
        if (canMove(randomNumber)) {
            Position increasedPosition = Position.from(position.increase());
            return new Car(name, increasedPosition);
        }
        return new Car(name, position);
    }

    private boolean canMove(int distance) {
        return distance >= ALLOWED_MINIMUM_DISTANCE;
    }

    public boolean isPositionEqualTo(Position position) {
        return this.position.isSame(position);
    }

    public String  getName() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
