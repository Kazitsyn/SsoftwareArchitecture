package Cars;

public abstract class Car {
    protected String mark, color, model, exter, fuel_type, control;
    protected int num_wheels;
    protected double vol_eng;
    private boolean light_on;
    protected String movement(){
        return "";
    }
    protected String service(){
        return "";
    }
    public void changeControl(String control_mode){

    }
    private void isLight_on(boolean light_on){
    }


}
