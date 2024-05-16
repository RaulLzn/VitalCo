package juli.vitalco.model.crud.shared;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static Gson getGson() {
        ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                // Excluir campos problemáticos por nombre
                return fieldAttributes.getName().equals("threadLocalHashCode") ||
                        fieldAttributes.getDeclaringClass().equals(ThreadLocal.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };

        return new GsonBuilder()
                .setExclusionStrategies(exclusionStrategy)
                .create();
    }
}
