package reflection;

import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.annotation.Controller;
import reflection.annotation.Repository;
import reflection.annotation.Service;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("reflection.examples");

        // TODO 클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다.
        Set<Class<?>> controllerClasses = reflections.getTypesAnnotatedWith(Controller.class);
        String controllerNames = controllerClasses.stream()
                .map(Class::getCanonicalName)
                .collect(Collectors.joining(", "));

        Set<Class<?>> serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
        String serviceNames = serviceClasses.stream()
                .map(Class::getCanonicalName)
                .collect(Collectors.joining(", "));

        Set<Class<?>> repoClasses = reflections.getTypesAnnotatedWith(Repository.class);
        String repoNames = repoClasses.stream()
                .map(Class::getCanonicalName)
                .collect(Collectors.joining(", "));

        log.info("@Controller 클래스: {}", controllerNames);
        log.info("@Service 클래스: {}", serviceNames);
        log.info("@Repository 클래스: {}", repoNames);
    }
}
