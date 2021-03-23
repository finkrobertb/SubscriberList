package com.tts.subscriberlist.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Respond to web requests
public class SubscriberController
{
    @Autowired // Tell spring boot to make one of these automatically and stuff it in all
               // SubscriberController objects
    private SubscriberRepository subscriberRepository;

    // This specifies that an HTTP (web) Get request to the path "/" should invoke
    // this function.
    @GetMapping(value = "/")
    public String index(Subscriber subscriber)
    {
        // Autofill form
        subscriber.setFirstName("Robert");
        subscriber.setLastName("Smith");
        subscriber.setUserName("rabbit");

        // This is the method we want to call when the main web page is visited.
        return "subscriber/index"; // This is the location of Thymeleaf template we are going to create (ending
                                   // .html not necessary)

    }

    @PostMapping(value = "/")
    public String addNewSubscriber(Subscriber subscriber, Model model)
    {
        subscriberRepository.save(new Subscriber(subscriber.getFirstName(), subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
        
        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());
        
        return "subscriber/result";

    }
}
