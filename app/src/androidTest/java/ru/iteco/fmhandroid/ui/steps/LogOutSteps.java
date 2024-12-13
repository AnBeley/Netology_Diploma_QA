package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.filters.LargeTest;

import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LogOutSteps extends BaseTest {

    public static void LogOut() {
        Allure.step("Выход из приложения");
        AuthorizationSteps.AuthData();
        DataHelper.wait(MainScreen.authorizationButton).perform(click());
        MainScreen.logOutButton.perform(click());
    }


}

