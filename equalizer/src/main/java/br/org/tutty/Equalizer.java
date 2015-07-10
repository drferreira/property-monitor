package br.org.tutty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by drferreira on 10/07/15.
 */
public class Equalizer {

    public static void equalize(Object source, Object target) throws IllegalAccessException, NoSuchFieldException {
        List<Field> sourceFields = fetchAllFields(source);
        List<Field> targetFields = fetchAllFields(target);

        List<Field> commonFields = fetchCommonFieldsBetween(sourceFields, targetFields);
        fill(commonFields, source, target);
    }

    public static List<Field> fetchAllFields(Object object){
        return Arrays.asList(object.getClass().getDeclaredFields());
    }

    public static List<Field> fetchCommonFieldsBetween(List<Field> sourceFields, List<Field> targetFields){
        List<Field> commons = new ArrayList<>();

        for (Field fieldTarget : targetFields){
            for (Field fieldSource : sourceFields){
                if(fieldSource.getName().equals(fieldTarget.getName())){
                    commons.add(fieldSource);
                }
            }
        }
        return commons;
    }

    public static void fill(List<Field> fields, Object source, Object target) throws IllegalAccessException, NoSuchFieldException {
        for (Field field : fields){
            Object value = field.get(source);
            field.setAccessible(true);
            Field targetField = target.getClass().getField(field.getName());
            targetField.set(target, value);
        }
    }
}
