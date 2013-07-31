package org.questionairemanager.engine;

import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BarCodeReaderActivity extends Activity implements OnClickListener{

	ShowMessage showMsg = new ShowMessage();
	MenuItem miItem;
	int iTools = 0;
	int IdOrigin;

	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	private Button btnScan, btnNext;
	private TextView tvFormat, tvContent, tvQuestionBarCodeReader; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bar_code_reader_layout);
		
		btnScan = (Button) findViewById(R.id.btnScan);
		btnScan.setOnClickListener(this);
		tvFormat = (TextView) findViewById(R.id.tvScan_format);
		tvContent = (TextView) findViewById(R.id.tvScan_content);
		tvQuestionBarCodeReader = (TextView) findViewById(R.id.tvQuestionBarCodeReader);
		btnNext = (Button) findViewById(R.id.btnNext);
		
		 IdOrigin = Integer.parseInt(getIntent().getExtras().getString("IdOrigin"));
		    if(IdOrigin == 1){
		    	btnNext.setVisibility(View.VISIBLE);
		    	tvQuestionBarCodeReader.setText("Please tap scan to begin BarCode Reader");
		    	
		    }
		    if(IdOrigin == 0){
		    	btnNext.setVisibility(View.INVISIBLE);
		    	tvQuestionBarCodeReader.setText("");
		    }
		    
	    btnNext.setOnClickListener(new OnClickListener(){
	    	
	    	@Override
	    	public void onClick(View v){
	    		Intent iIntent = new Intent(BarCodeReaderActivity.this, QuestionsActivity.class);
	    		iIntent.putExtra("IdOriginQuestion", ""+1);
	    		startActivity(iIntent);
	    	}
	    	   
	    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.bar_code_reader, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(BarCodeReaderActivity.this, GPSActivity.class);
        	iIntent.putExtra("IdOrigin", ""+0);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(BarCodeReaderActivity.this, TimerActivity.class);
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
        	
        case R.id.menu_reports:
        	Intent iIntentReport = new Intent(BarCodeReaderActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;
       
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btnScan){
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			String sScanContent = scanningResult.getContents();
			String sScanFormat = scanningResult.getFormatName();
			
			tvFormat.setText("FORMAT "+sScanFormat);
			tvContent.setText("CONTENT "+sScanContent);
		}
		else{
		    showMsg.instantMessage( "No scan data received!", this);
		}
	}
}
