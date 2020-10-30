package com.ryanbester.packstudio.gui.preloader;

import com.ryanbester.packstudio.gui.aboutdialog.AboutDialogController;
import java.awt.Image;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.swing.ImageIcon;

public class MacNatives {
    public static void prepareMacApp() {
        Object application = getApplication();
        if (application != null) {
            setDockIconImage(application, new ImageIcon(MacNatives.class.getResource("/assets/icon256.png")).getImage());
            registerAboutHandler(application);
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

    public static void registerAboutHandler(Object application) {
        try {
            Class<?> aboutHandler = Class.forName("com.apple.eawt.AboutHandler");

            Object aboutHandlerInst = Proxy.newProxyInstance(aboutHandler.getClassLoader(),
                new Class<?>[]{aboutHandler}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                        if (method.getName().equals("handleAbout")) {
                            AboutDialogController.showAboutDialog();
                            return true;
                        }
                        return -1;
                    }
                });
            Method setAboutHandler = application.getClass().getMethod("setAboutHandler", aboutHandler);
            setAboutHandler.invoke(application, aboutHandlerInst);
        } catch (Exception ex) {
            // Ignore exceptions if PackStudio isn't running on MacOS.
        }
    }
}
