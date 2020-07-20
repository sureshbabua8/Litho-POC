package com.amirthasureshbabu.litho_poc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.SolidColor;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;
import com.facebook.yoga.YogaEdge;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        final Component launchExplorer = LaunchComponentButton.create(c)
//                .clickHandler(LaunchComponentButton.onButtonClick(c))
                .marginDip(YogaEdge.RIGHT, 16)
                .build();

        setContentView(LithoView.create(c, launchExplorer));
    }
}

@MountSpec
class LaunchComponentButtonSpec {
    @OnCreateMountContent
    static Button onCreateMountContent(Context c) {
        return new Button(c);

//        return Text.create(c)
//                .text(title)
//                .textAlignment(Layout.Alignment.ALIGN_CENTER)
//                .clickable(true)
//                .clickHandler(LaunchComponent.onClick(c))
//                .backgroundColor(Color.RED)
//                .build();
    }

    @OnMount
    static void onMount(
            ComponentContext c, Button button) {
        button.setText("Explore Courses");
    }

    @OnEvent(ClickEvent.class)
    static void onButtonClick(final ComponentContext c) {
        Intent intent = new Intent(c.getAndroidContext(), MainActivity.class);
        c.getAndroidContext().startActivity(intent);
    }

}