package net.mrf.sandbox.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping(value = "/user")
public class NutshellUserController {

    /**
     * Saves the Nutshell update schedule for the Site Owner. Request body must be JSON
     * representation of the UpdateSchedule. For example:
     * 
     * <pre>
     * {
     *    hours: [8, 12, 16],
     *    days: [0, 1, 2, 3, 4, 5, 6]
     * }
     * </pre>
     * 
     * @param schedule
     *            JSON representation of the schedule
     * 
     * @return JSON representation of the schedule that was saved
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    @ResponseBody
    public UpdateSchedule saveUpdateSchedule(@RequestBody UpdateSchedule schedule) {
        // this example demonstrates unmarshalling (moderately) complex JSON
        // data into a model object
        return schedule;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    @ResponseBody
    public UpdateSchedule saveUpdateSchedule() {
        UpdateSchedule schedule = new UpdateSchedule();
        schedule.setDays(Arrays.asList(new Integer[]{0,1,4,5}));
        schedule.setHours(Arrays.asList(new Integer[]{8,12,16}));
        return schedule;
    }

}
