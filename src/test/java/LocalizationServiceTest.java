import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.RUSSIA;

public class LocalizationServiceTest extends LocalizationServiceImpl {
    @Test
    void  locale_test(){
        Country country=RUSSIA;
        String expected="Добро пожаловать";
        String actual=locale(country);
        Assertions.assertEquals(expected,actual);


    }
}
