package facade;

public class MicrowaveCooler implements MicrowaveSwitch{
	@Override
    public void on() {
        System.out.println("Cooler Start");
    }
    
    @Override
    public void off() {
        System.out.println("Cooler Stop");
    }
}
