package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.concreteTitle3;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title1;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title2;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title3;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title4;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title5;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title6;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.title7;

import androidx.test.filters.LargeTest;

import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsSteps extends BaseTest {


    public static void enterNewsMenu(){
        Allure.step("Вход в раздел Новости");
        AuthorizationSteps.AuthData();
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.newsMenuButton.perform(click());
    }

    public static void openControlPanel(){
        Allure.step("Открытие Панели управления");
        enterNewsMenu();
        ControlPanelScreen.controlPanelOpenButton.perform(click());
    }


    public static void openCreateNewsPage(){
        Allure.step("Открытие страницы создания новости");
        openControlPanel();
        ControlPanelScreen.creatingNewsPageButton.perform(click());
    }



    public static void createFirstValidNews(){
        Allure.step("Создание валидной новости 1");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title1));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }

    public static void createSecondValidNews(){
        Allure.step("Создание валидной новости 2");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title2));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }

    public static void createThirdValidNews(){
        Allure.step("Создание валидной новости 3");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title3));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }
    public static void createFourthValidNews(){
        Allure.step("Создание валидной новости 4");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title4));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }
    public static void createFifthValidNews(){
        Allure.step("Создание валидной новости 5");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title5));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }
    public static void createSixthValidNews(){
        Allure.step("Создание валидной новости 6");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title6));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }

    public static void createSeventhValidNews(){
        Allure.step("Создание валидной новости 7");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(title7));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }


    public static void createConcreteNews(){
        Allure.step("Создание конкретной валидной новости");
        openCreateNewsPage();
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Массаж"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(concreteTitle3));
        ControlPanelScreen.dateOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.timeOfNewsInput.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.description));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }



    public static void replaceValidDataOfeNews(){
        Allure.step("Замена значений полей новости на другие валидные значения");
        NewsSteps.createSecondValidNews();
        ControlPanelScreen.editNewsButton(title2).perform(click());
        ControlPanelScreen.categoryOfNewsInput.perform(replaceText("Зарплата"));
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(DataHelper.concreteTitle2));
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.concreteDescription));
        ControlPanelScreen.saveButtonOfNews.perform(click());
        NewsScreen.newConcreteNews2.check(matches(isDisplayed()));
        NewsScreen.newConcreteNews2.perform(click());
    }
    public static void deleteValidDataOfeNews(){
        Allure.step("Редактирование новости: удаление данных");
        NewsSteps.createThirdValidNews();
        ControlPanelScreen.editNewsButton(title3).perform(click());
        ControlPanelScreen.titleOfNewsInput.perform(replaceText(DataHelper.voidTitleOfNews));
        ControlPanelScreen.descriptionOfNewsInput.perform(replaceText(DataHelper.voidDescriptionOfNews));
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }

    public static void deleteNews(){
        Allure.step("Удаление новости");
        createConcreteNews();
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.newsMenuButton.perform(click());
        ControlPanelScreen.controlPanelOpenButton.perform(click());
        FilterPanel();
        ControlPanelScreen.deleteNewsButton(concreteTitle3).perform(click());
        ControlPanelScreen.okButton.perform(click());
    }


    public static void dialogWindowDeleteNews(){
        Allure.step("Вызов диалогового окна перед удалением новости");
        createFourthValidNews();
        EnterMenuButtonSteps.enterMenuButton();
        MainScreen.newsMenuButton.perform(click());
        ControlPanelScreen.controlPanelOpenButton.perform(click());
        FilterPanel();
        ControlPanelScreen.deleteNewsButton(title4).perform(click());
    }


    public static void makeNotActiveNews(){
        Allure.step("Смена статуса с активна на не активна");
        NewsSteps.createFifthValidNews();
        FilterPanel();
        ControlPanelScreen.editNewsButton(title5).perform(click());
        ControlPanelScreen.activitySwitcher.perform(click());
        ControlPanelScreen.saveButtonOfNews.perform(click());

    }

    public static void makeActiveNews(){
        Allure.step("Смена статуса с не активна на активна");
        NewsSteps.createSixthValidNews();
        FilterPanel();
        ControlPanelScreen.editNewsButton(title6).perform(click());
        ControlPanelScreen.activitySwitcher.perform(click());
        ControlPanelScreen.saveButtonOfNews.perform(click());
        ControlPanelScreen.editNewsButton(title6).perform(click());
        ControlPanelScreen.activitySwitcher.perform(click());
        ControlPanelScreen.saveButtonOfNews.perform(click());
    }

    public static void FilterPanel(){
        Allure.step("Фильтрация в панели инструментов");
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDateStarts.perform(click());
        ControlPanelScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonEnds.perform(click());
        ControlPanelScreen.okButton.perform(click());
        NewsScreen.filterButton.perform(click());

    }

}