package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
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
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.LogOutSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuNavigationSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests extends BaseTest {

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
   @DisplayName("Отображение экрана авторизации при запуске приложения авторизованным пользователем")
   @Description("Тест-кейс 3. Приложение запускается при нажатии на иконку на рабочем столе мобильного устройства авторизованного пользователя")
    public void shouldAuthorizationPageIsDisplayedIfAuth() {
       AuthorizationSteps.AuthData();
       Espresso.pressBackUnconditionally();
       activityRule.launchActivity(null);
       DataHelper.wait(MainScreen.containerNewsListMainPageMatch).check(matches(isDisplayed()));
       MainScreen.containerNewsListMainPage.check(matches(isDisplayed()));

   }


    @Test
    @DisplayName("Отображение экрана авторизации при запуске приложения не авторизованным пользователем")
    @Description("Тест-кейс 1. Приложение запускается при нажатии на иконку на рабочем столе мобильного устройства не авторизованного пользователя")
    public void shouldAuthorizationPageIsDisplayedIfNotAuth() {
        LogOutSteps.LogOut();
        Espresso.pressBackUnconditionally();
        activityRule.launchActivity(null);
        DataHelper.wait(AuthorizationScreen.authorizationPageMatch);
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Отображение полей экрана авторизации")
    @Description("Тест-кейс 2. Полями ввода логина и пароля отображаются на странице Авторизации при запуске приложения не зарегистрированным пользователем")
    public void shouldLoginScreenDisplayed() {
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Пользователь авторизовывается в приложении, если вводит корректные значения в поле логин и пароль, открывается главная страница")
    @Description("Тест-кейс 5. Пользователь авторизовывается в приложении, если вводит корректные значения в поле логин и пароль ")
    public void shouldLoginInWithValidData() {
        AuthorizationSteps.AuthData();
        NewsScreen.newsListRecycler.check(matches(isDisplayed()));

    }


    @Test
    @DisplayName("Выход из приложения")
    @Description("Тест-кейс 25. При нажатии на кнопку выйти в личном кабинете пользователь выходит из своего аккаунта")
    public void shouldLogOut() {
       LogOutSteps.LogOut();
       AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
   }

    @Test
    @DisplayName("Появляется нотификация об ошибке при вводе не валидных значений в поле логин и пароль")
    @Description("Тест-кейс 7. Появляется нотификация об ошибке при вводе не валидных значений в поле логин и пароль в процессе авторизации")
    public void shouldNotLogInWithNotValidData() {
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.notValidLogin));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.notValidPassword));
        AuthorizationScreen.logInButton.perform(click());
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
        onView(withText(DataHelper.tryLaterError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }
    @Test
    @DisplayName("Появляется нотификация об ошибке, если поля логин и пароль остаивть пустыми")
    @Description("Тест-кейс 8. Появляется нотификация об ошибке, если поля логин и пароль оставить пустыми в процессе авторизации")
    public void shouldNotLogInWithVoidData() {
       AuthorizationScreen.logInButton.perform(click());
       AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
       onView(withText(DataHelper.voidLoginPassError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Появляется нотификация об ошибке, если поле пароль остаивть пустым и ввести валидный логин")
    @Description("Тест-кейс 9. Появляется нотификация об ошибке, если поле пароль оставить пустым и ввести валидный логин в процессе авторизации")
    public void shouldNotLogInWithVoidPass() {
       AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLogin));
        AuthorizationScreen.logInButton.perform(click());
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
        onView(withText(DataHelper.voidLoginPassError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Появляется нотификация об ошибке, если поле логин остаивть пустым и ввести валидный пароль")
    @Description("Тест-кейс 10. Появляется нотификация об ошибке, если поле логин оставить пустым и ввести валидный пароль в процессе авторизации")
    public void shouldNotLogInWithVoidLogin() {
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.validPassword));
        AuthorizationScreen.logInButton.perform(click());
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
        onView(withText(DataHelper.voidLoginPassError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Появляется нотификация об ошибке, если в поле логин и пароль вставить SQL-инъекцию")
    @Description("Тест-кейс 11. Появляется нотификация об ошибке при вводе SQL инъекции в поле логин и пароль в процессе авторизации")
    public void shouldNotLogInWithSql() {
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.sqlLogin));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.sqlPassword));
        AuthorizationScreen.logInButton.perform(click());
        AuthorizationScreen.authorizationPage.check(matches(isDisplayed()));
        onView(withText(DataHelper.tryLaterError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

      @Test
      @DisplayName("Кликабельность кнопки личного кабинета из любого раздела приложения, где есть кнопка главного меню")
      @Description("Тест-кейс 6. Кнопка личного кабинета кликабельна из люого раздела, где есть главное меню")

      public void logOutButtonIsClickable() {
          AuthorizationSteps.AuthData();
          MainScreen.authorizationButton.matches(isClickable());
          MainMenuNavigationSteps.NewsMenuClick();
          MainScreen.authorizationButton.matches(isClickable());
          MainMenuNavigationSteps.CitationsMenuClick();
          MainScreen.authorizationButton.matches(isClickable());
          MainMenuNavigationSteps.AboutAppMenuClick();
          MainScreen.menuButton.matches(not(isDisplayed()));
      }
}
