package common.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

public final class SerializationFactory {
    private SerializationFactory() {
        throw new AssertionError();
    }

    public static <T> SerializationEngine<T> toJSON(Class<T> tClass, TypeAdapter<T> typeAdapter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(tClass, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        return new JSONSerializationEngine<>(gson);
    }

    public static <T> T fromJSON(String jsonObject, Class<T> tClass, TypeAdapter<T> typeAdapter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(tClass, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        return (T)gson.fromJson(jsonObject, tClass);
    }

}
