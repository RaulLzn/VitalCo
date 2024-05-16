package juli.vitalco.model.crud.shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import juli.vitalco.misEstructuras.Cola;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.misEstructuras.Pila;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileJsonAdapter<E> {
    private Object fileWriterLock;
    private static FileJsonAdapter instance;

    private final Gson gson;


    private FileJsonAdapter(Gson gson) {
        this.gson = gson;
        this.fileWriterLock = new Object();
    }

    public static <T> FileJsonAdapter<T> getInstance(Gson gson) {
        if (instance == null) {
            instance = new FileJsonAdapter<>(gson);
        }
        return instance;
    }

    public Gson getGsonWithCustomAdapters() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ThreadLocal.class, new ThreadLocalAdapter<>());
        return gsonBuilder.create();
    }


    public ListaDobleEnlazada<E> getObjects(String pathFile, Class<E[]> classOfT) {
        ListaDobleEnlazada<E> objList = new ListaDobleEnlazada<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objList.agregarAlFinal(obj);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objList;
    }

    public Boolean writeObjects(String pathFile, ListaDobleEnlazada<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }


    public Pila<E> getObjectsStack(String pathFile, Class<E[]> classOfT) {
        Pila<E> objStack = new Pila<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objStack.push(obj); // Agregar objetos al Pila
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objStack;
    }

    public Boolean writeObjectsStack(String pathFile, Pila<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

    public Cola<E> getObjectsQueue(String pathFile, Class<E[]> classOfT) {
        Cola<E> objQueue = new Cola<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objQueue.enqueue(obj); // Agregar objetos a la cola
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objQueue;
    }

    public Boolean writeObjectsQueue(String pathFile, Cola<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }
}
