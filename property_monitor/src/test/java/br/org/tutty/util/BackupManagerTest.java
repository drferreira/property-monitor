package br.org.tutty.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.beans.PropertyChangeEvent;

import static org.mockito.Mockito.times;

/**
 * Created by drferreira on 10/10/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class BackupManagerTest {

    public static final String PROPERTY_NAME = "propertyName";
    public static final String VALUE = "value";

    @Mock
    private PropertyChangeEvent changeEvent;
    @Mock
    private PropertyChangeEvent changeEventAlternative;

    private BackupManager backupManager;

    @Before
    public void setUp(){
        Mockito.when(changeEvent.getPropertyName()).thenReturn(PROPERTY_NAME);
        Mockito.when(changeEvent.getOldValue()).thenReturn(VALUE);

        backupManager = new BackupManager();
    }

    @Test
    public void backupChangeEventSholdExtratFieldBackup(){
        FieldBackup fieldBackupResult = backupManager.backupChangeEvent(changeEvent);

        Mockito.verify(changeEvent, times(2)).getPropertyName();
        Mockito.verify(changeEvent).getOldValue();

        Assert.assertEquals(PROPERTY_NAME, fieldBackupResult.getName());
        Assert.assertEquals(VALUE, fieldBackupResult.getValue());
    }

    @Test
    public void backupChangeEventSholdStoreWhenDontExist(){
        FieldBackup fieldBackupResult = backupManager.backupChangeEvent(changeEvent);

        FieldBackup backupResult = backupManager.getBackup(changeEvent.getPropertyName());

        Assert.assertEquals(PROPERTY_NAME, fieldBackupResult.getName());
        Assert.assertEquals(VALUE, fieldBackupResult.getValue());
    }

    @Test
    public void backupChangeEventSholdStoreOnlyTheFirst(){
        Mockito.when(changeEventAlternative.getPropertyName()).thenReturn(PROPERTY_NAME);
        Mockito.when(changeEventAlternative.getOldValue()).thenReturn(VALUE+"_alternative");

        backupManager.backupChangeEvent(changeEvent);
        FieldBackup backupResult = backupManager.backupChangeEvent(changeEventAlternative);

        Assert.assertEquals(PROPERTY_NAME, backupResult.getName());
        Assert.assertEquals(VALUE, backupResult.getValue());

        backupResult = backupManager.getBackup(changeEvent.getPropertyName());

        Assert.assertEquals(PROPERTY_NAME, backupResult.getName());
        Assert.assertEquals(VALUE, backupResult.getValue());
    }

    @Test
    public void getBackupShouldReturnNullWhenDontExist(){
        Assert.assertNull(backupManager.getBackup(""));
    }

    @Test
    public void getBackupShouldReturnNullWhenDontExistWithSpecificName(){
        backupManager.backupChangeEvent(changeEvent);

        Assert.assertNull(backupManager.getBackup(PROPERTY_NAME+"Invalidation"));
    }

    @Test
    public void getBackupShouldReturnValueWhenExistWithSpecificName(){
        backupManager.backupChangeEvent(changeEvent);

        Assert.assertNotNull(backupManager.getBackup(PROPERTY_NAME));
    }

    @Test
    public void hasAnyChangedShouldReturnTrueWhenAnyBackupHaveFlagTrue(){
        backupManager.backupChangeEvent(changeEvent);
        backupManager.getBackup(PROPERTY_NAME).analyzeChangeValue(VALUE+"_alternative");

        Assert.assertTrue(backupManager.hasAnyChanged());
    }

    @Test
    public void hasAnyChangedShouldReturnFalseWhenNothingBackupHaveFlagTrue(){
        backupManager.backupChangeEvent(changeEvent);
        backupManager.getBackup(PROPERTY_NAME).analyzeChangeValue(VALUE);

        Assert.assertFalse(backupManager.hasAnyChanged());
    }
}
