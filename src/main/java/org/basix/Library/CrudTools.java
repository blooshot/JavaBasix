package org.basix.Library;

public interface CrudTools {

    boolean create();
    String read(String objType);
    boolean delete(Integer id, Object objType);
}
