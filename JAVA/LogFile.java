/*
 * MonitorAgent (c) 2000  Erol Zavidic
 * All rights reserverd.
 *
 */

/**
 * LogFile.java
 * version 1.0.0
 */

import java.lang.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
  * class LogFile
  * Parameters: fileName
  * Default: none
  * Purpose: Manage log files
  */
public class LogFile {
	private FileOutputStream logFile;
	private OutputStreamWriter logStream;
	private boolean logOpen;
	
	LogFile(String fileName) {
		try {
			logFile = new FileOutputStream(fileName, true);
			logStream = new OutputStreamWriter(logFile);
		}
		catch (FileNotFoundException e) {
			System.err.println("Could not open logfile: " + e.getMessage());
			logOpen = false;
		}
		logOpen = true;
	}
	
	public void log(String str) {
		String msg;
		Date date = new Date();
		SimpleDateFormat dateFmt;
		
		if (logOpen = true) {
			try {
				dateFmt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				msg = new String(dateFmt.format(date));
				msg = msg + " " + str.toString() + "\n";
				logStream.write(msg, 0, msg.length());
			}
			catch (IOException e) {
				System.err.println("Can not write to log file.");
			}
		}
	}
	
	public void log(String str, String prefix) {
		String msg;
		Date date = new Date();
		SimpleDateFormat dateFmt;
		
		if (logOpen = true) {
			try {
				dateFmt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				msg = new String(dateFmt.format(date));
				msg = msg + " " + prefix.toString() + ": " + str.toString() + "\n";
				logStream.write(msg, 0, msg.length());
			}
			catch (IOException e) {
				System.err.println("Can not write to log file.");
			}
		}
	}
	
	public void close() {
		try {
			logStream.close();
			logFile.close();
		}
		catch (IOException e) {
			System.err.println("Can not close log file.");
		}
	}
}