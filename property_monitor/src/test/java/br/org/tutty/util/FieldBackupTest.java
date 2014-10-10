package br.org.tutty.util;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by drferreira on 10/10/14.
 */
public class FieldBackupTest {

    @Test
    public void analyzeChangeValueSetFlagTrueWhenDontEqualsObjects() throws Exception {
        Object oldValue = new Integer(123);
        Object newValue = new Integer(1234);;
        String fieldName = "fieldName";

        FieldBackup fieldBackup = new FieldBackup(fieldName, oldValue);

        fieldBackup.analyzeChangeValue(newValue);

        assertTrue(fieldBackup.hasChanged());
    }

    @Test
    public void analyzeChangeValueSetFlagTrueWhenDontEqualsStrings() throws Exception {
        String oldValue = "oldValue";
        String newValue = "newValue";
        String fieldName = "fieldName";

        FieldBackup fieldBackup = new FieldBackup(fieldName, oldValue);

        fieldBackup.analyzeChangeValue(newValue);

        assertTrue(fieldBackup.hasChanged());
    }

    @Test
    public void analyzeChangeValueSetFlagFalseWhenEqualsObjects() throws Exception {
        Object oldValue = new Integer(123);
        Object newValue = new Integer(123);;
        String fieldName = "fieldName";

        FieldBackup fieldBackup = new FieldBackup(fieldName, oldValue);

        fieldBackup.analyzeChangeValue(newValue);

        assertFalse(fieldBackup.hasChanged());
    }

    @Test
    public void analyzeChangeValueSetFlagFalseWhenEqualsStrings() throws Exception {
        String oldValue = "value";
        String newValue = "value";
        String fieldName = "fieldName";

        FieldBackup fieldBackup = new FieldBackup(fieldName, oldValue);

        fieldBackup.analyzeChangeValue(newValue);

        assertFalse(fieldBackup.hasChanged());
    }
}
