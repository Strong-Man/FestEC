package com.example.coolz.festec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.coolz.latte.activities.ProxyActivity;
import com.example.coolz.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
