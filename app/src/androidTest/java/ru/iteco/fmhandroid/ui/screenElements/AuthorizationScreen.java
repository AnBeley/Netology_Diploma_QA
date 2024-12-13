package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {
    public static ViewInteraction authorizationPage = onView(withText("Авторизация"));
    public static ViewInteraction logInButton = onView(withId(R.id.enter_button));
    public static ViewInteraction loginInput = onView(allOf(withHint("Логин"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));
    public static ViewInteraction passwordInput = onView(allOf(withHint("Пароль"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));
    public static Matcher<View> authorizationPageMatch  =  (withText("Авторизация"));

}
