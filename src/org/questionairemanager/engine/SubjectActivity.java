package org.questionairemanager.engine;

import java.util.Locale;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;

public class SubjectActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	Locale lLanguage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.subject_layout);
		
		Button btnNext = (Button) findViewById(R.id.btnNextsa);
		btnNext.setOnClickListener(new OnClickListener(){
			
				@Override
				public void onClick(View v){
					RadioGroup rgSubjects = (RadioGroup) findViewById(R.id.rgSubjects);
	        		int iCheckedRadioButtonId =  rgSubjects.getCheckedRadioButtonId();
	        		View radioButton = rgSubjects.findViewById(iCheckedRadioButtonId);
	        		int idx = rgSubjects.indexOfChild(radioButton);
	        		
	        		if(idx == 0){
	        			Intent iIntent = new Intent(SubjectActivity.this, AddSubjectActivity.class);
	        			startActivity(iIntent);
	        		}
	        		if(idx == 1){
	        			Intent iIntent = new Intent(SubjectActivity.this, EditSubjectActivity.class);
	        			startActivity(iIntent);
	        		}
				}
		});
		
		Button btnBack = (Button) findViewById(R.id.btnBacksa);
	    btnBack.setOnClickListener(new OnClickListener(){
	        	
	        	@Override 
	        	public void onClick(View v){
	        		SubjectActivity.super.onBackPressed();
	        	}
	        } );
	  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(SubjectActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(SubjectActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(SubjectActivity.this, BarCodeReaderActivity.class);
        	iIntentBarCode.putExtra("IdOrigin", ""+0);
    		startActivity(iIntentBarCode);
    		return true;		
        
        case R.id.menu_change_subject:
        	showMsg.instantMessage("CHANGE SUBJECT", this);
        	return true;
    		
        case R.id.menu_change_study:
        	showMsg.instantMessage("CHANGE STUDY", this);
        	return true;
        	
        case R.id.menu_logout:
        	showMsg.instantMessage("LOGOUT", this);
        	return true;
        	
        case R.id.menu_reports:
        	Intent iIntentReport = new Intent(SubjectActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;	
        	
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
		Intent refresh = new Intent(this, SelectInterviewer.class); 
		startActivity(refresh); 
	} 
}
