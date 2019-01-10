package com.example.coolz.festec;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ExampleFragment extends Fragment {
    private static String DATA_KEY = "dataKey";
    private String mData;
    private Activity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mData = getArguments().getString(DATA_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View foot = inflater.inflate(R.layout.activity_main, container, false);//需要注意的是inflate()的第三个参数是false，因为在Fragment内部实现中，会把该布局添加到container中，如果设为true，那么就会重复做两次添加，则会抛异常
        return foot;
    }

    public static ExampleFragment newInstance(String str) {
        ExampleFragment e = new ExampleFragment();
        Bundle b = new Bundle();
        b.putString(DATA_KEY, "xxxxxx");
        e.setArguments(b);//在创建Fragment时要传入参数，建议通过setArguments(Bundle bundle)方式添加，而不建议通过为Fragment添加带参数的构造函数，因为通过setArguments()方式添加，在由于内存紧张导致Fragment被系统杀掉并恢复（re-instantiate）时能保留这些数据
        return e;
    }
}
