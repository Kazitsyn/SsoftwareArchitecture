package Cars;

/**
 * Класс уборочных машин
 */
public class CleaningMachine extends Car{
    private String extar = "SpecMachine";

    /**
     * Конструктор класса уборочных машин
     * @param mark марка авто
     * @param color цвет авто
     * @param model модель авто
     * @param control тип коробки передач
     * @param fuel_type тип топлева
     * @param num_wheels количество колес
     * @param vol_eng объем двигателя
     */
    public CleaningMachine(String mark, String color, String model, String control, String fuel_type, int num_wheels, double vol_eng) {

        super.color = color;
        super.model = model;
        super.control = control;
        super.fuel_type = fuel_type;
        super.mark = mark;
        super.num_wheels = num_wheels;
        super.vol_eng = vol_eng;
        super.exter = this.extar;
    }


    protected void cleaning(){}

    @Override
    public String toString() {
        return "CleaningMachine{" +
                "extar='" + extar + '\'' +
                ", mark='" + mark + '\'' +
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
