package Cars;

/**
 * Клас летающей машины
 */
public class FlyCar extends Car{
    /**
     * Конструктор
     * @param color цвет
     * @param model модель
     * @param exter тип кузова
     * @param control тип коробки передач
     * @param fuel_type тип топлева
     * @param num_wheels количество колес
     * @param vol_eng объем двигателя
     * @param mark марка
     */
    public FlyCar(String color, String model, String exter, String control, String fuel_type, int num_wheels, double vol_eng, String mark) {
        super.color = color;
        super.model = model;
        super.exter = exter;
        super.control = control;
        super.fuel_type = fuel_type;
        super.mark = mark;
        super.num_wheels = num_wheels;
        super.vol_eng = vol_eng;
    }

    /**
     * метод полета
     */
    public void fly(){
        System.out.println("fly");
    }

    @Override
    public String toString() {
        return "FlyCar{" +
                "mark='" + mark + '\'' +
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
