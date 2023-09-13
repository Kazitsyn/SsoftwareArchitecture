package Cars;

/**
 * Класс трицикл наследник класса  Car  с 3 колесами.
 */
public class Tricycle extends Car{
    protected final int num_wheels = 3;
    protected final String exter = "Tricycle";

    /**Конструктор класса трицикл
     * @param mark марка
     * @param color цвет
     * @param model модель
     * @param control тип коробки передач
     * @param fuel_type тип топлева
     * @param vol_eng объем двигателя
     */
    public Tricycle(String mark, String color, String model, String control, String fuel_type, double vol_eng) {
        super.mark = mark;
        super.color = color;
        super.model = model;
        super.exter = this.exter;
        super.control = control;
        super.fuel_type = fuel_type;
        super.num_wheels = this.num_wheels;
        super.vol_eng = vol_eng;
    }

    @Override
    public String toString() {
        return "Tricycle{" +
                "num_wheels=" + num_wheels +
                ", exter='" + exter + '\'' +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", exter='" + exter + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", control='" + control + '\'' +
                ", num_wheels=" + num_wheels +
                ", vol_eng=" + vol_eng +
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
