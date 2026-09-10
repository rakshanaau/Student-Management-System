package org.anudip.sms.main;

import org.anudip.sms.controller.StudentController;

public class SMSApp {

    public static void main(String[] args) {

        StudentController controller =
                new StudentController();

        controller.start();
    }
}