package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CitationsListSteps extends BaseTest {

    public static void enterCitationsList(){
        Allure.step("Вход в раздел Цитаты");
        AuthorizationSteps.AuthData();
        MainScreen.citationsListButton.perform(click());
        CitationsScreen.citationsList.check(matches(isDisplayed()));

    }
}
