package edu.unisabana.dyas.tdd.registry;

/**
 * Enum que representa los posibles resultados de un proceso de registro. Cada
 * valor indica un estado específico del registro.
 */
public enum RegisterResult {
    /**
     * El registro no es válido debido a que la persona está muerta.
     */
    DEAD,
    /**
     * El registro no es válido debido a que la persona es menor de edad.
     */
    UNDERAGE,
    /**
     * El registro no es válido debido a una edad no válida.
     */
    INVALID_AGE,
    /**
     * El registro es válido.
     */
    VALID,
    /**
     * El registro no es válido porque la persona ya está registrada.
     */
    DUPLICATED;
}
