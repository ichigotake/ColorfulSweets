package net.ichigotake.colorfulsweets.common.app;

import android.app.Fragment;

/**
 * フラグメントを生成する
 */
public interface FragmentFactory {

    /**
     * 継承忘れがないように基底クラスを型制約で縛る
     *
     * @return fragment フラグメントのインスタンスを生成する
     */
    Fragment create();
}
