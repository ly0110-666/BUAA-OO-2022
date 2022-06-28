import com.oocourse.TimableOutput;
import com.oocourse.elevator1.ElevatorInput;
import com.oocourse.elevator1.PersonRequest;

import java.io.IOException;

public class Mainclass {
    public static void main(String[] args) throws IOException {
        TimableOutput.initStartTimestamp();  // 初始化时间戳
          /*
              代码部分
          */
        
        
        Dispatcher dispatcher = new Dispatcher();
        Checkend checkend = new Checkend(false);
        Input input = new Input(dispatcher,checkend);
        Execute execute = new Execute(dispatcher,checkend);
        input.start();
        execute.start();
        
        
        
    }
}