package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTests extends BaseTest {


    private View decorView;

    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    @DisplayName("Открытие страницы настройки фильтрации в разделе Новости")
    @Description("Тест-кейс 42. При нажатии на кнопку Фильтр в разделе Новости, открывается страница фильтрации новостей")
    public void shouldFilterPageOpen() {
        NewsSteps.enterNewsMenu();
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterTitlePage.check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Невозможность фильтровать только по дате конца периода")
    @Description("Тест-кейс 51. Появляется нотификация об ошибке при попытке фильтрации только по дате начала периода")
    public void onlyStartPeriodFilterError() {
        NewsSteps.enterNewsMenu();
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDateStarts.perform(click());
        ControlPanelScreen.okButton.perform(click());
        NewsScreen.filterButton.perform(click());
        onView(withText(DataHelper.filterError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Невозможность фильтровать только по дате конца периода")
    @Description("Тест-кейс 52. Появляется нотификация об ошибке при попытке фильтрации только по дате конца периода")
    public void onlyEndPeriodFilterError() {
        NewsSteps.enterNewsMenu();
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonEnds.perform(click());
        ControlPanelScreen.okButton.perform(click());
        NewsScreen.filterButton.perform(click());
        onView(withText(DataHelper.filterError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }


}
