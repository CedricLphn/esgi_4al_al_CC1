package shopping.domain;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class UserTypeAdapter extends TypeAdapter<User> {
    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("lastname").value(user.getLastname());
        jsonWriter.name("firstname").value(user.getFirstname());
        jsonWriter.name("age").value(user.getAge());
        jsonWriter.name("card").value(user.getCardNumber());

        jsonWriter.endObject();
    }

    @Override
    public User read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
