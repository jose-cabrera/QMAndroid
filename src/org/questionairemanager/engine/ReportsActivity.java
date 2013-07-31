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
import android.widget.RadioGroup;

public class ReportsActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	MenuItem miItem;
	int iTools = 0;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_layaout);
		
		Button btnNext = (Button) findViewById(R.id.btnNextra);
		btnNext.setOnClickListener(new OnClickListener(){
			
				@Override
				public void onClick(View v){
					RadioGroup rgSubjects = (RadioGroup) findViewById(R.id.rgReports);
	        		int iCheckedRadioButtonId =  rgSubjects.getCheckedRadioButtonId();
	        		View radioButton = rgSubjects.findViewById(iCheckedRadioButtonId);
	        		int idx = rgSubjects.indexOfChild(radioButton);
	        		
	        		if(idx == 0){
	        			Intent iIntent = new Intent(ReportsActivity.this, ReportsDataActivity.class);
	        			iIntent.putExtra("ReportID", ""+idx);
	        			startActivity(iIntent);
	        		}
	        		if(idx == 1){
	        			Intent iIntent = new Intent(ReportsActivity.this, ReportsDataActivity.class);
	        			iIntent.putExtra("ReportID", ""+idx);
	        			startActivity(iIntent);
	        		}
				}
		});
		
		Button btnBack = (Button) findViewById(R.id.btnBackra);
	    btnBack.setOnClickListener(new OnClickListener(){
	        	
	        	@Override 
	        	public void onClick(View v){
	        		ReportsActivity.super.onBackPressed();
	        	}
	        } );
	  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
    	case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(ReportsActivity.this, BarCodeReaderActivity.class);
        	iIntentBarCode.putExtra("IdOrigin", ""+0);
    		startActivity(iIntentBarCode);
    		return true;	
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(ReportsActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
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
       
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }

}
