package com.example.multipleactivitiesnovember12021;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PulseView extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // Obvious next step is: document.forms[0].submit()
        view.loadUrl
                ("javascript:(function() { " +
                        "document.getElementsByClassName('js-header-wrapper')[0].style.display='none'; " +
                        "document.getElementsByClassName('js-repo-nav')[0].style.display='none'; "+
                        "document.getElementsByClassName('Layout-sidebar')[0].style.display='none'; "+
                        "document.getElementsByClassName('footer')[0].style.display='none'; "+
                        "document.getElementById('repository-container-header').style.display = 'none';" +
                        "document.getElementsByClassName('Subhead')[0].style.display='none'; "+
                        "})()");
    }
}
