package com.example.coolz.latte.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by zpw on 2018/12/7.
 */

public abstract class BaseDelegate extends SwipeBackFragment {
    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    public abstract Object setLayout();
    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }

        if(rootView != null){
            mUnbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState,rootView);
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
