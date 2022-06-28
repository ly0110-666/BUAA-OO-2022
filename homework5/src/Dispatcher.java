import com.oocourse.elevator1.PersonRequest;

import java.util.LinkedList;
import java.util.Queue;

//共享对象
public class Dispatcher {
    private Queue<PersonRequest> personRequests;
    
    public Dispatcher() {
        personRequests = new LinkedList<>();
    }
    
    public Queue<PersonRequest> getPersonRequests() {
        return personRequests;
    }
    
    public void setPersonRequests(Queue<PersonRequest> personRequests) {
        this.personRequests = personRequests;
    }
    
    public void addPersonRequest(PersonRequest personRequest) {
        this.personRequests.add(personRequest);
        
    }
    public void addPersonRequests(Queue<PersonRequest> personRequests) {
        this.personRequests.addAll(personRequests);
        
    }
    public PersonRequest getPersonRequest() {
        return this.personRequests.poll();
    }
}
