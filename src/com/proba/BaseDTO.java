package com.proba;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class BaseDTO {
    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super
                .toString();
        /*StringBuilder sb = new StringBuilder();
        String s = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(x -> !Modifier.isFinal(x.getModifiers())
                        && !Modifier.isStatic(x.getModifiers())
                        && !Modifier.isTransient(x.getModifiers()))
                .map(
                        x -> {
                            try {
                                return x.getName() + ":" + getValue(x);
                            } catch (IllegalAccessException e) {
                                return "INVALID!";
                            }
                        }
                ).collect(Collectors.joining(", "));
        sb.append("[");
        sb.append(s);
        sb.append("]");

        return sb.toString();*/
    }

    protected abstract  Object getValue(Field field) throws IllegalAccessException;

}
