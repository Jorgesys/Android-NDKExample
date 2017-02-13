package com.puisormobile.androidndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Example of a call to a native method
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            ((TextView) findViewById(R.id.textView1)).setText(Html.fromHtml(stringFromJNI(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) findViewById(R.id.textView1)).setText(Html.fromHtml(stringFromJNI()));
        }
        ((TextView) findViewById(R.id.textView2)).setText(stringCopyright());

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String stringCopyright();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
