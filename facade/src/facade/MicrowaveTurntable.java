package facade;

public class MicrowaveTurntable implements MicrowaveSwitch{
	 
    @Override
    public void on() {
        System.out.println("Turntable Start");
        
    }
 
    @Override
    public void off() {
        System.out.println("Turntable Stop");
        
    }
}