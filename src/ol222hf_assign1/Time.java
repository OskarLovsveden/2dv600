/*
* Date: 2021-09-13.
* File Name: Time.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Represent a clock/time.
 * 
 * @version 1 13 Sept 2021
 * @author Oskar Lövsveden
 */
public class Time {
    private static final int SECONDS_IN_A_DAY = 86400;
    private static final int SECONDS_IN_AN_HOUR = 3600;
    private static final int MINUTES_IN_AN_HOUR = 60;
    private static final int SECONDS_IN_A_MINUTE = 60;

    private static final int SECONDS_IN_A_DAY_LIMIT = 86399;
    private static final int SECONDS_LIMIT = 59;
    private static final int MINUTES_LIMIT = 59;
    private static final int HOURS_LIMIT = 23;

    private int hours;
    private int minutes;
    private int seconds;

    /** Default class constructor. */
    public Time() {
        this(0, 0, 0);
    }

    /**
     * Class constructor that sets the time using hours, minutes and seconds.
     * 
     * @param hours   An int representing the amount of hours passed since midnight.
     * @param minutes An int representing the amount of minutes passed during the
     *                current hour.
     * @param seconds An int representing the amount of seconds passed during the
     *                current minute.
     */
    public Time(int hours, int minutes, int seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    /**
     * Class constructor that sets the time using seconds.
     * 
     * @param seconds An int representing the amount of seconds passed since
     *                midnight.
     */
    public Time(int seconds) {
        setClock(seconds);
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets the seconds of the time.
     * 
     * @param seconds An int representing the amount seconds passed during the
     *                current minute.
     * @throws IllegalArgumentException if seconds is less than 0 or larger than
     *                                  {@value #SECONDS_LIMIT}.
     */
    public void setSeconds(int seconds) throws IllegalArgumentException {
        if (seconds < 0 || seconds > SECONDS_LIMIT) {
            String msg = "Seconds can not be less than 0 or more than " + SECONDS_LIMIT + ". Value passed: " + seconds;
            throw new IllegalArgumentException(msg);
        }

        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets the minutes of the time.
     * 
     * @param minutes An int representing the amount of minutes passed during the
     *                current hour.
     * @throws IllegalArgumentException if minutes is less than 0 or larger than
     *                                  {@value #MINUTES_LIMIT}.
     */
    public void setMinutes(int minutes) throws IllegalArgumentException {
        if (minutes < 0 || minutes > MINUTES_LIMIT) {
            String msg = "Minutes can not be less than 0 or more than " + MINUTES_LIMIT + ". Value passed: " + minutes;
            throw new IllegalArgumentException(msg);
        }

        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    /**
     * Sets the hours of the time.
     * 
     * @param hours An int representing the amount of hours passed since midnight.
     * @throws IllegalArgumentException if hours is less than 0 or larger than
     *                                  {@value #HOURS_LIMIT}.
     */
    public void setHours(int hours) throws IllegalArgumentException {
        if (hours < 0 || hours > HOURS_LIMIT) {
            String msg = "Hours can not be less than 0 or more than " + HOURS_LIMIT + ". Value passed: " + hours;
            throw new IllegalArgumentException(msg);
        }

        this.hours = hours;
    }

    /**
     * The current time in seconds since midnight.
     * 
     * @return An int containing the current time since midnight, in seconds.
     */
    private int toSeconds() {
        return (this.hours * SECONDS_IN_AN_HOUR) + (this.minutes * SECONDS_IN_A_MINUTE) + this.seconds;
    }

    /**
     * Sets the time/clock.
     * 
     * @param seconds An int representing the amount of seconds that has passed
     *                since or is left until midnight.
     *                Positive values for time since midnight, and negative values
     *                for time until midnight.
     */
    public void setClock(int seconds) {
        if (seconds > SECONDS_IN_A_DAY_LIMIT) {
            setClock(seconds - SECONDS_IN_A_DAY);
        } else if (seconds < 0) {
            setClock(SECONDS_IN_A_DAY + seconds);
        } else {
            this.setHours(seconds / SECONDS_IN_AN_HOUR);
            this.setMinutes((seconds % SECONDS_IN_AN_HOUR) / MINUTES_IN_AN_HOUR);
            this.setSeconds(seconds % SECONDS_IN_A_MINUTE);
        }
    }

    /** Makes the time/clock tick 1 second forwards. */
    public void tick() {
        setClock(toSeconds() + 1);
    }

    /** Makes the time/clock tick 1 seconds backwards. */
    public void tickDown() {
        setClock(toSeconds() - 1);
    }

    /**
     * Creates a new Time object by adding two together.
     * 
     * @param time The Time object to be added.
     * @return A new Time object containing the sum of two Time objects.
     */
    public Time subtracTime(Time time) {
        int seconds = toSeconds() - time.toSeconds();
        return new Time(seconds);
    }

    /**
     * Creates a new time object by subtracting one from another.
     * 
     * @param time The Time object to be subtracted.
     * @return A new Time object containing the difference of two Time objects.
     */
    public Time addTime(Time time) {
        int seconds = toSeconds() + time.toSeconds();
        return new Time(seconds);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
}
