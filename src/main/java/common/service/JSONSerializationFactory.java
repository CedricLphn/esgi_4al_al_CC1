package common.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

public final class JSONSerializationFactory {
    private JSONSerializationFactory() {
        throw new AssertionError();
    }

    public static <T> SerializationEngine<T> withJSON(Class<T> tClass, TypeAdapter<T> typeAdapter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(tClass, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        return new JSONSerializationEngine<>(gson);
    }

}
