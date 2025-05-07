import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.RUSSIA;

public class LocaleTest {
    @ParameterizedTest
    @EnumSource(Country.class)
    void testWithEnumSource_locale(Country a) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String res = localizationService.locale(a);
        if (a == RUSSIA) {
            Assertions.assertEquals("Добро пожаловать", res);
        } else {
            Assertions.assertEquals("Welcome", res);
        }
    }
}

