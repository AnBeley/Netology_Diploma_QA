package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;

public class MainScreen {
    public static ViewInteraction logOutButton = onView(withText("Выйти"));
    public static ViewInteraction mainMenuButton = onView(withText("Главная"));
    public static ViewInteraction newsMenuButton = onView(withText("Новости"));
    public static ViewInteraction aboutAppMenuButton = onView(withText("О приложении"));
    public static ViewInteraction citationsListButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction allNewsButton = onView(DataHelper.withIndex(withId(R.id.all_news_text_view), 0));
    public static ViewInteraction containerNewsListMainPage = onView(withId(R.id.container_list_news_include_on_fragment_main));
    public static ViewInteraction showHideNewsListButton = onView(withId(R.id.expand_material_button));

    public static Matcher<View> menuButton = withId(R.id.enter_button);
    public static Matcher<View> authorizationButton = withId(R.id.authorization_image_button);
    public static Matcher<View> containerNewsListMainPageMatch = withId(R.id.container_list_news_include_on_fragment_main);

}

