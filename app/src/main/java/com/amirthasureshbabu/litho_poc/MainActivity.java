package com.amirthasureshbabu.litho_poc;

import android.os.Bundle;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        final Component component =
                RecyclerCollectionComponent.create(c)
                        .disablePTR(true)
                        .section(ListSection.create(new SectionContext(c)).build())
                        .build();

        setContentView(LithoView.create(c, component));
    }
}