package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;

public class EditSubjectActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_subject_layout);
		
		
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
        	Intent iIntent = new Intent(EditSubjectActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(EditSubjectActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(EditSubjectActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(EditSubjectActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;		
       
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }
	

}
