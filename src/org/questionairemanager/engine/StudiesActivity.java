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

public class StudiesActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	Spinner sStudie;
	Locale lLanguage;
	Button btnLogIn;
	Button btnExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studies_layout);
		addItemsOnSpinner();
		
		btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		Intent iIntent = new Intent(StudiesActivity.this, QuestionariesActivity.class);
        		startActivity(iIntent);
        	}
        } );
        
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		StudiesActivity.super.onBackPressed();
        	}
        } );
	}
		
	 public void addItemsOnSpinner() {    	 
	    	sStudie = (Spinner) findViewById(R.id.sStudie);
	    		    		    	
	    	List<String> list = new ArrayList<String>();
	    		    		    	
	    	list.add("Study one");
	    	list.add("Study two");
	    	list.add("Study three");
	    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	    		android.R.layout.simple_spinner_item, list);
	    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    	sStudie.setAdapter(dataAdapter);
	 }
	 
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			getMenuInflater().inflate(R.menu.studies, menu);
			return true;
		}
		
	    //handle menu item selection
	    public boolean onOptionsItemSelected(MenuItem miItem){
	    	
	    	switch (miItem.getItemId()) {
	        case R.id.menu_gps:
	        	Intent iIntent = new Intent(StudiesActivity.this, GPSActivity.class);
	        	iIntent.putExtra("IdOrigin", ""+0);
	    		startActivity(iIntent);
	    		return true;
	         
	        case R.id.menu_timer:
	        	Intent iIntentTimer = new Intent(StudiesActivity.this, TimerActivity.class);
	    		startActivity(iIntentTimer);
	    		return true;
	    		
	        case R.id.menu_barcodereader:
	        	Intent iIntentBarCode = new Intent(StudiesActivity.this, BarCodeReaderActivity.class);
	        	iIntentBarCode.putExtra("IdOrigin", ""+0);
	    		startActivity(iIntentBarCode);
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
			Intent refresh = new Intent(this, StudiesActivity.class); 
			startActivity(refresh); 
		} 

}
