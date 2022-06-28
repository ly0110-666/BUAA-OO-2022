import com.oocourse.TimableOutput;
import com.oocourse.elevator1.PersonRequest;

public class Elevator {
    private PersonRequest personRequest;
    private int nowfloor;
    private char building;
    private int id;
    
    public Elevator(char building, int id) {
        this.nowfloor = 1;
        this.building = building;
        this.id = id;
    }
    
    public void accomplishpersonRequest(PersonRequest personRequest) throws InterruptedException {
        movetodeparture(personRequest.getFromFloor());
        open();
        in(personRequest);
        close();
        movetodestination(personRequest.getToFloor());
        open();
        out(personRequest);
        close();
    }
    
    private void movetodeparture(int tofloor) throws InterruptedException {
        if (nowfloor != tofloor) {
            if (nowfloor < tofloor) {
                for (; nowfloor < tofloor; nowfloor++) {
                    Execute.sleep(400);
                    TimableOutput.println(String.format("ARRIVE-%c-%d-%d", building, nowfloor + 1, id));
                }
            } else {
                for (; nowfloor > tofloor; nowfloor--) {
                    Execute.sleep(400);
                    TimableOutput.println(String.format("ARRIVE-%c-%d-%d", building, nowfloor - 1, id));
                }
            }
        }
    }
    
    private void movetodestination(int tofloor) throws InterruptedException {
        if (nowfloor < tofloor) {
            for (; nowfloor < tofloor; nowfloor++) {
                Execute.sleep(400);
                TimableOutput.println(String.format("ARRIVE-%c-%d-%d", building, nowfloor + 1, id));
            }
        } else {
            for (; nowfloor > tofloor; nowfloor--) {
                Execute.sleep(400);
                TimableOutput.println(String.format("ARRIVE-%c-%d-%d", building, nowfloor - 1, id));
            }
        }
    }
    
    private void open() throws InterruptedException {
        TimableOutput.println(String.format("OPEN-%c-%d-%d", building, nowfloor, id));
        Execute.sleep(200);
    }
    
    private void in(PersonRequest personRequest) {
        TimableOutput.println(String.format("IN-%d-%c-%d-%d", personRequest.getPersonId(), building, nowfloor, id));
    }
    
    private void out(PersonRequest personRequest) {
        TimableOutput.println(String.format("OUT-%d-%c-%d-%d", personRequest.getPersonId(), building, nowfloor, id));
    }
    
    private void close() throws InterruptedException {
        Execute.sleep(200);
        TimableOutput.println(String.format("CLOSE-%c-%d-%d", building, nowfloor, id));
    }
}
