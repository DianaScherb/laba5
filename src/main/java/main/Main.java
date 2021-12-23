package main;

import java.io.IOException;

public class Main {
	public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException {
        /**
         * Если инициалзированть объект класса SomeBean при помощи new,
         * то в таком случа поля someField и otherField не будут инициализированы
         * и при вызове метода go мы получим NullPointerException.
         * Класс Injector осуществляет инициализацию этих полей на основе файла конфигурации
         */
        SomeBean sb = (new Injector<SomeBean>("src/main/config/properties.properties").inject(new SomeBean()));
        sb.foo();
    }

}
