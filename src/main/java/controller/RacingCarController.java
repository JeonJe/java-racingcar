package controller;

import model.RacingCars;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final RacingCars racingCars = RacingCars.of(inputView.inputRacingCarNumber());
        final int tryNumber = inputView.inputTryNumber();
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        outputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingCars.move(randomNumberGenerator);
            outputView.printResult(racingCars.getRacingCars());
        }
    }
}
