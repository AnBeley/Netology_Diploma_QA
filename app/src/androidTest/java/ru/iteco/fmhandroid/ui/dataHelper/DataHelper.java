package ru.iteco.fmhandroid.ui.dataHelper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class DataHelper {
    public static String title1 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title2 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title3 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title4 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title5 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title6 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);
    public static String title7 = "testTit-" + UUID.randomUUID().toString().substring(0, 3);


    public static String concreteTitle2 = "Заголовок2";
    public static String concreteTitle3 = "Заголовок3";


    public static String voidTitleOfNews = "";

    public static String description = "Массаж расслабляющий";
    public static String concreteDescription = "Расслабляющий массаж";
    public static String voidDescriptionOfNews = "";

    public static String voidDataNewsError = "Заполните пустые поля";


    public static String validLogin = "login2";
    public static String validPassword = "password2";


    public static String notValidLogin = "login";
    public static String notValidPassword = "password";
    public static String tryLaterError = "Что-то пошло не так. Попробуйте позднее.";
    public static String voidLoginPassError = "Логин и пароль не могут быть пустыми";
    public static String sqlLogin = "$username = 1' or '1' = '1";
    public static String sqlPassword = "$password = 1' or '1' = '1";


    public static String filterError ="Неверно указан период";

    public static String citationTitle = "“В хосписе не работают плохие люди” В.В. Миллионщикова\"";
    public static String citationText = "Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи.";

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;
            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static ViewInteraction wait(Matcher<View> matcher) {
        elementWaiting(matcher, 10000);
        return onView(matcher);
    }

    public static Matcher<View> elementWaiting(Matcher matcher, int millis) {
        onView(isRoot()).perform(waitForElement(matcher, millis));
        return null;
    }

    public static ViewAction waitForElement(final Matcher matcher, final long millis) {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = matcher;
                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        try {
                            if (viewMatcher.matches(child)) {
                                return;
                            }
                        } catch (NoMatchingViewException e) {}
                        uiController.loopMainThreadForAtLeast(50);
                    }
                }
                while (System.currentTimeMillis() < endTime);
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };

    }

}
