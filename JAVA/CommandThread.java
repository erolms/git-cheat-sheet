/*
 * MonitorAgent (c) 2000  Erol Zavidic
 * All rights reserverd.
 *
 */

/**
 * CommandThread.java
 * @version 1.0.0
 * @author Erol Zavidic
 *
 */

import java.lang.*;
import java.io.*;

/**
  * class CommandThread
  * Parameters: debugFlag
  * Default values: false
  */
public class CommandThread extends Thread {
	private static int sleepTime;
	private static boolean debugEnabled;
	private static LogFile logFile;

	CommandThread() {
		this.sleepTime = 60;
		debugEnabled = false;
		logFile = new LogFile("CommandThread.log");
	}
	
	CommandThread(boolean debugFlag) {
		this.sleepTime = 60;
		debugEnabled = debugFlag;
		logFile = new LogFile("CommandThread.log");
	}
	
	public void run() {
		logFile.log("CommandThread starting up...");
		logFile.log("sleepTime=" + Integer.toString(sleepTime) +
								" debugEnabled=" + debugEnabled);
		try {
			this.sleep(5000);
		}
		catch (InterruptedException e) {
				System.err.println("Sleep interrupted: " + e.getMessage());
		}
		logFile.log("After sleep", "run()");
		logFile.close();
	}
}