package common.service;

import java.util.function.Function;

public interface SerializationEngine<T> extends Function<T, String> {
}
