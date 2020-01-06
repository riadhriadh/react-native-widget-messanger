package com.reactlibrary;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class WidgetMessangerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public WidgetMessangerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }
    @ReactMethod
    public void show(){

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            reactContext.startService(new Intent(reactContext.getApplicationContext(), FloatingViewService.class));

        } else   {
            reactContext.startService(new Intent(reactContext.getApplicationContext(), FloatingViewService.class));

        }
    }

    @Override
    public String getName() {
        return "WidgetMessanger";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
