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
import ru.iteco.fmhandroid.ui.screenElements.AboutAppScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.CitationsListSteps;
import ru.iteco.fmhandroid.ui.steps.EnterMenuButtonSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuNavigationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MenuTests extends BaseTest {

    @Test
    @DisplayName("Отображение выпадающего списка разделов приложения")
    @Description("Тест-кейс 19. При нажатии на иконку \"бургер\" появляется выпадающий список из названий разделов приложения")
    public void shouldMainMenuListDisplays(){
        AuthorizationSteps.AuthData();
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.mainMenuButton.check(matches(isDisplayed()));
        MainScreen.newsMenuButton.check(matches(isDisplayed()));
        MainScreen.aboutAppMenuButton.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Переход в раздел новости")
    @Description("Тест-кейс 22. При нажатии на раздел Новости пользователь переходит в этот раздел из любого раздела приложения, где есть Главное меню")
    public void shouldNewsOpen(){
        NewsSteps.enterNewsMenu();
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.MainMenuClick();
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.MainMenuClick();
        MainMenuNavigationSteps.AboutAppMenuClick();
        MainScreen.menuButton.matches(not(isDisplayed()));

    }
    @Test
    @DisplayName("Переход в раздел О приложении")
    @Description("Тест-кейс 21. При нажатии на раздел О приложении пользователь переходит в этот раздел из любого раздела приложения, где есть Главное меню")
    public void shouldAboutAppOpen(){
        AuthorizationSteps.AuthData();
        MainMenuNavigationSteps.AboutAppMenuClick();
        MainScreen.menuButton.matches(not(isDisplayed()));
        AboutAppScreen.backButton.perform(click());
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.AboutAppMenuClick();
        AboutAppScreen.backButton.perform(click());
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.AboutAppMenuClick();// Баг репорт
    }

    @Test
    @DisplayName("Переход в раздел Главная")
    @Description("Тест-кейс 20. При нажатии на раздел Главная  пользователь переходит в этот раздел из любого раздела приложения, где есть Главное меню")
    public void shouldMainOpen(){
        AuthorizationSteps.AuthData();
        MainMenuNavigationSteps.MainMenuClick();//Баг репорт
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.MainMenuClick();
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.MainMenuClick();
        MainMenuNavigationSteps.AboutAppMenuClick();
        MainScreen.menuButton.matches(not(isDisplayed()));
    }

    @Test
    @DisplayName("Переход в раздел Цитаты")
    @Description("Тест-кейс 24. При нажатии на кнопку бабочка пользователь переходит из любого раздела приложения (где есть кнопка бабочка) на страницу со списком цитат ")
    public void shouldCitationsOpen(){
        CitationsListSteps.enterCitationsList();
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.NewsMenuClick();
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.MainMenuClick();
        MainMenuNavigationSteps.CitationsMenuClick();
        MainMenuNavigationSteps.AboutAppMenuClick();
        MainScreen.citationsListButton.check(matches(not(isDisplayed())));
    }

}
