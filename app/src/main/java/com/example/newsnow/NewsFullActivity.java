//package com.example.newsnow;
//
//import android.os.Bundle;
//import android.webkit.WebChromeClient;
//import android.webkit.WebResourceRequest;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import androidx.activity.OnBackPressedCallback;
//import androidx.activity.OnBackPressedDispatcher;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class NewsFullActivity extends AppCompatActivity {
//
//    private WebView webView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news_full);
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return WindowInsetsCompat.CONSUMED;
//        });
//
//        String url = getIntent().getStringExtra("url");
//        webView = findViewById(R.id.web_view);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setAllowFileAccess(false);
//        webSettings.setAllowContentAccess(false);
//        webView.setWebViewClient(new SecureWebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.loadUrl(url);
//
//        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
//        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                if (webView.canGoBack()) {
//                    webView.goBack();
//                } else {
//                    finish();
//                }
//            }
//        });
//    }
//
//    private static class SecureWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            String url = request.getUrl().toString();
//            if (url.startsWith("https://trustedwebsite.com")) {
//                return false; // Allow loading this URL
//            } else {
//                // Block loading other URLs
//                return true;
//            }
//        }
//    }
//}


package com.example.newsnow;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewsFullActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_full);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String url = getIntent().getStringExtra("url");
        webView = findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed(){
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }

}


