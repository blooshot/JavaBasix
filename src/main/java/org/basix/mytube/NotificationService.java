package org.basix.mytube;

public class NotificationService {
    public void notify(User user){
        System.out.println("Sending email to user..");
        System.out.println(user.getEmail());
        System.out.println("Done");
    }
}
