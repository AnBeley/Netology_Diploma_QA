package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class  ControlPanelScreen {


    public static ViewInteraction creatingNewsPageButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction creatingNewsPageTitle = onView(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news));
    public static ViewInteraction controlPanelOpenButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction editingPageTitle = onView(withText("Редактирование"));

    public static ViewInteraction activitySwitcher = onView(withId(R.id.switcher));

    public static ViewInteraction categoryOfNewsInput = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction titleOfNewsInput   = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction dateOfNewsInput = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction timeOfNewsInput = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionOfNewsInput = onView(withId(R.id.news_item_description_text_input_edit_text));

    public static ViewInteraction okButton = onView(withId(android.R.id.button1));
    public static ViewInteraction cancelDeleteButton = onView(withId(android.R.id.button2));
    public static ViewInteraction cancelCreatingButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction saveButtonOfNews = onView(withId(R.id.save_button));

    public static ViewInteraction deleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction editNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.edit_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }


}
