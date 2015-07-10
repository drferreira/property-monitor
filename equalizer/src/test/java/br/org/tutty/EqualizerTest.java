package br.org.tutty;

import br.org.tutty.auxiliary.SourceDto;
import br.org.tutty.auxiliary.TargetDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by drferreira on 10/07/15.
 */
public class EqualizerTest {

    @Test
    public void shouldFillTargetValues() throws IllegalAccessException, NoSuchFieldException {
        TargetDto target = new TargetDto();
        SourceDto source = new SourceDto();

        Equalizer.equalize(source, target);

        assertEquals(source.test, target.test);
        assertNotEquals(source.differentSource, target.differentTarget);
        assertEquals(source.test2, target.test2);
    }
}
