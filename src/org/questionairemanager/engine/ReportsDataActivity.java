package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ScreenMaker;
import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ReportsDataActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	ScreenMaker smScreen;
	MenuItem miItem;
	int iTools = 0;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportdata_layout);
		
		int sReportSelected = Integer.parseInt(getIntent().getExtras().getString("ReportID"));
		
		final LinearLayout llDataTable = (LinearLayout) findViewById(R.id.llDataTableLayout);
		
		if(sReportSelected == 0){
			String[][] asValues = {{"00971", "Carlos Ruiz", "3", "38.5"},{"02353", "Ricardo Castillo", "4", "39"},{"00231", "Miguel Mazariegos", "2", "40"},{"97836", "José Hernandez", "1", "42"},{"06751", "Angel Cabrera", "0.6", "38.9"},{"78769", "Miguel Davila", "4", "39.5"},{"07135", "Manuel García", "3", "38"}}; 
			String[] asColumns = {"Subject ID", "Nombre", "Edad", "Temperatura"};
			
			smScreen.DataTable(asColumns, asValues);
			llDataTable.addView(smScreen.MakeScreen());
			
		}
		if(sReportSelected == 1){
			String[][] asValues = {{"12971", "Flor Porras", "20", "38.5"},{"12353", "Marco Merida", "22", "39"},{"07791", "Ilse Figueroa", "18", "40"},{"97920", "Priscila Amaya", "19", "42"},{"7777", "Diego Aquino", "21", "38.9"},{"0531", "Luis Andrade", "23", "39.5"},{"12254", "Alex Perdomo", "25", "38"}}; 
			String[] asColumns = {"Subject ID", "Nombre", "Edad", "Temperatura"};
			
			smScreen.DataTable(asColumns, asValues);
			llDataTable.addView(smScreen.MakeScreen());
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
}
