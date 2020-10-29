package com.ryanbester.packstudio.gui.preloader;

import java.awt.Image;
import java.lang.reflect.Method;
import javax.swing.ImageIcon;

public class MacNatives {
    public static void prepareMacApp() {
        Object application = getApplication();
        if (application != null) {
            setDockIconImage(application, new ImageIcon(MacNatives.class.getResource("/assets/icon256.png")).getImage());
        }
    }

    public static Object getApplication() {
        try {
            Class<?> clazz = Class.forName("com.apple.eawt.Application");
            Method getApplicationMethod = clazz.getMethod("getApplication");
            return getApplicationMethod.invoke(clazz);
        } catch (Exception ex) {
            // Ignore exceptions if PackStudio isn't running on MacOS.
        }

        return null;
    }

    public static void setDockIconImage(Object application, Image image) {
        try {
            Method setDockIconImage = application.getClass().getMethod("setDockIconImage", java.awt.Image.class);
            setDockIconImage.invoke(application, image);
        } catch (Exception ex) {
            // Ignore exceptions if PackStudio isn't running on MacOS.
        }
    }
}
