package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.steps.CitationsListSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CitationsListTests extends BaseTest {



    @Test
    @DisplayName("Разворачивание текста цитаты")
    @Description("Тест-кейс 32. Разворачивание текста цитаты с помощью стрелки в разделе цитаты")
    public void shouldShowCitation(){
        CitationsListSteps.enterCitationsList();
        CitationsScreen.citationTitleValue.perform(click());
        CitationsScreen.citationTextValue.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Сворачивание текста цитаты")
    @Description("Тест-кейс 33. Сворачивание текста цитаты при нажатии на блок с цитатой в разделе Цитаты ")
    public void shouldHideCitation(){
        CitationsListSteps.enterCitationsList();
        CitationsScreen.citationTitleValue.perform(click());
        CitationsScreen.citationTitleValue.perform(click());
        CitationsScreen.citationTextValue.check(matches(not(isDisplayed())));
    }


}
