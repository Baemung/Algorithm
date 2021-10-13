package facade;

public class MicrowaveFacade {
	MicrowaveCooler cooler;
    MicrowaveMagnetron magnetron;
    MicrowaveTimer timer;
    MicrowaveTurntable turntable;
    MicrowaveSwitch[] switches;
    boolean isActive = false;
    
    public MicrowaveFacade(MicrowaveCooler cooler, MicrowaveMagnetron magnetron, MicrowaveTimer timer, MicrowaveTurntable turntable) {
        super();
        this.cooler = cooler;
        this.turntable = turntable;
        this.magnetron = magnetron;
        this.timer = timer;
        switches = new MicrowaveSwitch[]{cooler, turntable,  magnetron, timer};
    }
 
    public MicrowaveFacade(int time) {
        super();
        cooler = new MicrowaveCooler();
        turntable = new MicrowaveTurntable();
        magnetron = new MicrowaveMagnetron();
        timer = new MicrowaveTimer(time, this);
        switches = new MicrowaveSwitch[]{cooler, turntable,  magnetron, timer};
    }
    
    public void on() {
    	System.out.println("Microwave On");
        for(int i=0; i<switches.length; ++i) {
            switches[i].on();
        }
        isActive = true;
    }
    
    public void off() {
        for(int i=switches.length-1; i>=0; i--) {
            switches[i].off();
        }
    	System.out.println("Microwave Off");
        isActive = false;
    }
}
