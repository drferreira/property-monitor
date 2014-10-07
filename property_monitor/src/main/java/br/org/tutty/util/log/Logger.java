package br.org.tutty.util.log;

import java.beans.PropertyChangeEvent;

import br.org.tutty.util.FieldBackup;

public class Logger {
	
    public static void logChangeVerification(PropertyChangeEvent evt, FieldBackup fieldBackup) {
        System.out.println("========== Property Monitor ==========");
        System.out.println("Name Field    = " + evt.getPropertyName());
        System.out.println("Default Value = " + fieldBackup.getValue());
        System.out.println("New Value = " + evt.getNewValue());
        System.out.println("Change verification Result = " + fieldBackup.hasChanged());
    }

}
