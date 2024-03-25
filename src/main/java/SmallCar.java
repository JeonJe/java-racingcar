/**
 * @author jeongheekim
 * @date 3/12/24
 */
public class SmallCar extends Car {
    private String status = "";

    @Override
    public void drive(int num, String delimeter) {
        if (num >= 4) {
            this.status = this.status + delimeter;
        }

    }

    @Override
    public int getNumber() {
        return (int) (Math.random() * 10);
    }


}
