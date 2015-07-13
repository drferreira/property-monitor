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
        fillTarget(source, target);
    }

    public static void fillTarget(Object source, Object target) throws NoSuchFieldException, IllegalAccessException {
        List<Field> fieldsSource = fetchFields(source);
        List<Field> fieldsTarget = fetchFields(target);

        for (Field fieldTarget : fieldsTarget){
            for (Field fieldSource : fieldsSource){
                String nameSource = fieldSource.getAnnotation(Equalization.class).name();
                String nameTarget = fieldTarget.getAnnotation(Equalization.class).name();

                if (nameSource.equals(nameTarget)){
                    fillField(fieldSource, source, fieldTarget, target);
                }
            }
        }
    }

    public static List<Field> fetchFields(Object object){
        List<Field> commons = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Equalization.class)){
                commons.add(field);
            }
        }
        return commons;
    }

    public static void fillField(Field sourceField, Object source, Field targetField, Object target) throws IllegalAccessException, NoSuchFieldException {
            Object value = sourceField.get(source);
            targetField.setAccessible(true);
            targetField.set(target, value);
    }
}
