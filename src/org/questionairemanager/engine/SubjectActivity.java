package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.app.Activity;
import android.content.Intent;

public class SubjectActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	MenuItem miItem;
	int iTools = 0;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.subject_layout);
		
		Button btnNext = (Button) findViewById(R.id.btnNext);
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
	        } );
		
		Button btnBack = (Button) findViewById(R.id.btnBack);
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
