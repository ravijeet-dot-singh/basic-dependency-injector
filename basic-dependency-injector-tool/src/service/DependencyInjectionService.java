package service;

import enums.Scope;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DependencyInjectionService {

    private final Map<String, Object> objectContextMap;
    private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public DependencyInjectionService(Map<String, Object> objectContextMap) {
        this.objectContextMap = objectContextMap;
    }

    public Object getObject(String className, Scope scope) {

        try {
            Class requiredClass = Class.forName(className, false, this.getClass().getClassLoader());

            if (Scope.SINGLETON.equals(scope)) {
                if (objectContextMap.containsKey(className)) {
                    return objectContextMap.get(className);
                } else {
                    Constructor<?>[] constructors = requiredClass.getConstructors();
                    Object object = new Object();
                    for (Constructor constructor : constructors) {
                        logger.info(String.format("getObject | For class = %s, constructor = %s", className, constructor));
                        Class<?>[] parameterTypes = constructor.getParameterTypes();

                        for (Class<?> parameterType : parameterTypes) {

                            if (!parameterType.toString().startsWith("java")) {
                                //TODO
                            }

                        }
                        object = constructor.newInstance();
                        break;
                    }
                    logger.info(String.format("getObject | Object created with hash code = %s for class = %s", object.hashCode(), className));
                    objectContextMap.put(className, object);
                    return object;
                }
            } else {

            }
        } catch (ClassNotFoundException classNotFoundException) {
            logger.log(Level.WARNING, String.format("Class name = %s does not exist in the application", className));
            return null;
        } catch (Exception exception) {
            logger.log(Level.WARNING, String.format("Exception occurred, message = %s", exception.getMessage()));
        }
        return null;
    }

    private void injectDependenciesAndCreateObject(Class<?> clazz) {

    }
}
