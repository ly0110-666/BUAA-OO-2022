import com.oocourse.TimableOutput;
import com.oocourse.elevator1.PersonRequest;

public class Execute extends Thread {
    private Elevator elevatorA;
    private Elevator elevatorB;
    private Elevator elevatorC;
    private Elevator elevatorD;
    private Elevator elevatorE;
    private Dispatcher dispatcher;
    private Checkend checkend;
    private PersonRequest personRequest;
    
    public Execute(Dispatcher dispatcher, Checkend checkend) {
        this.dispatcher = dispatcher;
        this.checkend = checkend;
        elevatorA = new Elevator('A', 1);
        elevatorB = new Elevator('B', 2);
        elevatorC = new Elevator('C', 3);
        elevatorD = new Elevator('D', 4);
        elevatorE = new Elevator('E', 5);
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (dispatcher) {
                System.out.println("execute run!");
//                System.out.println("Execute use Queue");
    
    
                synchronized (checkend) {
                    if (dispatcher.getPersonRequests().isEmpty() && checkend.isEnd()) {
//                        System.out.println("{{{{{{{{{{{{{{{{{");
                        return;
                    }
                }
                
                
                //调度器为空
                if (dispatcher.getPersonRequests().isEmpty()) {
                    try {
//                        System.out.println("into Input Thread");
                        dispatcher.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                personRequest = dispatcher.getPersonRequest();
                
                
                //策略类
                if (personRequest.getFromBuilding() == 'A' && personRequest.getToBuilding() == 'A') {
                    try {
                        elevatorA.accomplishpersonRequest(personRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (personRequest.getFromBuilding() == 'B' && personRequest.getToBuilding() == 'B') {
                    try {
                        elevatorB.accomplishpersonRequest(personRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (personRequest.getFromBuilding() == 'C' && personRequest.getToBuilding() == 'C') {
                    try {
                        elevatorC.accomplishpersonRequest(personRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (personRequest.getFromBuilding() == 'D' && personRequest.getToBuilding() == 'D') {
                    try {
                        elevatorD.accomplishpersonRequest(personRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (personRequest.getFromBuilding() == 'E' && personRequest.getToBuilding() == 'E') {
                    try {
                        elevatorE.accomplishpersonRequest(personRequest);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
