package common.service;

import com.google.gson.Gson;

import java.util.Objects;

public class JSONSerializationEngine<T> implements SerializationEngine<T> {

    private final Gson gson;

    public JSONSerializationEngine(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String apply(T t) {
        Objects.requireNonNull(t);
        return gson.toJson(t);
    }
}
