package cy.com.netu.cynotify.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * values in this table should correspond to records in table MESSAGE_CHANNEL
 *
 * @author christoforosl
 */
public enum EnumNotificationChannel {

    EMAIL(1),
    SMS(2);

    private static final Map<Integer, EnumNotificationChannel> TYPE_MAP = new HashMap<>();
    private final Integer value;

    static {
        for (EnumNotificationChannel type : EnumNotificationChannel.values()) {
            TYPE_MAP.put(type.value, type);
        }
    }

    EnumNotificationChannel(int i) {
        value = i;
    }

    public int intValue() {
        return value;
    }

    public static EnumNotificationChannel fromValue(Integer i) {
        if (i == null) {
            return null;
        }
        return TYPE_MAP.get(i);
    }
}
