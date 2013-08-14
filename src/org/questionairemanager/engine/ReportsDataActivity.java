package org.questionairemanager.engine;

import java.util.Locale;

import org.questionairemanager.engine.utility.ScreenMaker;
import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReportsDataActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	ScreenMaker smScreen;
	TableLayout tlDataTable;
	TableRow trDataRow, trDataRow2;
	TextView tvCell;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportdata_layout);
		
		int sReportSelected = Integer.parseInt(getIntent().getExtras().getString("ReportID"));
		tlDataTable = (TableLayout) findViewById(R.id.tlDataTable);
		tlDataTable.setStretchAllColumns(true);  
		tlDataTable.setShrinkAllColumns(true);  
		
		TableRow.LayoutParams params = new TableRow.LayoutParams();  
	    params.span = 6;  
	    params.setMargins(1, 1, 1, 1);	   
  	   	  	   	
		if(sReportSelected == 0){
			String[][] asValues = {{"00971", "Carlos Ruiz", "3", "38.5"},{"02353", "Ricardo Castillo", "4", "39"},{"00231", "Miguel Mazariegos", "2", "40"},{"97836", "José Hernandez", "1", "42"},{"06751", "Angel Cabrera", "0.6", "38.9"},{"78769", "Miguel Davila", "4", "39.5"},{"07135", "Manuel García", "3", "38"}}; 
			String[] asColumns = {"Subject ID", "Nombre", "Edad", "Temperatura"};					
			 
			trDataRow = (TableRow) new TableRow(this);
			for(int i=0; i<asColumns.length; i++){				   	    		  
	    		   tvCell = (TextView) new TextView(this);	
				   String text = asColumns[i].toString();
				   Log.d("TEXTO", text);				   
	    		   tvCell.setText(text);
//	    		   tvCell.setBackgroundColor(Color.BLACK);
	    		   tvCell.setGravity(Gravity.CENTER); 	
	    		   trDataRow.addView(tvCell, params);	    		   
	    	} 	    			
	    		   tlDataTable.addView(trDataRow);
	    		   
		   for(int i=0; i<asValues.length; i++){
			   trDataRow2 = (TableRow) new TableRow(this);
    		   for(int j=0; j<asValues[i].length; j++){
    			   tvCell = (TextView) new TextView(this);	
    			   String text = asValues[i][j].toString();
				   Log.d("TEXTO", text);	
    			   tvCell.setText(text);
    			   trDataRow2.addView(tvCell, params);	
    		   }
    		   tlDataTable.addView(trDataRow2);
    	   }    	 	   
	    		   
		}
		if(sReportSelected == 1){
			String[][] asValues = {{"12971", "Flor Porras", "20", "38.5"},{"12353", "Marco Merida", "22", "39"},{"07791", "Ilse Figueroa", "18", "40"},{"97920", "Priscila Amaya", "19", "42"},{"7777", "Diego Aquino", "21", "38.9"},{"0531", "Luis Andrade", "23", "39.5"},{"12254", "Alex Perdomo", "25", "38"}}; 
			String[] asColumns = {"Subject ID", "Nombre", "Edad", "Temperatura"};
			
			trDataRow = (TableRow) new TableRow(this);
			for(int i=0; i<asColumns.length; i++){				   	    		  
	    		   tvCell = (TextView) new TextView(this);	
				   String text = asColumns[i].toString();
				   Log.d("TEXTO", text);				   
	    		   tvCell.setText(text);
//	    		   tvCell.setBackgroundColor(Color.BLACK);
	    		   tvCell.setGravity(Gravity.CENTER); 	
	    		   trDataRow.addView(tvCell, params);	    		   
	    	} 	    			
	    		   tlDataTable.addView(trDataRow);
	    		   
		   for(int i=0; i<asValues.length; i++){			   
    		   for(int j=0; j<asValues[i].length; j++){
    			   trDataRow2 = (TableRow) new TableRow(this);
    			   trDataRow2.setClickable(true);
    			   tvCell = (TextView) new TextView(this);	
    			   String text = asValues[i][j].toString();
				   Log.d("TEXTO", text);	
    			   tvCell.setText(text);
    			   trDataRow2.addView(tvCell, params);	
    		   }
    		   tlDataTable.addView(trDataRow2);
    	   } 
		}
		
	    for(int i = 0; i < tlDataTable.getChildCount(); i++){
	        //Remember that .getChildAt() method returns a View, so you would have to cast a specific control.
	        final TableRow row = (TableRow) tlDataTable.getChildAt(i); 
	        //This will iterate through the table row.
	        row.setOnClickListener(new OnClickListener() {
		        public void onClick(View v) {
		            v.setBackgroundColor(Color.GRAY);
		            System.out.println("Row clicked: " + v.getId());

		           //get the data you need
		           TextView sample = (TextView) row.getChildAt(0);
		           String result=sample.getText().toString();
		           System.out.println("DATA RETRIEVE: " + result);
		        }
		    });
	    }		
					
		Button btnBack = (Button) findViewById(R.id.btnBackrda);
		btnBack.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v){
				ReportsDataActivity.super.onBackPressed();
			}
			
		});
		
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
        	Intent iIntent = new Intent(ReportsDataActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(ReportsDataActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(ReportsDataActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(ReportsDataActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
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
		Locale lLanguage = new Locale(lang); 
		Resources res = getResources(); 
		DisplayMetrics dm = res.getDisplayMetrics(); 
		Configuration conf = res.getConfiguration(); 
		conf.locale = lLanguage; 
		res.updateConfiguration(conf, dm); 
		Intent refresh = new Intent(this, WelcomeActivity.class); 
		startActivity(refresh); 
	} 
}

