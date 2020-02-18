package main.java.repository;

import com.sun.tools.javac.util.List;

public interface Repository<T> {
    void insert(T obj,int db);
    T get(String query, int db);
    List<T> getAll(int db);
}
