

package com.example.Postoko.storeapp.ui;

import android.support.annotation.Nullable;


public interface PagerView<T extends PagerPresenter> extends BaseView<T> {

    @Nullable
    T getPresenter();
}
