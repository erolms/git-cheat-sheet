/*
 * MonitorAgent (c) 2000  Erol Zavidic
 * All rights reserverd.
 *
 */

import java.lang.*;
import java.io.*;

public class MonitorAgent {
/**
  * class MonitorAgent
  * @author Erol Zavidic <ezavidic@hotmail.com>
  * @version 1.0.0
  * @parameters none
  * Purpose: Process command line arguments and startup running threads
  */

	public static String copyright = new String("(c) 2014 Erol Zavidic");
	public static String version = new String("1.0");

	public static void main(String[] args) {
		System.out.println("MonitorAgent v" + version.toString());
		System.out.println(copyright.toString());
		System.out.println("");
		System.out.println("Starting up... please wait.");
		
		CommandThread cmdThr = new CommandThread(false);
		cmdThr.setName("MonitorAgentCMD");
		cmdThr.start();
	}
}
