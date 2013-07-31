package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ShowMessage;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimerActivity extends Activity {
	
	MenuItem miItem;
	int iTools = 0;
	ShowMessage showMsg = new ShowMessage();
	CountDownTimer cdtTimer; 
	Button btnStart, btnStop, btnReset;
	EditText etTimerSeconds, etTimerMinutes, etTimerHour;
	TextView tvInfo;
	Boolean bFlag = true;
	
	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer_layout);
		
		btnStart = (Button) findViewById(R.id.btnTimerStart);
		btnStop = (Button) findViewById(R.id.btnTimerStop);
		btnReset = (Button) findViewById(R.id.btnTimerReset);
		
		etTimerSeconds = (EditText) findViewById(R.id.etSecond);
		etTimerMinutes = (EditText) findViewById(R.id.etMinute);
		etTimerHour = (EditText) findViewById(R.id.etHour);
		tvInfo = (TextView) findViewById(R.id.tvInfo);
		
		btnStart.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
	        	if(bFlag == true){	
	        		btnStart.setTextColor(Color.GRAY);
	        		btnStop.setTextColor(Color.BLACK);
	        		btnReset.setTextColor(Color.BLACK);
	        		
	        		long lTime;
	        		int iSeconds;
	        		int iMinutes;
	        		int iHour;
	        		try{
	        			iSeconds = Integer.parseInt(etTimerSeconds.getText().toString());
	        		}
	        		catch(Exception e){
	        			iSeconds = 0;
	        		}
	        		try{
	        			iMinutes = Integer.parseInt(etTimerMinutes.getText().toString());
	        		}
	        		catch(Exception e){
	        			iMinutes = 0;
	        		}
	        		try{
	        			iHour = Integer.parseInt(etTimerHour.getText().toString());
	        		}
	        		catch(Exception e){
	        			iHour = 0;
	        		}
	        		
	        		lTime = (((((iHour*60)+iMinutes)*60)+iSeconds)*1000)+1000;
	        		final MediaPlayer mp = MediaPlayer.create(TimerActivity.this, R.raw.beep);
	        			cdtTimer = new CountDownTimer(lTime, 1000) {
	
	        			     public void onTick(long millisUntilFinished) {
	        			    	 Log.d("TIMERLOG", ""+millisUntilFinished);
	        			    	 tvInfo.setText(formatTime(millisUntilFinished));
	        			    	 //tvInfo.setText("seconds remaining: " + millisUntilFinished / 1000);
	        			    	 mp.start();
	        			     }
	
	        			     @Override
	        			     public void onFinish() {
	        			    	 btnStart.setTextColor(Color.BLACK);
	        			    	 btnStop.setTextColor(Color.GRAY);
	        			    	 btnReset.setTextColor(Color.GRAY);
	        			    	 tvInfo.setText("00 : 00 : 00");
	        			    	 bFlag = true;
	        			     }
	        			  };
	        		if(iHour != 0 || iMinutes != 0 || iSeconds != 0){
	        			cdtTimer.start();
		        		bFlag = false;
		        		btnStart.setTextColor(Color.GRAY);
	        		}	  	 
	        		else{
	        			btnStart.setTextColor(Color.BLACK);
	        			showMsg.instantMessage("Please insert a valid time to CountDown", TimerActivity.this);
	        		}
        		}	
        	}
        } );
		
		btnStop.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		if(bFlag == false){
	        		btnStart.setTextColor(Color.GRAY);
	        		btnStop.setTextColor(Color.GRAY);
	        		btnReset.setTextColor(Color.BLACK);
        		
        			cdtTimer.cancel();
        		}
        			
        	}
        } );
		
		btnReset.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		if(bFlag == false){
		    		btnStart.setTextColor(Color.BLACK);
		    		btnStop.setTextColor(Color.GRAY);
		    		btnReset.setTextColor(Color.GRAY);
		    		
		    		etTimerSeconds.setText("0");
		    		etTimerMinutes.setText("0");
		    		etTimerHour.setText("0");
		    		cdtTimer.cancel();
		    		tvInfo.setText("00 : 00 : 00");
		    		bFlag = true;
        		}	
        	}
        } );
		
		 Button btnBack = (Button) findViewById(R.id.btnBack);
		    btnBack.setOnClickListener(new OnClickListener(){
		        	
		        	@Override 
		        	public void onClick(View v){
		        		TimerActivity.super.onBackPressed();
		        		if(bFlag == false){
		        			cdtTimer.cancel();
		        		}	
		        	}
		        } );
	}
	
	public void onDestroy(){
		super.onDestroy();
	}
	
	public void onPause(){
		super.onPause();
	}
	
	@Override
    public void onBackPressed() {
		TimerActivity.super.onBackPressed();
		if(bFlag == false){
			cdtTimer.cancel();
		}	
	}
	
	int cont = 0;
	public String formatTime(long millis) {
		
		Log.d("FORMATTIME", ""+cont);
	    String output = "00:00:00";  
	    long seconds = millis / 1000;  
	    long minutes = seconds / 60;  
	    long hours = minutes / 60;

	    seconds = seconds % 60;  
	    minutes = minutes % 60;  
	    hours = hours % 60;

	    String sec = String.valueOf(seconds);  
	    String min = String.valueOf(minutes);
	    String hr = String.valueOf(hours);

	    if (seconds < 10)  
	        sec = "0" + seconds;  
	    if (minutes < 10)  
	        min= "0" + minutes;  
	    if(hours < 10)
	    	hr = "0" + hours;

	    output = hr + " : " + min + " : " + sec;
	    cont++;
	    return output;
	}//formatTime  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(TimerActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(TimerActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(TimerActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;		
       
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }
}
