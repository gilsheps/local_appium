import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import java.io.IOException;

/**
 * Created by gilsheps on 31/08/2016.
 */

/*
* This is example to how to run the server from code*/
public class App {
    public static void main( String[] args )
    {
        CommandLine command = new CommandLine("/usr/local/bin/node");
        command.addArgument("/usr/local/bin/appium",false);
        command.addArgument("--address",false);
        command.addArgument("127.0.0.1");
        command.addArgument("--port",false);
        command.addArgument("4723");
        command.addArgument("--session-override",true);
        command.addArgument("--log-level",false);
        command.addArgument("info:debug");
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);
        try {
            executor.execute(command, resultHandler);
        } catch (ExecuteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
