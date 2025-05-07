import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class MessageSenderTests {
    @Test
    void message_service_test() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("Moscow", RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> testmap = new HashMap<String, String>();
        testmap.put("IP_ADDRESS_HEADER", "one");

        String result = messageSender.send(testmap);

        Assertions.assertEquals("Добро пожаловать", result);
    }

    @Test
    void message_service_test_english() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("New York", USA, " 10th Avenue", 32));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(USA))
                .thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> testmap = new HashMap<String, String>();
        testmap.put("IP_ADDRESS_HEADER", "one");

        String result = messageSender.send(testmap);

        Assertions.assertEquals("Welcome", result);
    }
}
