package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;

import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.AboutAppScreen;
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainMenuNavigationSteps extends BaseTest {

    public static void MainMenuClick(){
        Allure.step("Переход в раздел Главная");
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.mainMenuButton.perform(click());
        MainScreen.containerNewsListMainPage.check(matches(isDisplayed()));

    }

    public static void NewsMenuClick(){
        Allure.step("Переход в раздел Новости");
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.newsMenuButton.perform(click());
        NewsScreen.newsListRecycler.check(matches(isDisplayed()));

    }

    public static void AboutAppMenuClick(){
        Allure.step("Переход в раздел О Приложении");
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.aboutAppMenuButton.perform(click());
        AboutAppScreen.termsOfUse.check(matches(isDisplayed()));

    }

    public static void CitationsMenuClick(){
        Allure.step("Переход в раздел Цитаты");
        MainScreen.citationsListButton.perform(click());
        CitationsScreen.citationsList.check(matches(isDisplayed()));

    }

}

