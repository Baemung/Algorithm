package facade;

import java.util.Timer;
import java.util.TimerTask;

public class MicrowaveTimer implements MicrowaveSwitch{
    public static long TIME_INTERVAL = 1000;
    private final int EXPIRED_TIME;
    private Timer timer;
    private TimerTask task;
    MicrowaveFacade microwave;
    int count = 0;
    
    public MicrowaveTimer(int sec, MicrowaveFacade microwave) {
        super();
        this.EXPIRED_TIME = sec;
        this.count = EXPIRED_TIME;
        this.microwave = microwave;
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(count > 0) System.out.println("Timer : " + (count--) + " sec");
                else {
                    System.out.println("Timer End");
                    timer.cancel();
                    microwave.off();
                }
            }
        };
    }
 
    @Override
    public void on() {
    	System.out.println("Timer Start" );
        timer.schedule(task, 0, TIME_INTERVAL);
    }
    
    @Override
    public void off() {
        timer.cancel();
    }
}
