package org.questionnairemanager.engine.utility;

import org.questionairemanager.engine.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TurnOnOffGPS extends Activity{
	
	Context ctx;
	Activity activity;
	
	public TurnOnOffGPS(Context ctx){
		this.ctx = ctx;
		activity = (Activity) ctx;
	}
	/**
	 * Creates a Dialog that tell the user to Turn on the GPS provider.
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void turnOnGps() {
		final Dialog dialog = new Dialog(ctx);
		dialog.setContentView(R.layout.turnongps_dialog_layout);
		dialog.setTitle("GPS");
		dialog.setCancelable(false);
		dialog.show();

		Button gpsSettings = (Button) dialog.findViewById(R.id.btnTurnOnGps);
		gpsSettings.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
				activity.startActivity(
						new Intent(
								android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
				
			}
		});

		Button gpsCancel = (Button) dialog.findViewById(R.id.btnCancelGps);
		gpsCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();//CHANGE WHAT YOU WANT TO DO WHEN CANCEL BUTTON IS PRESSED
			}
		});
	}

	/**
	 * Creates a Dialog that tell the user to Turn off the GPS provider.
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void turnoffGps() {
		final Dialog dialog = new Dialog(ctx);
		dialog.setContentView(R.layout.turnoffgps_dialog_layout);
		dialog.setTitle("GPS");
		dialog.setCancelable(false);
		dialog.show();

		Button gpsSettings = (Button) dialog.findViewById(R.id.btnTurnOffGps);
		gpsSettings.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
				activity.startActivity(
						new Intent(
								android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
			}
		});

		Button gpsCancel = (Button) dialog.findViewById(R.id.btnCancelGps);
		gpsCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();//CHANGE WHAT YOU WANT TO DO WHEN CANCEL BUTTON IS PRESSED
			}
		});
	}
}
