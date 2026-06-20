package dao;
import java.util.ArrayList;
public interface CRUDInterface<T> {
    boolean insertar(T objeto);
    boolean actualizar(T objeto);
    ArrayList<T> listarTodos();
}