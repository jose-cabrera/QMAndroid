package org.questionairemanager.engine;

import java.util.Locale;

import org.questionairemanager.engine.utility.ScreenManager;
import org.questionairemanager.engine.utility.ShowMessage;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity{

	ScreenManager smScreenManager;
	String iLayoutiId = null;
	ShowMessage showMsg = new ShowMessage();
	Locale lLanguage;
	String id;
	
	/**
	 * BAR CODE SCANNER ITEMS
	 */
	private TextView tvFormat, tvContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		smScreenManager = new ScreenManager(this);

		smScreenManager.drawScreen(ScreenManager.WELCOME, null, null, null);
		
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return true;
	}

	/**
	 * Changes the language Resource files
	 * @param lang, String, the language you want to select
	 */
	public void setLocale(String lang) {
		lLanguage = new Locale(lang);
		Resources res = getResources();
		DisplayMetrics dm = res.getDisplayMetrics();
		Configuration conf = res.getConfiguration();
		conf.locale = lLanguage;
		res.updateConfiguration(conf, dm);
		Intent refresh = new Intent(this, AddSubjectActivity.class);
		startActivity(refresh);
	}
		
	/**
	 * Activity Result of BAR CODE READER
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		String sScanContent;
		String sScanFormat;
		
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			sScanContent = "FORMAT "+scanningResult.getContents();
			sScanFormat = "CONTENT "+scanningResult.getFormatName();

		}
		else{
			 sScanContent = "No scan data received!";
			 sScanFormat = "No scan data received!";
		}
		
		smScreenManager.setScanContent(sScanContent);
		smScreenManager.setScanFormat(sScanFormat);
	}
}
