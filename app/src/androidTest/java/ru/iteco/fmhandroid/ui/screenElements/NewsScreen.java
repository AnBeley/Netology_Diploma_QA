package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;

public class NewsScreen {

    public static ViewInteraction newTestNews1 = onView(withText(DataHelper.title1));
    public static ViewInteraction newTestNews4 = onView(withText(DataHelper.title4));
    public static ViewInteraction newTestNews6 = onView(withText(DataHelper.title6));
    public static ViewInteraction newConcreteNews2 = onView(withText(DataHelper.concreteTitle2));
    public static ViewInteraction concreteDescriptionValue = onView(withText(DataHelper.concreteDescription));

    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterNewsButtonDateStarts = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction filterNewsButtonEnds = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public static ViewInteraction filterTitlePage = onView(withText("Фильтровать новости"));

    public static ViewInteraction newsListRecycler = onView(withId(R.id.news_list_recycler_view));

}
