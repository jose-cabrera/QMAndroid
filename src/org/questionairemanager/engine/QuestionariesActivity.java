package org.questionairemanager.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class QuestionariesActivity extends Activity {
	
	ShowMessage showMsg = new ShowMessage();
	Spinner sQuestionarie;
	Locale lLanguage;
	Button btnNext, btnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questionaries_layout);
		
		addItemsOnSpinner();
		
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		Intent iIntent = new Intent(QuestionariesActivity.this, SelectInterviewer.class);
        		startActivity(iIntent);
        	}
        } );
        
		btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		QuestionariesActivity.super.onBackPressed();
        	}
        } );
        
	}
	
	public void addItemsOnSpinner() {    	 
		sQuestionarie = (Spinner) findViewById(R.id.sQuestionarie);
    	List<String> list = new ArrayList<String>();
    	list.add("Questionarie 1");
    	list.add("Questionarie 2");
    	list.add("Questionarie 3");
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	sQuestionarie.setAdapter(dataAdapter);
 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questionaries, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(QuestionariesActivity.this, GPSActivity.class);
        	iIntent.putExtra("IdOrigin", ""+0);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(QuestionariesActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(QuestionariesActivity.this, BarCodeReaderActivity.class);
        	iIntentBarCode.putExtra("IdOrigin", ""+0);
    		startActivity(iIntentBarCode);
    		return true;	
    		
        case R.id.menu_change_study:
        	Intent iIntentChangeStudy = new Intent(QuestionariesActivity.this, StudiesActivity.class);        	
    		startActivity(iIntentChangeStudy);
    		return true;		
    		             	      	        	
        case R.id.menu_logout:
        	showMsg.instantMessage("LOGOUT", this);
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
    
    public void setLocale(String lang) { 
		lLanguage = new Locale(lang); 
		Resources res = getResources(); 
		DisplayMetrics dm = res.getDisplayMetrics(); 
		Configuration conf = res.getConfiguration(); 
		conf.locale = lLanguage; 
		res.updateConfiguration(conf, dm); 
		Intent refresh = new Intent(this, QuestionariesActivity.class); 
		startActivity(refresh); 
	} 
	
	

}
