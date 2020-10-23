package prueba.omar.gestortareas.utils;

import org.springframework.beans.BeanUtils;
import prueba.omar.gestortareas.domain.Task;

/**
 * Util class including methods to
 */
public class CopyProperties {

    public static void copyTaskProperties(Task src, Task dst){
        BeanUtils.copyProperties(src, dst, "id", "creationDate");
    }
}
