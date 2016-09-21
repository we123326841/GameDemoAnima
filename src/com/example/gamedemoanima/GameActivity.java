package com.example.gamedemoanima;

import com.example.dialog.ButterFlyDialog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GameActivity extends Activity {
	private WebView webview;
	private ButterFlyDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_view);
		dialog = new ButterFlyDialog(this); 
		webview = (WebView) findViewById(R.id.webview);
		// ����WebView���ԣ��ܹ�ִ��Javascript�ű�
		webview.getSettings().setJavaScriptEnabled(true);
		// ������Ҫ��ʾ����ҳ
		webview.loadUrl("http://120.25.160.36:7754/index");
		// ����Web��ͼ
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
			
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);
				dialog.show();
				Log.i("info", "开始");
			}
			
			
			
			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
				Log.i("info", "结束");
				dialog.dismiss();
			}
			
			
			
		});
	}

	// ���û���
	// ����Activity���onKeyDown(int keyCoder,KeyEvent event)����
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
			Log.i("info", "回退");
			webview.goBack(); // goBack()��ʾ����WebView����һҳ��
			return true;
		}else{
			finish();
		}
		return false;
	}
}
