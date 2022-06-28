import com.oocourse.elevator1.ElevatorInput;
import com.oocourse.elevator1.PersonRequest;

public class Input extends Thread {
    private Dispatcher dispatcher;
    private Checkend checkend;
    private ElevatorInput elevatorinput;
    private PersonRequest personRequest;
    
    
    public Input(Dispatcher dispatcher, Checkend checkend) {
        this.dispatcher = dispatcher;
        this.checkend = checkend;
        this.elevatorinput = new ElevatorInput();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                personRequest = elevatorinput.nextPersonRequest();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (dispatcher) {
                System.out.println("input run!");
                synchronized (checkend) {
                    if (personRequest == null) {
                        this.checkend.setEnd(true);
                        dispatcher.notify();
                        return;
                    }
                }
                
                this.dispatcher.addPersonRequest(personRequest);
                dispatcher.notify();
                try {
                    dispatcher.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
