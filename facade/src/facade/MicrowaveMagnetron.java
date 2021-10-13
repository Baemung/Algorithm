package facade;

public class MicrowaveMagnetron implements MicrowaveSwitch {
	 
    @Override
    public void on() {
        System.out.println("Magnetron Start");
    }
 
    @Override
    public void off() {
        System.out.println("Magnetron Stop");
    }
}