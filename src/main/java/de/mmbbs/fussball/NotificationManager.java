package de.mmbbs.fussball;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class NotificationManager {

    public static void notificationSuccessAtSaving(String whatIsSuccessing) {
        String text = String.format("%s Hinzugefügt!", whatIsSuccessing);
        Notification notification = Notification
                .show(text);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    public static void notificationFailureAtSaving(){
        Notification notification = Notification
                .show("Fehler beim Speichern!");
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
}
