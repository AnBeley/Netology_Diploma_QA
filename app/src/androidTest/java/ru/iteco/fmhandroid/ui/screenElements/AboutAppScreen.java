package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutAppScreen {
    public static ViewInteraction termsOfUse = onView(withText("Пользовательское соглашение:"));
    public static ViewInteraction privacyPolicy = onView(withText("Политика конфиденциальности:"));
    public static ViewInteraction privacyPolicyLink = onView(withText("https://vhospice.org/#/privacy-policy"));
    public static ViewInteraction termsOfUseLink = onView(withText("https://vhospice.org/#/terms-of-use"));
    public static ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
}