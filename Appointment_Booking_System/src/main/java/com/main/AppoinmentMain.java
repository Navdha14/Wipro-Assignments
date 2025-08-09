package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.model.AppointmentService;

public class AppoinmentMain {

    public static void main(String[] args) {
        // Load Spring XML configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the AppointmentService bean
        AppointmentService service = context.getBean("appointmentService", AppointmentService.class);

        String result = service.book("DOC101", "2025-04-10");
        System.out.println(result);
    }
}
