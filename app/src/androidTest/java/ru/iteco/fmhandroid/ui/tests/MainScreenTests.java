package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainScreenTests extends BaseTest {


    @Test
    @DisplayName("Работоспособность ссылки Все новости")
    @Description("Тест-кейс 29. При нажатии на ссылку \"Все новости\" на главной странице осуществляется переход в раздел Новости, где размещен полный список новостей")
    public void shouldOpenAllNews(){
        AuthorizationSteps.AuthData();
        MainScreen.allNewsButton.perform(click());
        NewsScreen.newsListRecycler.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Разворачивание списка новостей")
    @Description("Тест-кейс 28. Список новостей разворачивается при нажатии стрелки напротив заголовка раздела на главной странице")
    public void shouldShowNewsOnMainPage(){
        AuthorizationSteps.AuthData();
        MainScreen.showHideNewsListButton.perform(click());
        MainScreen.showHideNewsListButton.perform(click());
        MainScreen.containerNewsListMainPageMatch.matches(isDisplayed());

    }

    @Test
    @DisplayName("Сворачивание списка новостей")
    @Description("Тест-кейс 27. Список новостей сворачивается при нажатии стрелки напротив заголовка раздела на главной странице")
    public void shouldHideNewsOnMainPage(){
        AuthorizationSteps.AuthData();
        MainScreen.showHideNewsListButton.perform(click());
        MainScreen.containerNewsListMainPageMatch.matches(not(isDisplayed()));
    }

}
