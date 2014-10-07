package br.org.tutty.util;

import java.beans.PropertyChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BackupManager implements Serializable {

	private static final long serialVersionUID = -1764895899629981489L;

	private List<FieldBackup> fieldBackups;

	public BackupManager() {
		fieldBackups = new ArrayList<FieldBackup>();
	}

	public FieldBackup backupChangeEvent(PropertyChangeEvent changeEvent) {
		FieldBackup fieldBackup = extract(changeEvent);
		storeBackup(fieldBackup);

		return getBackup(changeEvent.getPropertyName());
	}

	private void storeBackup(FieldBackup fieldBackup) {
		if (!isBackupWasMade(fieldBackup)) {
			fieldBackups.add(fieldBackup);
		}
	}

	private FieldBackup extract(PropertyChangeEvent changeEvent) {
		String fieldName = changeEvent.getPropertyName();
		Object oldValue = changeEvent.getOldValue();

		return new FieldBackup(fieldName, oldValue);
	}

	private Boolean isBackupWasMade(FieldBackup fieldBackup) {
		if (getBackup(fieldBackup.getName()) != null) {
			return Boolean.TRUE;

		} else {
			return Boolean.FALSE;
		}
	}

	public FieldBackup getBackup(String fieldName) {
		for (FieldBackup fieldBackup : fieldBackups) {
			if (fieldBackup.getName().equals(fieldName)) {
				return fieldBackup;
			}
		}

		return null;
	}

	public Boolean hasAnyChanged() {
		Boolean changeFormFlag = Boolean.FALSE;

		for (FieldBackup fieldBackup : fieldBackups) {
			if (fieldBackup.hasChanged()) {
				changeFormFlag = Boolean.TRUE;
			}
		}
		return changeFormFlag;
	}

}
