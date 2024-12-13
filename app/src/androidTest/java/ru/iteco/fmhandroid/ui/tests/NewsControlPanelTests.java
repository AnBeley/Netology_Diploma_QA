package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.steps.NewsSteps.openCreateNewsPage;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
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
import ru.iteco.fmhandroid.ui.screenElements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.MainMenuNavigationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsControlPanelTests extends BaseTest {

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
    @DisplayName("Открытие Панели управления")
    @Description("Тест-кейс 37. Открытие страницы Панели управления при нажатии на кнопку редактирования в разделе Новости")
    public void shouldControlPanelOpen(){
        NewsSteps.openControlPanel();
        ControlPanelScreen.creatingNewsPageButton.check(matches(isDisplayed()));
    }


    @Test
    @DisplayName("Открытие страницы созданния новости")
    @Description("Тест-кейс 63. Открывается страница создания новости при нажатии на плюс в Панели управления")
    public void shouldCreateNewsPageDisplayed(){
        openCreateNewsPage();
        ControlPanelScreen.creatingNewsPageTitle.check(matches(isDisplayed()));

    }


    @Test
    @DisplayName("Создание новости  валидными данными")
    @Description("Тест-кейс 70. Новость создается при заполнении полей валидными данными")
    public void shouldNewsCreated(){
        NewsSteps.createFirstValidNews();
        NewsScreen.newTestNews1.check(matches(isDisplayed()));
    }


    @Test
    @DisplayName("Отмена создания  новости")
    @Description("Тест-кейс 73. Новость не создается при нажатии на кнопку отмена в процессе создания новости в панели управления")
    public void shouldCancelNewsCreating(){
        NewsSteps.openCreateNewsPage();
        ControlPanelScreen.cancelCreatingButton.perform(click());
        ControlPanelScreen.okButton.perform(click());
        ControlPanelScreen.creatingNewsPageButton.check(matches(isDisplayed()));

    }


    @Test
    @DisplayName("Создание новости с пустыми значениями")
    @Description("Тест кейс 72. Появление нотификации об ошибке при попытке создать новость со всеми пустыми полями")
    public void shouldNotCreatedWithVoidData(){
        openCreateNewsPage();
        ControlPanelScreen.saveButtonOfNews.perform(click());
        onView(withText(DataHelper.voidDataNewsError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Удаление новости")
    @Description("Тест-кейс 64. Новость удаляется при нажатии на иконку корзины в карточке новости в  Панели управления")
    public void shouldDeleteNews() {
        NewsSteps.deleteNews();
        NewsScreen.newsListRecycler.check(matches(not(hasDescendant(withText(DataHelper.concreteTitle3)))));

    }


    @Test
    @DisplayName("Отмена удаления новости")
    @Description("Тест-кейс 65. Новость не удаляется при нажатии на кнопку \"Отмена\" в диалоговом окне удаления в Панели управления")
    public void shouldNotDeleteNews() {
        NewsSteps.dialogWindowDeleteNews();
        ControlPanelScreen.cancelDeleteButton.perform(click());
        NewsScreen.newTestNews4.check(matches(isDisplayed()));

    }


    @Test
    @DisplayName("Открытие страницы редактирования новости")
    @Description("Тест-кейс 66. Открывается страница редактирования новости при нажатии на карандаш в Панели управления")
    public void shouldEditNewsPageDisplayed(){
        NewsSteps.createSeventhValidNews();
        ControlPanelScreen.editNewsButton(DataHelper.title7).perform(click());
        ControlPanelScreen.editingPageTitle.check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Замена данных новости другими валидными данными в процессе редактирования")
    @Description("Тест-кейс 76.Данные в полях заменяются другими валидными данными корректно в процессе редактирования новости в Панели управления")
    public void shouldReplaceWithAnotherValidData(){
        NewsSteps.replaceValidDataOfeNews();
        NewsScreen.concreteDescriptionValue.check(matches(isDisplayed()));

    }

    @Test
    @DisplayName("Появляется нотификации об ошибке при попытке удалить данные в полях в процессе редактирования новости")
    @Description("Тест-кейс 77. Появляется нотификации об ошибке при попытке удалить данные в полях в процессе редактирования карточки новости в Панели управления")
    public void shouldErrorIfDeleteData(){
       NewsSteps.deleteValidDataOfeNews();
        onView(withText(DataHelper.voidDataNewsError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Смена статуса новости с активна на неактивна")
    @Description("Тест-кейс 78. Новость перестает отображаться в разделе при смене статуса сактивна на не активна в Панели управления")
    public void shouldChangeStatusToNotActive(){
       NewsSteps.makeNotActiveNews();
       MainMenuNavigationSteps.NewsMenuClick();
      NewsScreen.newsListRecycler.check(matches(not(hasDescendant(withText(DataHelper.title5)))));
    }

    @Test
    @DisplayName("Смена статуса новости с не активна на активна")
    @Description("Тест-кейс 79. Новость начинает отображаться в разделе при смене статуса с не активна на активна в Панели управления")
    public void shouldChangeStatusToActive(){
       NewsSteps.makeActiveNews();
       MainMenuNavigationSteps.NewsMenuClick();
       NewsScreen.newTestNews6.check(matches(isDisplayed()));

    }
}
