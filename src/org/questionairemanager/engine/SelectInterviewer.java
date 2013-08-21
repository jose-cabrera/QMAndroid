package org.questionairemanager.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.questionairemanager.engine.utility.ShowMessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectInterviewer extends Activity {

	ShowMessage showMsg = new ShowMessage();
	Spinner sCode;
	TextView tvStudyNameLong;
	TextView tvStudyNameShort;
	Locale lLanguage;
	Button btnNext, btnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        super.setContentView(R.layout.interviewer_layout);
        
        tvStudyNameLong = (TextView) findViewById(R.id.tvStudyNameLong);
        tvStudyNameLong.setText("New Study");
        tvStudyNameShort = (TextView) findViewById(R.id.tvStudyNameShort);
        tvStudyNameShort.setText("(NS)");
        addItemsOnSpinner2();
        
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		Intent iIntent = new Intent(SelectInterviewer.this, SubjectActivity.class);
        		startActivity(iIntent);
        	}
        } );
        
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		SelectInterviewer.super.onBackPressed();
        	}
        } );
        
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(SelectInterviewer.this, GPSActivity.class);
        	iIntent.putExtra("IdOrigin", ""+0);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(SelectInterviewer.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(SelectInterviewer.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(SelectInterviewer.this, ReportsActivity.class);
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
    
    public void addItemsOnSpinner2() {
    	 
    	sCode = (Spinner) findViewById(R.id.sCode);
    	List<String> list = new ArrayList<String>();
    	list.add("000000");
    	list.add("000001");
    	list.add("000010");
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	sCode.setAdapter(dataAdapter);
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
