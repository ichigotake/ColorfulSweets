package net.ichigotake.colorfulsweets.common.view;

import android.content.Context;
import android.view.View;

import net.ichigotake.colorfulsweets.common.app.ActivityFactory;
import net.ichigotake.colorfulsweets.common.app.ActivityTripper;
import net.ichigotake.colorfulsweets.common.app.Tripper;

/**
 * クリック時に何かしらの遷移をする
 */
public class OnClickToTrip implements View.OnClickListener {

    final private Tripper tripper;

    public OnClickToTrip(Tripper tripper) {
        this.tripper = tripper;
    }

    public OnClickToTrip(Context context, ActivityFactory from) {
        this(new ActivityTripper(context, from));
    }

    @Override
    public void onClick(View v) {
        tripper.go();
    }
}
