package com.trilogyed.taskersecurity.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RefreshScope
public class TaskerSecurityController {

    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public String createTask(Principal principal) {
        return "You " + principal.getName() + "can create task here.";
    }

    @RequestMapping(value = "/viewTask", method = RequestMethod.GET)
    public String getTask(Principal principal) {
        return "Here are the private tasks " + principal.getName() + ".";
    }

    @RequestMapping(value = "/changeTask", method = RequestMethod.PUT)
    public String updateTask(@RequestBody Principal principal){
        return "Thank you - " + principal.getName() + " task has been updated.";
    }

    @RequestMapping(value = "/getTask/{id}", method = RequestMethod.DELETE)
    public String deletePrivateEvent(Principal principal, @PathVariable int id){
        return "You - " + principal.getName() + "have deleted the tasks " + "with id " + id + ".";
    }
}
