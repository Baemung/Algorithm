package facade;

public class MicrowaveTest {
	public static void main(String[] args) {
		MicrowaveFacade microwave = new MicrowaveFacade(10);
        microwave.on();
	}
}
