package fr.leprohon.esgi.al4.al.kernel.service;

import java.util.function.Function;

public interface SerializationEngine<T> extends Function<T, String> {
}
