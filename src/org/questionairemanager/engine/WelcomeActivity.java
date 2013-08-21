package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.LoadingDialog;
import org.questionairemanager.engine.utility.ShowMessage;

import java.util.Locale; 
import android.os.Bundle; 
import android.os.CountDownTimer;
import android.app.Activity; 
import android.content.Intent; 
import android.content.res.Configuration; 
import android.content.res.Resources; 
import android.util.DisplayMetrics; 
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class WelcomeActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	RelativeLayout rlLayout;
	CountDownTimer cdtTimer, cdtTimer2;
	LoadingDialog loader;
	Locale lLanguage;
	Boolean bBandera = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_layout);
		
		rlLayout = (RelativeLayout) findViewById(R.id.rlWelcomeLayout);
		loader = new LoadingDialog(this);
		
		cdtTimer = new CountDownTimer(4500, 1000) {
			
			     public void onTick(long millisUntilFinished) {
			    	
			     }

			     @Override
			     public void onFinish() {
			    	loader.stopSpinnerLoading();
			    	Intent iIntent = new Intent(WelcomeActivity.this, StudiesActivity.class);
			    	startActivity(iIntent);
			     }
		};	    
		
		cdtTimer2 = new CountDownTimer(5000, 1000) {
			
		     public void onTick(long millisUntilFinished) {
		    	
		     }

		     @Override
		     public void onFinish() {
		    	 if(bBandera == false){
		    		 String msg = getString(R.string.tap_the_screen_to_begin_qm);
			    	 showMsg.longInstantMessage(msg, WelcomeActivity.this);
		    	 }		    	 
		     }
		}.start();	  
						
		rlLayout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				bBandera = true;
				cdtTimer.start();
				loader.showSpinnerLoading();				    			        			 			
			}
			
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_language_en:
        	setLocale("en");
    		return true;
    		
        case R.id.menu_language_es:
        	setLocale("es");
    		return true;
    		
        default:
        	return super.onOptionsItemSelected(miItem);	
    	}
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
		Intent refresh = new Intent(this, WelcomeActivity.class); 
		startActivity(refresh); 
	} 
}
