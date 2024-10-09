package me.hang.elegant.coding.bundle;

import com.intellij.AbstractBundle;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @Author hang.wang
 * @Date 2024/10/9 13:44
 */
public class I18nBundle extends AbstractBundle {
    private static final String BUNDLE = "messages";
    private static ResourceBundle INSTANCE = getInstance();

    public static ResourceBundle getInstance() {
        return ResourceBundle.getBundle(BUNDLE, getLocale());
    }

    public static void reloadInstance() {
        INSTANCE = getInstance();
    }

    public static Locale getLocale() {
        if (!Objects.equals(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) && !Objects.equals(Locale.getDefault().getLanguage(), Locale.CHINESE.getLanguage())) {
            return Locale.ENGLISH;
        } else {
            return Locale.getDefault();
        }
    }

    public static String getMessage(String key) {
        return message(key);
    }

    private I18nBundle() {
        super(BUNDLE);
    }

    public static String message(String key, Object... params) {
        return String.format(INSTANCE.getString(key), params);
    }
}
