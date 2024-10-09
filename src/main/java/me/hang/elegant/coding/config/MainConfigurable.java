package me.hang.elegant.coding.config;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import me.hang.elegant.coding.bundle.I18nBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * @Author hang.wang
 * @Date 2024/10/9 11:11
 */
public class MainConfigurable implements Configurable {
    private final JPanel mainPanel;
    private final JComboBox<String> languageComboBox;
    private final JLabel languageLabel;

    public MainConfigurable() {
        String[] languages = {"English", "Simplified Chinese"};
        languageLabel = new JLabel(I18nBundle.getMessage("config.label.language"));

        languageComboBox = new JComboBox<>(languages);
        languageComboBox.setSelectedItem(loadSavedLanguage());
        languageComboBox.addActionListener(e -> updateLanguage());

        mainPanel = new JPanel(new BorderLayout(20, 10));
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        innerPanel.add(languageLabel);
        innerPanel.add(languageComboBox);
        mainPanel.add(innerPanel, BorderLayout.WEST);

        updateLanguage();
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return I18nBundle.getMessage("config.label.language");
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return !getSelectedLanguage().equals(loadSavedLanguage());
    }

    @Override
    public void apply() {
        saveLanguageSetting(getSelectedLanguage());
    }

    @Override
    public void reset() {
        String savedLanguage = loadSavedLanguage();
        languageComboBox.setSelectedItem(savedLanguage);
        updateLanguage();
    }

    private String getSelectedLanguage() {
        return (String) languageComboBox.getSelectedItem();
    }

    private void saveLanguageSetting(String language) {
        PropertiesComponent.getInstance().setValue("ECG-SelectedLanguage", language);
        Locale newLocale = "English".equals(language) ? Locale.ENGLISH : Locale.SIMPLIFIED_CHINESE;
        Locale.setDefault(newLocale);
    }

    private String loadSavedLanguage() {
        return PropertiesComponent.getInstance().getValue("ECG-SelectedLanguage", "English");
    }

    private void updateLanguage() {
        languageLabel.setText(I18nBundle.getMessage("config.label.language"));
        I18nBundle.reloadInstance();
    }
}
