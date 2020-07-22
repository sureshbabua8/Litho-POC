package com.amirthasureshbabu.litho_poc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.LithoView;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;

import androidx.appcompat.app.AppCompatActivity;

import static com.facebook.litho.annotations.ResType.STRING;
import static com.facebook.yoga.YogaFlexDirection.ROW;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        final Component launchExplorer = LaunchLayout.create(c)
                .build();

        setContentView(LithoView.create(c, launchExplorer));
    }
}

@LayoutSpec
class LaunchLayoutSpec {
    @OnCreateLayout
    static Component onCreateLayoutContent(ComponentContext c) {
        return Column.create(c)
                .child(
                        Text.create(c).text("Welcome to Litho!")
                        .textSizeSp(40)
                )
                .child(
                      LaunchButtonContainer.create(c).build()
                )
                .alignItems(YogaAlign.CENTER)
                .justifyContent(YogaJustify.CENTER)
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onButtonClick(ComponentContext c) {
        Intent intent = new Intent(c.getAndroidContext(), MainActivity.class);
        c.getAndroidContext().startActivity(intent);
    }
}

@LayoutSpec
class LaunchButtonContainerSpec {
    @OnCreateLayout
    static Component onCreateLayoutContent(ComponentContext c) {
        return Card.create(c)
                .cardBackgroundColorRes(R.color.colorPrimary)
                .cornerRadiusDip(2)
                .elevationDip(2)
                .content(Text.create(c).text("hello")
                        .clickHandler(LaunchLayout.onButtonClick(c))
                        .build())
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onButtonClick(ComponentContext c) {
        Intent intent = new Intent(c.getAndroidContext(), MainActivity.class);
        c.getAndroidContext().startActivity(intent);
    }
}


