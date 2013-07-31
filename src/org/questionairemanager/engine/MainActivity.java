package org.questionairemanager.engine;

import java.util.ArrayList;
import java.util.List;

import org.questionairemanager.engine.utility.ShowMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	Spinner sCode;
	TextView tvStudyNameLong;
	TextView tvStudyNameShort;
	Button btnLogIn;
	Button btnExit;
	MenuItem miItem;
	int iTools = 0;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main_layout);
        
        tvStudyNameLong = (TextView) findViewById(R.id.tvStudyNameLong);
        tvStudyNameLong.setText("New Study");
        tvStudyNameShort = (TextView) findViewById(R.id.tvStudyNameShort);
        tvStudyNameShort.setText("(NS)");
        addItemsOnSpinner2();
        
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		Intent iIntent = new Intent(MainActivity.this, SubjectActivity.class);
        		startActivity(iIntent);
        	}
        } );
        
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		MainActivity.super.onBackPressed();
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
        	Intent iIntent = new Intent(MainActivity.this, GPSActivity.class);
        	iIntent.putExtra("IdOrigin", ""+0);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(MainActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(MainActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(MainActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
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
    
}
