package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;

public class CitationsScreen {
    public static ViewInteraction citationTitleValue = onView(withText(DataHelper.citationTitle));
    public static ViewInteraction citationTextValue = onView(withText(DataHelper.citationText));
    public static ViewInteraction citationsList = onView(withId(R.id.our_mission_item_list_recycler_view));

}