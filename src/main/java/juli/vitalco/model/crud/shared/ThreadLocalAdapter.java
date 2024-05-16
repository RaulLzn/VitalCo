package juli.vitalco.model.crud.shared;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ThreadLocalAdapter<T> extends TypeAdapter<ThreadLocal<T>> {

    @Override
    public void write(JsonWriter out, ThreadLocal<T> value) throws IOException {
        // No hacemos nada aquí, ya que no queremos serializar ThreadLocal
    }

    @Override
    public ThreadLocal<T> read(JsonReader in) throws IOException {
        // No hacemos nada aquí, ya que no queremos deserializar ThreadLocal
        return null;
    }
}
