package Cars;

/**
 * Абстрактный класс Car
 */
public abstract class Car implements iRefuel{
    protected iRefuel iRefuel;
    protected String mark, color, model, exter, fuel_type, control;
    protected int num_wheels;
    protected double vol_eng;
    protected boolean light_on = false;
    protected boolean wipers_on = false;
    protected boolean aniFogLight_on = false;

    /**
     * Конструктор
     */
    public Car() {}

    /**
     * Метод движения
     * @return
     */
    protected String movement(){
        return "Start";
    }

    /**
     * Метод сервисного обслуживания
     * @return
     */
    protected String service(){
        return "service";
    }

    /**
     * метод переключения передач
     * @param control_mode статус передачи
     */
    protected void changeControl(String control_mode){}

    /**
     * Метод включения фар
     * @param light_on статус включения фар
     */
    protected void isLight_on(boolean light_on){}

    /**
     * метод включения дворников
     * @param wipers_on статус включения дворников
     */
    protected void wipers_on(boolean wipers_on){}

    /**
     * метод включения противотуманных фар
     * @param aniFogLight_on статус включения противотуманных фар
     */
    protected void aniFogLight_on(boolean aniFogLight_on){}

    /**
     * Получить марку
     * @return
     */
    public String getMark() {
        return mark;
    }

    /**
     * Получить цвет
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Получить модель
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Получить тип кузова
     * @return
     */
    public String getExter() {
        return exter;
    }

    /**
     * Получить тип топлева
     * @return
     */
    public String getFuel_type() {
        return fuel_type;
    }

    /**
     * Получить тип коробки передач
     * @return
     */
    public String getControl() {
        return control;
    }

    /**
     * Получтить количество колес
     * @return
     */
    public int getNum_wheels() {
        return num_wheels;
    }

    /**
     * Получить объем двигателя
     * @return
     */
    public double getVol_eng() {
        return vol_eng;
    }

    /**
     * статус включения фар
     * @return
     */
    public boolean isLight_on() {
        return light_on;
    }

    /**
     * статус включения дворников
     * @return
     */
    public boolean isWipers_on() {
        return wipers_on;
    }

    /**
     * статус включения противотуманных фар
     * @return
     */
    public boolean isAniFogLight_on() {
        return aniFogLight_on;
    }

    /**
     * Установить цвет
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * установить тип топлева
     * @param fuel_type
     */
    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    /**
     * установить тип коробки передач
     * @param control
     */
    public void setControl(String control) {
        this.control = control;
    }

    /**
     * установить объем двигателя
     * @param vol_eng
     */
    public void setVol_eng(double vol_eng) {
        this.vol_eng = vol_eng;
    }

    /**
     * установить статус включения фар
     * @param light_on
     */
    public void setLight_on(boolean light_on) {
        this.light_on = light_on;
    }

    /**
     * установить статус включения дворников
     * @param wipers_on
     */
    public void setWipers_on(boolean wipers_on) {
        this.wipers_on = wipers_on;
    }

    /**
     * установить статус включения противотуманных фар
     * @param aniFogLight_on
     */
    public void setAniFogLight_on(boolean aniFogLight_on) {
        this.aniFogLight_on = aniFogLight_on;
    }

    /**
     * метод заправки
     */
    public void refuel(){
        iRefuel.refuel(fuel_type);
    }
}
