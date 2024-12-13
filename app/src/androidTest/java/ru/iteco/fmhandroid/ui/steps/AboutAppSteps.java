package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutAppSteps extends BaseTest {
    public static void enterAboutMenu(){
        Allure.step("Вход в меню - О Приложении");
        AuthorizationSteps.AuthData();
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.aboutAppMenuButton.perform(click());
    }
}

