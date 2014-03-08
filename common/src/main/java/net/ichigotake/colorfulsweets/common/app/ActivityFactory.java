package net.ichigotake.colorfulsweets.common.app;

import android.content.Context;
import android.content.Intent;

/**
 * アクティビティを生成する
 */
public interface ActivityFactory {

    Intent create(Context context);
}
