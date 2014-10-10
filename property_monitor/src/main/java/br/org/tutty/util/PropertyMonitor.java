package br.org.tutty.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import br.org.tutty.util.log.Logger;

/**
 * Created by drferreira on 23/09/14.
 */
public class PropertyMonitor implements PropertyChangeListener, Serializable {
	private static final long serialVersionUID = -4337997241956326414L;

	private PropertyChangeSupport propertyChangeSupport;

    private Object entity;

    private BackupManager backupManager;

	public PropertyMonitor(Object entity) {
		this.entity = entity;
		backupManager = new BackupManager();
		propertyChangeSupport = new PropertyChangeSupport(this);
		propertyChangeSupport.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		FieldBackup fieldBackup = backupManager.backupChangeEvent(evt);
		fieldBackup.analyzeChangeValue(evt.getNewValue());

		Logger.logChangeVerification(evt, fieldBackup);
	}

	public Boolean hasChanged() {
		return backupManager.hasAnyChanged();
	}
}
