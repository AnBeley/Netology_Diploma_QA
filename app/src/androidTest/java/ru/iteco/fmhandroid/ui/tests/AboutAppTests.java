package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screenElements.AboutAppScreen;
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuNavigationSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutAppTests extends BaseTest {

    @Test
    @DisplayName("Отображение содержания страницы О Приложении")
    @Description("Тест-кейс 23. При нажатии в главном меню на раздел О приложении пользователь переходит на страницу О Приложении, где размещены ссылки на Пользовательское соглашение и Политику конфиденциальности")
    public void shouldAboutAppDisplayed (){
        AboutAppSteps.enterAboutMenu();
        AboutAppScreen.privacyPolicy.check(matches(isDisplayed()));
        AboutAppScreen.termsOfUse.check(matches(isDisplayed()));
   }

    @Test
    @DisplayName("Ссылка на политику конфиденциальности кликабельна")
    @Description("Тест-кейс 15. Ссылка, ведущая на страницу с  текстом Политики конфденциальности  \"https://vhospice.org/#/privacy-policy\",  кликабельна в разделе О приложении")
    public void shouldPrivacyPolicyIsClickable (){
        AboutAppSteps.enterAboutMenu();
        AboutAppScreen.privacyPolicyLink.check(matches(isClickable()));

    }

    @Test
    @DisplayName("Ссылка на Пользовательское соглашение кликабельна")
    @Description("Тест-кейс 14. Ссылка, ведущая на страницу с  текстом Пользовательского соглашения  \"https://vhospice.org/#/terms-of-use\", кликабельна в разделе О приложении")
    public void shouldTermsOfUseIsClickable (){
        AboutAppSteps.enterAboutMenu();
        AboutAppScreen.termsOfUseLink.check(matches(isClickable()));

    }

    @Test
    @DisplayName("Возвращение на шаг назад из раздела О приложении")
    @Description("Тест-кейс 26. Возвращение на шаг назад с помощью стрелки в разделе О приложении")
    public void shouldStepBackWithBackButton (){
        AboutAppSteps.enterAboutMenu();
        AboutAppScreen.backButton.perform(click());
        MainScreen.containerNewsListMainPage.check(matches(isDisplayed()));
        MainScreen.citationsListButton.perform(click());
        MainMenuNavigationSteps.AboutAppMenuClick();
        AboutAppScreen.backButton.perform(click());
        CitationsScreen.citationsList.check(matches(isDisplayed()));

    }
}
