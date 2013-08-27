package org.questionairemanager.engine.utility;

import org.questionairemanager.engine.R;

import com.google.zxing.integration.android.IntentIntegrator;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ScreenManager extends Activity implements OnClickListener,
		LocationListener {

	public static final String COMBOBOX = "combobox";
	public static final String CHECKBOX = "checkbox";
	public static final String TEXTBOX = "textbox";
	public static final String TEXTAREA = "textarea";
	public static final String GPS = "gps";
	public static final String BARCODEREADER = "barcodereader";
	public static final String DATE = "date";
	public static final String TIME = "time";
	public static final String DATETIME = "datetime";
	public static final String NUMBERINPUT = "numberinput";
	public static final String DECIMALNUMBERINPUT = "decimalnumberinput";
	public static final String PHONEINPUT = "phoneinput";
	public static final String RADIOBUTTONS = "radiobuttons";
	public static final String INFOSCREEN = "infoscreen";
	public static final String SEPARATORCARACTER = "&";

	String sTypeNode = null;
	String sScreenTemplate = null;
	ShowMessage showMsg = new ShowMessage();
	InfoSharedPreferences ispPageInfo = new InfoSharedPreferences();
	LoadingDialog loader;
	TurnOnOffGPS turnOnOffGps;

	ScreenMaker smScreen;
	LayoutInflater mInflater;

	Context ctx;
	Activity activity;

	private String sActualidad;
	private String[] sLegalValues;
	private int count;

	/**
	 * GPS ITEMS
	 */
	private LocationManager locationManager;
	private String provider, sLatitude, sLongitude, sAltitude, sAccuracy,
			sNMEA;
	private Listener listener;
	private boolean bGPSBandera;

	/**
	 * GENERAL ITEM
	 */
	View view, returnView;
	Button btnNext, btnBack, btnHelp;
	TextView tvStudyNameLong;
	TextView tvStudyNameShort;
	TextView tvPageInfo, tvSubject, tvQuestionNumber;
	String sHelpText;

	/**
	 * GPS ITEMS
	 */
	Button btnGetPosition;

	/**
	 * BAR CODE SCANNER ITEMS
	 */
	public String sScanContent;
	public String sScanFormat;
	Button btnScan;
	TextView tvFormat, tvContent, tvQuestionBarCodeReader;

	public ScreenManager(Context ctx) {
		this.ctx = ctx;
		activity = (Activity) ctx;
		locationManager = (LocationManager) ctx
				.getSystemService(Context.LOCATION_SERVICE);
		mInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		turnOnOffGps = new TurnOnOffGPS(ctx);
		loader = new LoadingDialog(ctx);
	}

	/**
	 * drawScreen dinamically
	 * 
	 * @param id
	 *            Get it from Constants for the one you need
	 * @param legalValues
	 *            used when the Question has multiple answers like in Checkbox,
	 *            combobox, radiobuttons
	 * @param MainText
	 *            used to set the main text
	 * @param HelpText
	 *            used to set the Help Text
	 */
	public View drawScreen(String id, String[] legalValues, String[] MainText,
			String[] HelpText, String[] Answered, int[] AnsweredIndex) {

		count = 0;
		this.sActualidad = id;
		smScreen = new ScreenMaker(ctx);
		sLegalValues = legalValues;

		/**
		 * INFO SCREEN
		 */
		if (INFOSCREEN.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION COMBOBOX SCREEN
		 */
		if (COMBOBOX.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			if (legalValues != null) {
				smScreen.ComboBox(legalValues, AnsweredIndex);
			}

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION CHECKBOX SCREEN
		 */
		if (CHECKBOX.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					Log.d("MAINTEXT", MainText[i].toString());
					String maintext = MainText[i];
					smScreen.Text(maintext);
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			if (legalValues != null) {
				smScreen.CheckBox(legalValues, AnsweredIndex);
			}

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION TEXTBOX SCREEN
		 */
		if (TEXTBOX.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}
			smScreen.TextInput(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION TEXTAREA SCREEN
		 */
		if (TEXTAREA.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}
			smScreen.TextArea(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION DATE SCREEN
		 */
		if (DATE.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}
			smScreen.DatePicker(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION TIME SCREEN
		 */
		if (TIME.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			smScreen.TimePicker(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION DATE AND TIME SCREEN
		 */
		if (DATETIME.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			smScreen.DateTimePicker(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION NUMBER INPUT SCREEN
		 */
		if (NUMBERINPUT.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			smScreen.NumberInput(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION DECIMAL NUMBER INPUT SCREEN
		 */
		if (DECIMALNUMBERINPUT.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			smScreen.DecimalNumberInput(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION PHONEINPUT SCREEN
		 */
		if (PHONEINPUT.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			smScreen.PhoneInput(Answered);

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION RADIO BUTTONS SCREEN
		 */
		if (RADIOBUTTONS.equalsIgnoreCase(id)) {
			smScreen.CleanScreen();

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			if (legalValues != null) {
				smScreen.RadioButtons(legalValues, AnsweredIndex);
			}

			view = mInflater.inflate(R.layout.questions_layout, null);

			returnView = smScreen.MakeScreen();

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * QUESTION GPS
		 */
		if (GPS.equalsIgnoreCase(id)) {

			// Define the criteria how to select the locatioin provider ->
			// use
			Criteria criteria = new Criteria();
			provider = locationManager.getBestProvider(criteria, false);
			final Location location = locationManager
					.getLastKnownLocation(provider);
			locationManager.addGpsStatusListener(listener);

			smScreen.CleanScreen();

			smScreen.Text(activity
					.getString(R.string.global_positioning_system));

			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			if (Answered == null) {				
					smScreen.TextViewLatitude(activity
							.getString(R.string.press_get_position));
					smScreen.TextViewLongitude(activity
							.getString(R.string.press_get_position));
					smScreen.TextViewAltitude(activity
							.getString(R.string.press_get_position));
					smScreen.TextViewAccuraccy(activity
							.getString(R.string.press_get_position));
				
			} else {
				smScreen.TextViewLatitude(Answered[0].toString());
				smScreen.TextViewLongitude(Answered[1].toString());
				smScreen.TextViewAltitude(Answered[2].toString());
				smScreen.TextViewAccuraccy(Answered[3].toString());
			}

			smScreen.EmptySapce(10);

			smScreen.GPSGetPositionButton();
			
			smScreen.EmptySapce(20);

			returnView = smScreen.MakeScreen();

			btnGetPosition = smScreen.getGPSButton();
			btnGetPosition.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					loader.showSpinnerLoading();
					final LocationManager manager = (LocationManager) activity
							.getSystemService(Context.LOCATION_SERVICE);

					if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
						
							locationManager.requestLocationUpdates(
									LocationManager.GPS_PROVIDER, 30000, 10,
									ScreenManager.this);

							loader.showSpinnerLoading();
							smScreen.getTextViewLatitude()
									.setText(
											activity.getString(R.string.getting_your_position));
							smScreen.getTextViewLongitude()
									.setText(
											activity.getString(R.string.getting_your_position));
							smScreen.getTextViewAltitude()
									.setText(
											activity.getString(R.string.getting_your_altitud));
							smScreen.getTextViewAccuraccy()
									.setText(
											activity.getString(R.string.getting_accuracy));				

					} else {
						turnOnOffGps.turnOnGps();
						
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER, 30000, 10,
								ScreenManager.this);

						loader.showSpinnerLoading();
						smScreen.getTextViewLatitude()
								.setText(
										activity.getString(R.string.getting_your_position));
						smScreen.getTextViewLongitude()
								.setText(
										activity.getString(R.string.getting_your_position));
						smScreen.getTextViewAltitude()
								.setText(
										activity.getString(R.string.getting_your_altitud));
						smScreen.getTextViewAccuraccy()
								.setText(
										activity.getString(R.string.getting_accuracy));
					}
				}
			});

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}

		/**
		 * UTILITY BARCODE READER SCREEN
		 */
		if (BARCODEREADER.equalsIgnoreCase(id)) {

			smScreen.CleanScreen();

			smScreen.Text(activity.getString(R.string.bar_code_reader));
			if (MainText != null) {
				for (int i = 0; i < MainText.length; i++) {
					smScreen.Text(MainText[i].toString());
				}
				smScreen.EmptySapce(20);
			}

			if (HelpText != null) {
				for (int i = 0; i < HelpText.length; i++) {
					sHelpText = (HelpText[i].toString());
				}
			}

			if (Answered != null) {
				smScreen.TextContent(Answered[0].toString());
				smScreen.TextFormat(Answered[1].toString());
			} else {
				smScreen.TextContent(activity.getString(R.string.content));
				smScreen.TextFormat(activity.getString(R.string.format));
			}

			smScreen.EmptySapce(10);

			smScreen.ScanButton();

			returnView = smScreen.MakeScreen();

			btnScan = smScreen.getButtonScanBarCode();
			btnScan.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					IntentIntegrator scanIntegrator = new IntentIntegrator(
							activity);
					scanIntegrator.initiateScan();
				}
			});

			tvPageInfo = (TextView) activity.findViewById(R.id.tvPageInfo);
			tvSubject = (TextView) activity.findViewById(R.id.tvSubjectNumber);
			tvQuestionNumber = (TextView) activity
					.findViewById(R.id.tvPageNumber);

			tvPageInfo.setText(ispPageInfo.getACTUALSTUDIE() + "-"
					+ ispPageInfo.getACTUALQUESTIONNARIE());
			tvSubject.setText(ispPageInfo.getACTUALSUBJECT());
			tvQuestionNumber.setText(ispPageInfo.getACTUALQUESTION());
			count = 1;
			tvQuestionNumber.setOnClickListener(this);

			btnHelp = (Button) activity.findViewById(R.id.btnHelp);
			btnHelp.setOnClickListener(this);

			btnNext = (Button) activity.findViewById(R.id.btnNext);
			btnBack = (Button) activity.findViewById(R.id.btnBack);
		}
		return returnView;
	}

	public String getActualId() {
		return this.sActualidad;
	}

	public String getAnswer() {
		String sAnswer = null;
		String id = this.sActualidad;

		/**
		 * QUESTION COMBOBOX
		 */
		if (COMBOBOX.equalsIgnoreCase(id)) {
			Spinner spinner = smScreen.getComboBoxValue();
			sAnswer = (String) spinner.getSelectedItem();
		}

		/**
		 * QUESTION CHECKBOX SCREEN
		 */
		if (CHECKBOX.equalsIgnoreCase(id)) {
			// NOT SURE HOW TO MAKE THE GET
		}

		/**
		 * QUESTION TEXTBOX SCREEN
		 */
		if (TEXTBOX.equalsIgnoreCase(id)) {
			EditText edittext = smScreen.getTextInputValue();
			sAnswer = edittext.getText().toString();
		}

		/**
		 * QUESTION TEXTAREA SCREEN
		 */
		if (TEXTAREA.equalsIgnoreCase(id)) {
			EditText edittext = smScreen.getTextAreaValue();
			sAnswer = edittext.getText().toString();
		}

		/**
		 * QUESTION DATE SCREEN Return format
		 * 
		 * @return position 0 = Year
		 * @return position 1 = Month
		 * @return position 2 = Day All separated by the SEPARATORCARACTER = &
		 */
		if (DATE.equalsIgnoreCase(id)) {
			DatePicker datepicker = smScreen.getDatePickerValue();
			int iDay = datepicker.getDayOfMonth();
			int iMonth = datepicker.getMonth();
			int iYear = datepicker.getYear();

			sAnswer = iYear + " - " + (iMonth + 1) + " - " + iDay;
		}

		/**
		 * QUESTION TIME SCREEN Return format
		 * 
		 * @return position 0 = Hours
		 * @retrun positon 1 = Minutes All separated by the SEPARATORCARACTER =
		 *         &
		 */
		if (TIME.equalsIgnoreCase(id)) {
			TimePicker timepicker = smScreen.getTimeInputValue();

			int iHour = timepicker.getCurrentHour();
			int iMinute = timepicker.getCurrentMinute();

			sAnswer = iHour + " : " + iMinute;
		}

		/**
		 * QUESTION DATE AND TIME SCREEN Return format
		 * 
		 * @return position 0 = Year
		 * @return position 1 = Month
		 * @return position 2 = Day
		 * @return position 3 = Hours
		 * @retrun positon 4 = Minutes All separated by the SEPARATORCARACTER =
		 *         &
		 */
		if (DATETIME.equalsIgnoreCase(id)) {
			DatePicker datepicker = smScreen.getDateTimeValueDATE();
			int iDay = datepicker.getDayOfMonth();
			int iMonth = datepicker.getMonth();
			int iYear = datepicker.getYear();

			TimePicker timepicker = smScreen.getDateTimeValueTIME();
			int iHour = timepicker.getCurrentHour();
			int iMinute = timepicker.getCurrentMinute();

			sAnswer = iYear + SEPARATORCARACTER + (iMonth + 1)
					+ SEPARATORCARACTER + iDay + SEPARATORCARACTER + iHour
					+ SEPARATORCARACTER + iMinute;
		}

		/**
		 * QUESTION NUMBER INPUT SCREEN
		 */
		if (NUMBERINPUT.equalsIgnoreCase(id)) {
			EditText edittext = smScreen.getNumberInputValue();

			sAnswer = edittext.getText().toString();
		}

		/**
		 * QUESTION DECIMAL NUMBER INPUT SCREEN
		 */
		if (DECIMALNUMBERINPUT.equalsIgnoreCase(id)) {
			EditText edittext = smScreen.getDecimalNumberInputValue();

			sAnswer = edittext.getText().toString();
		}

		/**
		 * QUESTION PHONEINPUT SCREEN
		 */
		if (PHONEINPUT.equalsIgnoreCase(id)) {
			EditText edittext = smScreen.getPhoneInputValue();

			sAnswer = edittext.getText().toString();
		}

		/**
		 * QUESTION RADIO BUTTONS SCREEN
		 * 
		 * @return the id of the RadioButton Selected
		 */
		if (RADIOBUTTONS.equalsIgnoreCase(id)) {
			RadioGroup radiogroup = smScreen.getRadioButtonsValue();

			int iCheckedRadioButtonId = radiogroup.getCheckedRadioButtonId();
			View radioButton = radiogroup.findViewById(iCheckedRadioButtonId);
			int idx = radiogroup.indexOfChild(radioButton);

			sAnswer = "" + idx;

		}

		/**
		 * QUESTION GPS Return Format:
		 * 
		 * @return position 0 = latitud
		 * @return position 1 = longitud
		 * @return position 2 = altitud
		 * @return position 3 = accuracy
		 * @return position 4 = NMEAString All separated by the
		 *         SEPARATORCARACTER = &
		 */
		if (GPS.equalsIgnoreCase(id)) {
			sAnswer = sLatitude + SEPARATORCARACTER + sLongitude
					+ SEPARATORCARACTER + sAltitude + SEPARATORCARACTER
					+ sAccuracy + SEPARATORCARACTER + sNMEA;
		}

		/**
		 * UTILITY BARCODE READER SCREEN Return format
		 * 
		 * @return position 0 = ScanContent the code retrieve from the BarCode
		 * @return position 1 = ScanFromat the type of BarCode All separated by
		 *         the SEPARATORCARACTER = &
		 */
		if (BARCODEREADER.equalsIgnoreCase(id)) {
			sAnswer = this.sScanContent + SEPARATORCARACTER + this.sScanFormat;
		}

		return sAnswer;
	}

	public Button getNextButton() {
		return btnNext;
	}

	public Button getBackButton() {
		return btnBack;
	}

	public void setScanContent(String content) {
		this.sScanContent = content;

		smScreen.getTextViewContentBarCode().setText(content);
	}

	public void setScanFormat(String format) {
		this.sScanFormat = format;

		smScreen.getTextViewFormatBarCode().setText(format);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnHelp:
			showMsg.longInstantMessage(sHelpText, ctx);
			break;

		case R.id.tvPageNumber:
			if ((count % 2) == 0) {
				TextView textview = (TextView) v
						.findViewById(R.id.tvPageNumber);
				textview.setText(ispPageInfo.getACTUALQUESTION());
				count++;
			} else {
				TextView textview = (TextView) v
						.findViewById(R.id.tvPageNumber);
				textview.setText(ispPageInfo.getACTUALQUESTIONNUMBER());
				count++;
			}
			break;
		}

	}

	@Override
	public void onLocationChanged(Location location) {
		getNMEA();

		float lat = (float) (location.getLatitude());
		float lng = (float) (location.getLongitude());
		double alt = (double) (location.getAltitude());

		try{
			smScreen.getTextViewLatitude().setText(
					activity.getString(R.string.latitude_) + " "
							+ (String.valueOf(lat)));
			sLatitude = String.valueOf(lat);
			smScreen.getTextViewLongitude().setText(
					activity.getString(R.string.longitude_) + " "
							+ (String.valueOf(lng)));
			sLongitude = String.valueOf(lng);
			smScreen.getTextViewAltitude().setText(
					activity.getString(R.string.altitud_) + " "
							+ (String.valueOf(alt)));
			sAltitude = String.valueOf(alt);

			if (location.hasAccuracy()) {
				smScreen.getTextViewAccuraccy().setText(
						activity.getString(R.string.accuracy_) + " "
								+ (location.getAccuracy() + R.string._meters));
				sAccuracy = (location.getAccuracy() + activity
						.getString(R.string._meters));
			} else {
				smScreen.getTextViewAccuraccy().setText(
						activity.getString(R.string.no_accuracy));
				sAccuracy = activity.getString(R.string.no_accuracy);
			}
		}
		catch(Exception e){
			Log.d("GPS EXCEPTION", ""+e);
		}
		
		loader.stopSpinnerLoading();

	}

	public void getNMEA() {
		sNMEA = "";
		locationManager.addNmeaListener(new NmeaListener() {

			public void onNmeaReceived(long timestamp, String nmea) {
				Log.d("NMEA", "nmea is: " + (nmea += nmea));
				sNMEA += nmea;		
//				smScreen.getTextViewNMEA().setText(
//						activity.getString(R.string.nmea) + " " + (sNMEA));				
			}
		});	
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}