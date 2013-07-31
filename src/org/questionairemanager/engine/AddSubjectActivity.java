package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddSubjectActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	MenuItem miItem;
	int iTools = 0;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_subject_layout);
		
		final EditText etSaSubjectId = (EditText) findViewById(R.id.etSaSubjectId);
		Button btnNext = (Button) findViewById(R.id.btnNextasa);
		btnNext.setOnClickListener(new OnClickListener(){
	        	
	        	@Override 
	        	public void onClick(View v){    
	        		if(etSaSubjectId.getText().toString() != null || etSaSubjectId.getText().toString() != ""){
	        			Intent iIntent = new Intent(AddSubjectActivity.this, QuestionsActivity.class);
	        			iIntent.putExtra("SubjectId", etSaSubjectId.getText().toString());
	        			startActivity(iIntent);
	        		}
	        		else{
	        			showMsg.instantMessage("Please add a SASubjectId to continue.", AddSubjectActivity.this);
	        		}
	        			
	        	}
	        } );
		
		Button btnBack = (Button) findViewById(R.id.btnBackasa);
	    btnBack.setOnClickListener(new OnClickListener(){
	        	
	        	@Override 
	        	public void onClick(View v){
	        		AddSubjectActivity.super.onBackPressed();
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
        	Intent iIntent = new Intent(AddSubjectActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(AddSubjectActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(AddSubjectActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(AddSubjectActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;	
        	
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }
}
