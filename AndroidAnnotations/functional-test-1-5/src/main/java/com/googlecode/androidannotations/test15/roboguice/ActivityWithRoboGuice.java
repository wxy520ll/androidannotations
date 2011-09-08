/**
 * Copyright (C) 2010-2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.androidannotations.test15.roboguice;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.widget.TextView;

import com.google.inject.Inject;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.RoboGuice;
import com.googlecode.androidannotations.test15.R;

/**
 * Adapted from http://pivotal.github.com/robolectric/roboguice.html
 */
@RoboGuice
@EActivity(R.layout.injected)
public class ActivityWithRoboGuice extends Activity {

    @InjectResource(R.string.injected_activity_caption)
    String caption;
    
    @InjectView(R.id.injected_text_view)
    TextView injectedTextView;
    
    @Inject
    Date date;

    @AfterViews
    void updateCaption() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        String formattedDate = dateFormat.format(date);
        injectedTextView.setText(caption + " - " + formattedDate);
    }
    
}
