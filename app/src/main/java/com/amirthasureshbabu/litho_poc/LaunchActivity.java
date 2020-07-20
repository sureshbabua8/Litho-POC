package com.amirthasureshbabu.litho_poc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        final Component launchExplorer = Text.create(c)
                .text("Explore Courses")
                .textSizeDip(50)
                .build();

        setContentView(LithoView.create(c, launchExplorer));
    }
}

@LayoutSpec
class LaunchComponentSpec {
    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String title) {

        return Text.create(c)
                .text(title)
                .clickable(true)
                .clickHandler(LaunchComponent.onClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(
            ComponentContext c,
            @FromEvent View view,
            @Prop String someProp) {
        System.out.println("something happening");
        Intent intent = new Intent(c.getAndroidContext(), MainActivity.class);
        c.getAndroidContext().startActivity(intent);
    }

}