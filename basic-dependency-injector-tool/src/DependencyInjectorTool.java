import entity.User;
import enums.Scope;
import repo.UserRepository;
import service.DependencyInjectionService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DependencyInjectorTool {

    private static final Logger logger = Logger.getLogger("DependencyInjectorTool");
    private static Map<String, Object> objectMap = new HashMap<>();

    public static void main(String[] args) {

        DependencyInjectionService dependencyInjectionService = new DependencyInjectionService(objectMap);

        UserRepository userRepository = (UserRepository) dependencyInjectionService.getObject("repo.UserRepository", Scope.SINGLETON);
        logger.info(String.format("main | User repository hash code = %s", userRepository.hashCode()));

        userRepository = (UserRepository) dependencyInjectionService.getObject("repo.UserRepository", Scope.SINGLETON);
        logger.info(String.format("main | User repository hash code second time = %s", userRepository.hashCode()));

        User user = userRepository.findByName("a");
        logger.info(String.format("main | Fetched user's name = %s", user.getName()));
    }
}
