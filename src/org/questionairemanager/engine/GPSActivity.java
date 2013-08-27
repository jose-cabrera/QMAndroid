package org.questionairemanager.engine;

import java.util.Locale;

import org.questionairemanager.engine.utility.LoadingDialog;
import org.questionairemanager.engine.utility.ShowMessage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends Activity implements LocationListener {
	
  ShowMessage showMsg = new ShowMessage();
  private TextView tvLatitude, tvLongitude, tvAltitud, tvBearing, tvSpeed, tvTime, tvNMEAString, tvSatellite, tvAccuracy;
  private Button btnNext;
  private LocationManager locationManager;
  private String provider;
  private Listener listener;
  MenuItem miItem;
  int iTools = 0, gpsSatsAvailable, i= 0;
  private int gps=0;
  int IdOrigin;
  LoadingDialog loader;

  final int iGps_Menu_Item = Menu.FIRST;
  final int iTimer_Menu_Item = iGps_Menu_Item + 1;

  
/**
 * Called when the activity is first created. 
 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email> 
 */

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gps_layout);
    
    tvLatitude = (TextView) findViewById(R.id.tvLatitude);
    tvLongitude = (TextView) findViewById(R.id.tvLongitude);
    tvAltitud = (TextView) findViewById(R.id.tvAltitud);
    tvSpeed = (TextView) findViewById(R.id.tvSpeed);
    tvBearing = (TextView) findViewById(R.id.tvBearing);
    tvTime = (TextView) findViewById(R.id.tvTime);
    tvNMEAString = (TextView) findViewById(R.id.tvNMEAString);
    tvAccuracy = (TextView) findViewById(R.id.tvAccuracy);
    
    loader = new LoadingDialog(this);
                    
    // Get the location manager
    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);    
    // Define the criteria how to select the locatioin provider -> use
    Criteria criteria = new Criteria();
    provider = locationManager.getBestProvider(criteria, false);
    Location location = locationManager.getLastKnownLocation(provider);
    locationManager.addGpsStatusListener(listener);
    //locationManager.addNmeaListener((NmeaListener) this);

    // Initialize the location fields
    if (location != null) {
      System.out.println("Provider " + provider + " has been selected.");
      onLocationChanged(location);
      loader.showSpinnerLoading();
    } else {
    	tvLatitude.setText("Location not available");
		tvLongitude.setText("Location not available");
		tvAltitud.setText("Altitud not available");
		tvBearing.setText("Bearing not available");
		tvSpeed.setText("Speed not available");
		tvBearing.setText("Bearing not available");
	    tvTime.setText("Time not available");
	    tvNMEAString.setText("NMEA not available");
	    tvSatellite.setText("Satellite not available");
	    tvAccuracy.setText("Accuracy not available");
    }
    
    Button btnBack = (Button) findViewById(R.id.btnBack);
    btnBack.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        	    if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
        	    	turnoffGps();
        	    }
        	    else{
        	    	GPSActivity.super.onBackPressed();
        	    }
        		
        	}
        } );
    
    Button btnGetPosition = (Button) findViewById(R.id.btnGetPosition);
    btnGetPosition.setOnClickListener(new OnClickListener(){
        	
        	@Override 
        	public void onClick(View v){
        		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000,10, GPSActivity.this);
        		loader.showSpinnerLoading();
        		tvLatitude.setText("Getting your position");
	 			tvLongitude.setText("Getting your position");
	 			tvAltitud.setText("Getting your Altitud");
	 			tvBearing.setText("Getting your Bearing");
	 			tvSpeed.setText("Getting your Speed");
	 			tvBearing.setText("Getting your Bearing");
	 		    tvTime.setText("Gettint the Fix Time");
	 		    tvNMEAString.setText("Getting NMEA");
	 		    tvSatellite.setText("Getting Satellite");
	 		    tvAccuracy.setText("Getting Accuracy");
	 			if(IdOrigin == 1){
	 				//Guardar valores en DB
	 			}
        	}
        } );
    
    btnNext.setOnClickListener(new OnClickListener(){
    	
    	@Override
    	public void onClick(View v){
    		Intent iIntent = new Intent(GPSActivity.this, QuestionsActivity.class);
    		iIntent.putExtra("IdOriginQuestion", ""+0);
    		startActivity(iIntent);
    	}
    	   
    });
    
    if(gps<2){
        try {
			// get location manager to check gps availability
        	LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000,10, this);
		
			boolean isGPS = locationManager.isProviderEnabled (LocationManager.GPS_PROVIDER); 

			if(!isGPS){
				gps++;
				if(gps<2) turnOnGps();
				else {
					tvLatitude.setText("Location not available");
		 			tvLongitude.setText("Location not available");
		 			tvAltitud.setText("Altitud not available");
		 			tvBearing.setText("Bearing not available");
		 			tvSpeed.setText("Speed not available");
		 			tvBearing.setText("Bearing not available");
		 		    tvTime.setText("Time not available");
		 		    tvNMEAString.setText("NMEA not available");
		 		    tvSatellite.setText("Satellite not available");
		 		    tvAccuracy.setText("Accuracy not available");
		 		}
			}
			else{
				gps=2;	
				tvLatitude.setText("Getting your position");
	 			tvLongitude.setText("Getting your position");
	 			tvAltitud.setText("Getting your Altitud");
	 			tvBearing.setText("Getting your Bearing");
	 			tvSpeed.setText("Getting your Speed");
	 			tvBearing.setText("Getting your Bearing");
	 		    tvTime.setText("Gettint the Fix Time");
	 		    tvNMEAString.setText("Getting NMEA");
	 		    tvSatellite.setText("Getting Satellite");
	 		    tvAccuracy.setText("Getting Accuracy");
			}				
		
	 	} catch (Exception e1) {
	 		gps++;
	 		if(gps<2) turnOnGps();
	 		else {
	 			tvLatitude.setText("Location not available");
	 			tvLongitude.setText("Location not available");
	 			tvAltitud.setText("Altitud not available");
	 			tvBearing.setText("Bearing not available");
	 			tvSpeed.setText("Speed not available");
	 			tvBearing.setText("Bearing not available");
	 		    tvTime.setText("Time not available");
	 		    tvNMEAString.setText("NMEA not available");
	 		    tvSatellite.setText("Satellite not available");
	 		    tvAccuracy.setText("Accuracy not available");
	 		}
		}
    }
 }

  /**
   * It tell Android what to do when Menu is created, and Inflates the main_menu.xml
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gps_menu, menu);
		return true;
	}
	
  //handle menu item selection
  /**
   * Get the item from the menu selected and perform an Action
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  public boolean onOptionsItemSelected(MenuItem miItem){
  	
  	switch (miItem.getItemId()) {
       
      case R.id.menu_timer:
      	Intent iIntentTimer = new Intent(GPSActivity.this, TimerActivity.class);
  		startActivity(iIntentTimer);
  		return true;
  		
      case R.id.menu_barcodereader:
      	Intent iIntentBarCode = new Intent(GPSActivity.this, BarCodeReaderActivity.class);
      	iIntentBarCode.putExtra("IdOrigin", 0);
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
      	Intent iIntentReport = new Intent(GPSActivity.this, ReportsActivity.class);
  		startActivity(iIntentReport);
      	return true;		
     
      default:
      	return super.onOptionsItemSelected(miItem);
       
      }
  }
  /* Request updates at startup */
  /**
   * When on Resume event fires, get Location Updates
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  protected void onResume() {
    super.onResume();
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000,10, this);
  }

  /**
   * When on Pause event fires, it pauses the location Manager, so it dosn't get updates
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  protected void onPause() {
	  super.onPause();
	  locationManager.removeUpdates(this);
  }
  
  /**
   * When on Destroy event Fires, it pauses the location Manager, so it dosn't get updates 
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  protected void onDestroy(){
	  super.onDestroy();
	  locationManager.removeUpdates(this);
  }
  
  /**
   * When the hardware or digital Back Button is Pressed, it Checks if GPS provider is on, and turn it off, or just exit.
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  public void onBackPressed() {
	  final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

	    if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
	    	turnoffGps();
	    }
	    else{
	    	GPSActivity.super.onBackPressed();
	    }
  }
  
	public void getNMEA() {
		// gpsSatsAvailable = 0;
		locationManager.addNmeaListener(new NmeaListener() {

			public void onNmeaReceived(long timestamp, String nmea) {
				Log.d("NMEA", "nmea is: " + (nmea += nmea));
				tvNMEAString.setText(nmea);
				if (nmea.toUpperCase().contains("$GNGSA")
						|| nmea.toUpperCase().contains("$GPGSA")) {
					gpsSatsAvailable = gpsSatsAvailable + 1;
				}
			}
		});

	}
  
  /**
   * Listen to the location Change event from the Location Manager, and gets the GPS Info, and paint it on the Screen
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  public void onLocationChanged(Location location) {
	  	getNMEA();
//	  	updateSats();
	  	
	    float lat = (float) (location.getLatitude());
	    float lng = (float) (location.getLongitude());
	    double alt = (double) (location.getAltitude());
	    float bearing = (float) (location.getBearing());
	    float speed = (float) (location.getSpeed());
	    long time = (long) (location.getTime());	
	    
	    if(location.hasAccuracy()){
	    	tvAccuracy.setText(location.getAccuracy()+" meters"); 
	    }
	    else{
	    	tvAccuracy.setText("No Accuracy");
	    }
  	    
	    tvLatitude.setText(String.valueOf(lat));
	    tvLongitude.setText(String.valueOf(lng));
	    tvAltitud.setText(String.valueOf(alt));
	    tvBearing.setText(String.valueOf(bearing));
	    tvSpeed.setText(String.valueOf(speed));
	    tvTime.setText(String.valueOf(time));
	    tvSatellite.setText(String.valueOf(gpsSatsAvailable));	    
	    gpsSatsAvailable = 0;
	    loader.stopSpinnerLoading();
  }
  
  public void onNmeaReceived(long timestamp, String nmea) 
  {	      
	      tvNMEAString.setText(nmea);	
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
    // TODO Auto-generated method stub

  }

  /**
   * When the GPS Provider is Enabled it triggers this method
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  public void onProviderEnabled(String provider) {
    Toast.makeText(this, "Enabled new provider " + provider,
        Toast.LENGTH_SHORT).show();
  }
  /**
   * When the GPS Provider is disabled it triggers this method
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  @Override
  public void onProviderDisabled(String provider) {
    Toast.makeText(this, "Disabled provider " + provider,
        Toast.LENGTH_SHORT).show();
  }
  /**
   * Creates a Dialog that tell the user to Turn on the GPS provider. 
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  public void turnOnGps(){
		final Dialog dialog=new Dialog(this);
  	dialog.setContentView(R.layout.turnongps_dialog_layout);
  	dialog.setTitle("GPS");
  	dialog.setCancelable(false);
  	dialog.show();
  	
  	Button gpsSettings = (Button) dialog.findViewById(R.id.btnTurnOnGps);
  	gpsSettings.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				dialog.dismiss();
				startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
			}
		});
		
  	Button gpsCancel = (Button) dialog.findViewById(R.id.btnCancelGps);
  	gpsCancel.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}

  /**
   * Creates a Dialog that tell the user to Turn off the GPS provider. 
   * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
   */
  public void turnoffGps(){
		final Dialog dialog=new Dialog(this);
  	dialog.setContentView(R.layout.turnoffgps_dialog_layout);
  	dialog.setTitle("GPS");
  	dialog.setCancelable(false);
  	dialog.show();
  	
  	Button gpsSettings = (Button) dialog.findViewById(R.id.btnTurnOffGps);
  	gpsSettings.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				dialog.dismiss();
				startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
				finish();
			}
		});
		
  	Button gpsCancel = (Button) dialog.findViewById(R.id.btnCancelGps);
  	gpsCancel.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
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
