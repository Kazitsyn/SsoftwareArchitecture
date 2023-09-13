package Cars;

/**
 * Класс маки Toyota
 */
public class Toyota extends Car {
    private final String mark = "Toyota";

    /**
     * Конструктор
     * @param color цвет
     * @param model модель
     * @param exter тип кузова
     * @param control тип коробки передач
     * @param fuel_type тип топлева
     * @param num_wheels количество колес
     * @param vol_eng объем двигателя
     */
    public Toyota(String color, String model, String exter, String control, String fuel_type, int num_wheels, double vol_eng) {

        super.color = color;
        super.model = model;
        super.exter = exter;
        super.control = control;
        super.fuel_type = fuel_type;
        super.mark = this.mark;
        super.num_wheels = num_wheels;
        super.vol_eng = vol_eng;
    }


    @Override
    public String toString() {
        return "Toyota{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", exter='" + exter + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", control='" + control + '\'' +
                '}';
    }

    /**
     * метод заправки
     *
     * @param fuel_type тип топлева
     */
    @Override
    public void refuel(String fuel_type) {

    }
}
