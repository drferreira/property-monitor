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

        System.out.println(source.sourceShouldFillTargetValues);
        System.out.println(target.targetShouldFillTargetValues);

        assertEquals(source.sourceShouldFillTargetValues, target.targetShouldFillTargetValues);
    }

    @Test
    public void shouldDontFillDistinctNames() throws IllegalAccessException, NoSuchFieldException {
        TargetDto target = new TargetDto();
        SourceDto source = new SourceDto();

        Equalizer.equalize(source, target);

        assertNotEquals(source.sourceShouldDontFillDistinctNames, target.targetShouldDontFillDistinctNames);
    }

    @Test
    public void shouldIgnoreFieldName() throws IllegalAccessException, NoSuchFieldException {
        TargetDto target = new TargetDto();
        SourceDto source = new SourceDto();

        Equalizer.equalize(source, target);

        assertNotEquals(source.shouldIgnoreFieldName, target.shouldIgnoreFieldName);
    }

    @Test
    public void shouldFillObjectWithTypeSpecific() throws IllegalAccessException, NoSuchFieldException {
        TargetDto target = new TargetDto();
        SourceDto source = new SourceDto();

        Equalizer.equalize(source, target);

        assertEquals(source.type, target.type);
        assertEquals(source.type.test, target.type.test);
    }

    @Test
    public void shouldFillInverseOrder() throws IllegalAccessException, NoSuchFieldException {
        TargetDto target = new TargetDto();
        SourceDto source = new SourceDto();

        Equalizer.equalize(target, source);

        System.out.println(source.sourceShouldFillTargetValues);
        System.out.println(target.targetShouldFillTargetValues);

        assertEquals(source.sourceShouldFillTargetValues, target.targetShouldFillTargetValues);
    }
}
