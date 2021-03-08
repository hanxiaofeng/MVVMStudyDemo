package com.xinshiyun.focusdemo.selector;

import android.content.Context;

import androidx.leanback.widget.ListRow;

import com.xinshiyun.focusdemo.adapter.ImagePresenter;
import com.xinshiyun.focusdemo.adapter.TitlePresenter;


public class ContentPresenterSelector extends BasePresenterSelector {
    public ContentPresenterSelector(Context context) {

        ContentListRowPresenter listRowPresenter = new ContentListRowPresenter();
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        listRowPresenter.setKeepChildForeground(false);
        listRowPresenter.setHeaderPresenter(new ImageRowHeaderPresenter());

        addClassPresenter(ListRow.class, listRowPresenter, ImagePresenter.class);
        addClassPresenter(ListRow.class, listRowPresenter, TitlePresenter.class);
    }

}
