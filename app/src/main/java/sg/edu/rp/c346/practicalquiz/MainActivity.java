package sg.edu.rp.c346.practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner);
        wb = findViewById(R.id.webview);

        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.getBuiltInZoomControls();

        wb.setWebViewClient(new WebViewClient());

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.website));
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner1.setAdapter(spinnerArrayAdapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Your code for item 1 selected
                        final String[] strNumbersEven = getResources().getStringArray(R.array.website_url);
                        wb.loadUrl(strNumbersEven[0]);
                        break;
                    case 1:
                        //Your code for item 2 selected
                        final String[] strNumbersOdd = getResources().getStringArray(R.array.website_url);
                        wb.loadUrl(strNumbersOdd[1]);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> AdapterView) {

            }
        });


    }
}
