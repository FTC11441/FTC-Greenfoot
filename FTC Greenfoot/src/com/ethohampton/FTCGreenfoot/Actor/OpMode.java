package com.ethohampton.FTCGreenfoot.Actor;

import java.util.concurrent.TimeUnit;

public abstract class OpMode {
	  /**
	   * Gamepad 1
	   */
	  public Gamepad gamepad1 = null;   // will be set in OpModeManager.runActiveOpMode

	  /**
	   * Gamepad 2
	   */
	  public Gamepad gamepad2 = null;   // will be set in OpModeManager.runActiveOpMode

	  /**
	   * number of seconds this op mode has been running, this is
	   * updated before every call to loop.
	   */
	  public double time = 0.0;

	  // internal time tracking
	  private long startTime = 0; // in nanoseconds

	  /**
	   * OpMode constructor
	   * <p>
	   * The op mode name should be unique. It will be the name displayed on the driver station. If
	   * multiple op modes have the same name, only one will be available.
	   */
	  public OpMode() {
	    startTime = System.nanoTime();
	  }

	  /**
	   * User defined init method
	   * <p>
	   * This method will be called once when the INIT button is pressed.
	   */
	  abstract public void init();

	  /**
	   * User defined init_loop method
	   * <p>
	   * This method will be called repeatedly when the INIT button is pressed.
	   * This method is optional. By default this method takes no action.
	   */
	  public void init_loop() {};

	  /**
	   * User defined start method.
	   * <p>
	   * This method will be called once when the PLAY button is first pressed.
	   * This method is optional. By default this method takes not action.
	   * Example usage: Starting another thread.
	   *
	   */
	  public void start() {};

	  /**
	   * User defined loop method
	   * <p>
	   * This method will be called repeatedly in a loop while this op mode is running
	   */
	  abstract public void loop();

	  /**
	   * User defined stop method
	   * <p>
	   * This method will be called when this op mode is first disabled
	   *
	   * The stop method is optional. By default this method takes no action.
	   */
	  public void stop() {};

	  /**
	   * Get the number of seconds this op mode has been running
	   * <p>
	   * This method has sub millisecond accuracy.
	   * @return number of seconds this op mode has been running
	   */
	  public double getRuntime() {
	    final double NANOSECONDS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
	    return (System.nanoTime() - startTime) / NANOSECONDS_PER_SECOND;
	  }

	  /**
	   * Reset the start time to zero.
	   */
	  public void resetStartTime() {
	    startTime = System.nanoTime();
	  }
}
