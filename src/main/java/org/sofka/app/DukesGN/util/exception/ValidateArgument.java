package org.sofka.app.DukesGN.util.exception;

import org.sofka.app.DukesGN.util.exception.exceptions.ExceptionArgumentEmpty;
import org.sofka.app.DukesGN.util.exception.exceptions.ExceptionArgumentNull;
import org.sofka.app.DukesGN.util.exception.exceptions.ExceptionNumberMax;
import org.sofka.app.DukesGN.util.exception.exceptions.ExceptionNumberNegative;

public class ValidateArgument {

    /**
     * Permite validar un campo vacio en un argumento
     *
     * @param argument
     * @param message
     */

    public static void validateStringEmpty(String argument, String message) {
        if (argument.isBlank()) {
            throw new ExceptionArgumentEmpty(message);
        }
    }

    /**
     * Permite validar si un campo es nulo
     *
     * @param argument
     * @param message
     */

    public static void validateStringNull(String argument, String message) {
        if (argument == null) {
            throw new ExceptionArgumentNull(message);
        }
    }

    /**
     * Permite validad si un campo es negativo
     *
     * @param number
     * @param message
     */

    public static void valiteNumberNegative(Number number, String message) {
        if (number.doubleValue() < 0.0) {
            throw new ExceptionNumberNegative(message);

        }
    }

    /**
     * Permite validar si un campo es moyor a 100
     *
     * @param number
     * @param message
     */
    public static void validateNumberMax(Number number, String message) {
        if (number.doubleValue() > 100.0) {
            throw new ExceptionNumberMax(message);
        }
    }


}
