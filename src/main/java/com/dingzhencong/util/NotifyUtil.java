package com.dingzhencong.util;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.ui.MessageType;

public class NotifyUtil {
    private static NotificationGroup notificationGroup = new NotificationGroup("MarkBook", NotificationDisplayType.BALLOON, true);

    public static void notifyInfo(String message) {
        Notification notification = notificationGroup.createNotification(message, MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
    public static void notifyWarning(String message) {
        Notification notification = notificationGroup.createNotification(message, MessageType.WARNING);
        Notifications.Bus.notify(notification);
    }
    public static void notifyError(String message) {
        Notification notification = notificationGroup.createNotification(message, MessageType.ERROR);
        Notifications.Bus.notify(notification);
    }
}
