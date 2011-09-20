package net.mrf.sandbox.springmvc;

import java.util.Collection;

/**
 * The schedule on which updates are generated for a Nutshell Mail user. The schedule is
 * expressed in terms of local time based on the user's time zone.
 * 
 * @author mfremont
 * 
 */
public class UpdateSchedule {
    protected Collection<Integer> days;
    protected Collection<Integer> hours;

    /**
     * Returns the days of the week for which updates will be generated. This is
     * represented by a sequence of ordinal integers, each corresponding to a day of the
     * week where 0=Sunday, 1=Monday, ...
     */
    public Collection<Integer> getDays() {
        return days;
    }

    /**
     * Set the days of the week for which updates will be generated.
     */
    public void setDays(Collection<Integer> days) {
        this.days = days;
    }

    /**
     * Returns the hours of the day for which updates will be generated. This is
     * represented by a sequence of integers, each an hour of the day in the range 0-23.
     */
    public Collection<Integer> getHours() {
        return hours;
    }

    /**
     * Set the hours of the day for which updates will be generated.
     */
    public void setHours(Collection<Integer> hours) {
        this.hours = hours;
    }
}