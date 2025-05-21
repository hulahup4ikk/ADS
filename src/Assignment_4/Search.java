package Assignment_4;

import java.util.List;

public interface Search<V> {
    List<V> getPath(V start, V end);
}
