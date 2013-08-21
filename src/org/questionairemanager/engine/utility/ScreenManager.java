package org.questionairemanager.engine.utility;

import java.util.ArrayList;

import org.questionairemanager.engine.R;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class ScreenManager implements OnClickListener {

	public static final String COMBOBOX = "combobox";
	public static final String CHECKBOX = "checkbox";
	public static final String TEXTBOX = "textbox";
	public static final String TEXTAREA = "textarea";
	public static final String GPS = "gps";
	public static final String BARCODEREADER = "barcodereader";
	public static final String TIMER = "timer";
	public static final String DATE = "date";
	public static final String TIME = "time";
	public static final String DATETIME = "datetime";
	public static final String NUMBERINPUT = "numberinput";
	public static final String DECIMALNUMBERINPUT = "decimalnumberinput";
	public static final String PHONEINPUT = "phoneinput";
	public static final String RADIOBUTTONS = "radiobuttons";
	public static final String STUDIES = "studies";
	public static final String QUESTIONNARIES = "questionnaries";
	public static final String SUBJECTS = "subjects";
	public static final String EDITSUBJECT = "editsubject";
	public static final String ADDSUBJECT = "addsubject";
	public static final String REPORTS = "reports";
	public static final String REPORTSDATA = "reportsdata";
	public static final String WELCOME = "welcome";
	public static final String INTERVIEWER = "interviewer";
	public static final String SEPARATORCARACTER = "@&";

	String sTypeNode = null;
	String sScreenTemplate = null;
	ShowMessage showMsg = new ShowMessage();

	ScreenMaker smScreen;
	LayoutInflater mInflater;

	Context ctx;
	Activity activity;

	private String sActualidad;		

	/**
	 * GENERAL ITEM
	 */
	View view;
	Button btnNext, btnBack;
	TextView tvStudyNameLong;
	TextView tvStudyNameShort;

	/**
	 * WELCOME ITEMS
	 */
	CountDownTimer cdtTimer, cdtTimer2;
	LoadingDialog loader;
	Boolean bBandera = false;
	RelativeLayout rlLayout;

	/**
	 * STUDIES ITEMS
	 */
	Spinner sStudie;
	Button btnLogIn;
	Button btnExit;

	/**
	 * INTERVIEWER ITEMS
	 */
	Spinner sCode;

	/**
	 * SUBJECT ITEMS
	 */
	RadioGroup rgSubjects;
	int iSubjectRadioButtonIndex;

	/**
	 * ADD SUBJECT ITEMS
	 */
	EditText etSaSubjectId;

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
		mInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void drawSettings() {
		// Aca colocarian todas las configuraciones ini
	}

	public void drawScreen(String id, String[] legalValues, String[] MainText, String[] HelpText) {

		this.sActualidad = id;
		smScreen = new ScreenMaker(ctx);

		/**
		 * QUESTION COMBOBOX SCREEN
		 */
		if (COMBOBOX.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			// smScreen.ComboBox(legalValues);

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION CHECKBOX SCREEN
		 */
		if (CHECKBOX.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			// smScreen.CheckBox(legalValues);

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION TEXTBOX SCREEN
		 */
		if (TEXTBOX.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.TextInput();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION TEXTAREA SCREEN
		 */
		if (TEXTAREA.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.TextArea();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION GPS
		 */
		if (GPS.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.gps_layout);

			view = mInflater.inflate(R.layout.gps_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * QUESTION DATE SCREEN
		 */
		if (DATE.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.DatePicker();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION TIME SCREEN
		 */
		if (TIME.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.TimePicker();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION DATE AND TIME SCREEN
		 */
		if (DATETIME.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.DateTimePicker();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION NUMBER INPUT SCREEN
		 */
		if (NUMBERINPUT.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.NumberInput();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION DECIMAL NUMBER INPUT SCREEN
		 */
		if (DECIMALNUMBERINPUT.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.DecimalNumberInput();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION PHONEINPUT SCREEN
		 */
		if (PHONEINPUT.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			smScreen.PhoneInput();

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * QUESTION RADIO BUTTONS SCREEN
		 */
		if (RADIOBUTTONS.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questions_layout);
			smScreen.CleanScreen();
			// smScreen.Text(legalValues);
			smScreen.EmptySapce(20);
			// smScreen.RadioButtons(legalValues);

			view = mInflater.inflate(R.layout.questions_layout, null);

			LinearLayout llQuestion = (LinearLayout) view
					.findViewById(R.id.llQuestionsLayout);
			llQuestion.removeAllViewsInLayout();
			llQuestion.addView(smScreen.MakeScreen());
		}

		/**
		 * UTILITY BARCODE READER SCREEN
		 */
		if (BARCODEREADER.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.bar_code_reader_layout);

			view = mInflater.inflate(R.layout.bar_code_reader_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);

			btnScan = (Button) view.findViewById(R.id.btnScan);
			tvFormat = (TextView) view.findViewById(R.id.tvScan_format);
			tvContent = (TextView) view.findViewById(R.id.tvScan_content);
			tvQuestionBarCodeReader = (TextView) view
					.findViewById(R.id.tvQuestionBarCodeReader);
			btnNext = (Button) view.findViewById(R.id.btnNext);

			tvQuestionBarCodeReader
					.setText("Please tap scan to begin BarCode Reader");

			btnScan.setOnClickListener(this);
			btnNext.setOnClickListener(this);
		}

		/**
		 * UTILITY TIMER SCREEN
		 */
		if (TIMER.equalsIgnoreCase(id)) {

			activity.setContentView(R.layout.timer_layout);

			view = mInflater.inflate(R.layout.timer_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);

		}

		/**
		 * SELECTION STRUDIES SCREEN
		 */
		if (STUDIES.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.studies_layout);

			view = mInflater.inflate(R.layout.studies_layout, null);

			btnLogIn = (Button) view.findViewById(R.id.btnLogIn);
			btnExit = (Button) view.findViewById(R.id.btnExit);

			sStudie = (Spinner) view.findViewById(R.id.sStudie);

		}

		/**
		 * SELECTION QUESTIONNARIE GRUOUPS AND QUESTIONNARIE SCREEN
		 */
		if (QUESTIONNARIES.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.questionaries_layout);
		}

		/**
		 * SELECTION LOGIN FOR THE INTERVIEWER SCREEN
		 */
		if (INTERVIEWER.equalsIgnoreCase(id)) {

			activity.setContentView(R.layout.interviewer_layout);

			view = mInflater.inflate(R.layout.interviewer_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);

			sCode = (Spinner) view.findViewById(R.id.sCode);

		}

		/**
		 * SELECTION EDIT OR ADD SUBJECT SCREEN
		 */
		if (SUBJECTS.equalsIgnoreCase(id)) {

			activity.setContentView(R.layout.subject_layout);

			view = mInflater.inflate(R.layout.subject_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);

			etSaSubjectId = (EditText) view.findViewById(R.id.etSaSubjectId);

			btnNext = (Button) view.findViewById(R.id.btnNextasa);
			btnBack = (Button) view.findViewById(R.id.btnBack);
		}

		/**
		 * EDIT A EXISTING SUBJECT SCREEN
		 */
		if (EDITSUBJECT.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.edit_subject_layout);

			view = mInflater.inflate(R.layout.edit_subject_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * ADD A NEW SUBJECT SCREEN
		 */
		if (ADDSUBJECT.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.add_subject_layout);

			view = mInflater.inflate(R.layout.add_subject_layout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * SELECTION SELECT REPORT TO SHOW SCREEN
		 */
		if (REPORTS.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.report_layaout);

			view = mInflater.inflate(R.layout.report_layaout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * GRID TABLE LAYOUT FOR DATA FROM QUERY REPORTS SCREEN
		 */
		if (REPORTSDATA.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.reportdata_layout);

			view = mInflater.inflate(R.layout.report_layaout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * WELCOME SCREEN
		 */
		if (WELCOME.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.welcome_layout);

			view = mInflater.inflate(R.layout.welcome_layout, null);

			rlLayout = (RelativeLayout) view.findViewById(R.id.rlWelcomeLayout);
			rlLayout.setOnClickListener(this);

			loader = new LoadingDialog(ctx);

			cdtTimer2 = new CountDownTimer(5000, 1000) {

				public void onTick(long millisUntilFinished) {

				}

				@Override
				public void onFinish() {
					if (bBandera == false) {
						String msg = ctx
								.getString(R.string.tap_the_screen_to_begin_qm);
						showMsg.longInstantMessage(msg, ctx);
					}
				}
			}.start();
		}
	}

	public String getActualId() {
		return this.sActualidad;
	}

	/**
	 * OBTAIN THE EDITTEXT FROM LOGIN SCREEN (INTERVIEWER SELECTION SCREEN) THAT
	 * HAS THE INTERVIEWER PASSWORD
	 * 
	 * @return OBJECT EDITTEXT
	 */
	public EditText getInterviewerPassword() {

		view = mInflater.inflate(R.layout.interviewer_layout, null);

		EditText edittext;
		edittext = (EditText) view.findViewById(R.id.etPassword);

		return edittext;
	}

	public int getSubjectRadioButton() {
		return iSubjectRadioButtonIndex;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btnNext:
			// SEND NEXT EVENT
			break;

		case R.id.btnBack:
			// SEND BACK EVENT
			break;

		case R.id.btnLogIn:
			// SEND NEXT EVENT
			break;

		case R.id.btnExit:
			// EXIT APLICATION
			break;

		case R.id.rlWelcomeLayout:
			bBandera = true;
			loader.showSpinnerLoading();
			// SEND NEXT EVENT
			break;

		case R.id.btnNextasa:
			view = mInflater.inflate(R.layout.subject_layout, null);

			rgSubjects = (RadioGroup) view.findViewById(R.id.rgSubjects);
			int iCheckedRadioButtonId = rgSubjects.getCheckedRadioButtonId();
			View radioButton = rgSubjects.findViewById(iCheckedRadioButtonId);
			int idx = rgSubjects.indexOfChild(radioButton);

			if (idx == 0) {// ADD NEW SUBJECT
				// SEND NEXT EVENT
				iSubjectRadioButtonIndex = 0;
			}
			if (idx == 1) {// EDIT A EXISTING SUBJECT
				// SEND NEXT EVENT
				iSubjectRadioButtonIndex = 1;
			}
			break;

		case R.id.btnScan:
			IntentIntegrator scanIntegrator = new IntentIntegrator(
					(Activity) ctx);
			scanIntegrator.initiateScan();
			break;

		}

	}
	
	public String getAnswer(){
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
			//NOT SURE HOW TO MAKE THE GET
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
		 * QUESTION GPS
		 */
		if (GPS.equalsIgnoreCase(id)) {
			
			view = mInflater.inflate(R.layout.gps_layout, null);

			
		}

		/**
		 * QUESTION DATE SCREEN
		 */
		if (DATE.equalsIgnoreCase(id)) {
			DatePicker datepicker = smScreen.getDatePickerValue();
			int iDay = datepicker.getDayOfMonth();
			int iMonth = datepicker.getMonth();
			int iYear = datepicker.getYear();
			
			sAnswer = iYear+" - "+iMonth+" - "+iDay;
		}

		/**
		 * QUESTION TIME SCREEN
		 */
		if (TIME.equalsIgnoreCase(id)) {
			TimePicker timepicker = smScreen.getTimeInputValue();
			
			int iHour = timepicker.getCurrentHour();
			int iMinute = timepicker.getCurrentMinute();
			
			sAnswer = iHour+" : "+iMinute;					
		}

		/**
		 * QUESTION DATE AND TIME SCREEN
		 */
		if (DATETIME.equalsIgnoreCase(id)) {
			DatePicker datepicker = smScreen.getDateTimeValueDATE();
			int iDay = datepicker.getDayOfMonth();
			int iMonth = datepicker.getMonth();
			int iYear = datepicker.getYear();
					
			TimePicker timepicker = smScreen.getDateTimeValueTIME();			
			int iHour = timepicker.getCurrentHour();
			int iMinute = timepicker.getCurrentMinute();
			
			sAnswer = iYear+SEPARATORCARACTER+iMonth+SEPARATORCARACTER+iDay+SEPARATORCARACTER+iHour+SEPARATORCARACTER+iMinute;	
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
		 */
		if (RADIOBUTTONS.equalsIgnoreCase(id)) {
			RadioGroup radiogroup = smScreen.getRadioButtonsValue();			
			
			sAnswer = ""+radiogroup.getCheckedRadioButtonId();
		}

		/**
		 * UTILITY BARCODE READER SCREEN
		 */
		if (BARCODEREADER.equalsIgnoreCase(id)) {
			sAnswer = sScanContent+SEPARATORCARACTER+sScanFormat;			
		}
		
		/**
		 * SELECTION STRUDIES SCREEN
		 */
		if (STUDIES.equalsIgnoreCase(id)) {
			view = mInflater.inflate(R.layout.studies_layout, null);

			Spinner spinner;
			spinner = (Spinner) view.findViewById(R.id.sStudie);
			
			sAnswer = spinner.getSelectedItem().toString();

		}

		/**
		 * SELECTION QUESTIONNARIE GRUOUPS AND QUESTIONNARIE SCREEN
		 */
		if (QUESTIONNARIES.equalsIgnoreCase(id)) {
			view = mInflater.inflate(R.layout.questionaries_layout, null);

			Spinner spinner;
			spinner = (Spinner) view.findViewById(R.id.sQuestionarie);
			
			sAnswer = spinner.getSelectedItem().toString();
		}

		/**
		 * SELECTION LOGIN FOR THE INTERVIEWER SCREEN
		 */
		if (INTERVIEWER.equalsIgnoreCase(id)) {

			view = mInflater.inflate(R.layout.interviewer_layout, null);

			Spinner spinner;
			spinner = (Spinner) view.findViewById(R.id.sCode);
			
			sAnswer = spinner.getSelectedItem().toString();

		}

		/**
		 * SELECTION EDIT OR ADD SUBJECT SCREEN
		 */
		if (SUBJECTS.equalsIgnoreCase(id)) {

			view = mInflater.inflate(R.layout.subject_layout, null);

			rgSubjects = (RadioGroup) view.findViewById(R.id.rgSubjects);
			
			sAnswer = ""+rgSubjects.getCheckedRadioButtonId();
			
			
		}

		/**
		 * EDIT A EXISTING SUBJECT SCREEN
		 */
		if (EDITSUBJECT.equalsIgnoreCase(id)) {
			
			view = mInflater.inflate(R.layout.edit_subject_layout, null);
			
		}

		/**
		 * ADD A NEW SUBJECT SCREEN
		 */
		if (ADDSUBJECT.equalsIgnoreCase(id)) {
			
			view = mInflater.inflate(R.layout.add_subject_layout, null);
			
			view.findViewById(R.id.etSaSubjectId);
		}

		/**
		 * SELECTION SELECT REPORT TO SHOW SCREEN
		 */
		if (REPORTS.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.report_layaout);

			view = mInflater.inflate(R.layout.report_layaout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * GRID TABLE LAYOUT FOR DATA FROM QUERY REPORTS SCREEN
		 */
		if (REPORTSDATA.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.reportdata_layout);

			view = mInflater.inflate(R.layout.report_layaout, null);

			tvStudyNameLong = (TextView) view
					.findViewById(R.id.tvStudyNameLong);
			tvStudyNameShort = (TextView) view
					.findViewById(R.id.tvStudyNameShort);
		}

		/**
		 * WELCOME SCREEN
		 */
		if (WELCOME.equalsIgnoreCase(id)) {
			activity.setContentView(R.layout.welcome_layout);

			view = mInflater.inflate(R.layout.welcome_layout, null);

			rlLayout = (RelativeLayout) view.findViewById(R.id.rlWelcomeLayout);
			rlLayout.setOnClickListener(this);

			loader = new LoadingDialog(ctx);

			cdtTimer2 = new CountDownTimer(5000, 1000) {

				public void onTick(long millisUntilFinished) {

				}

				@Override
				public void onFinish() {
					if (bBandera == false) {
						String msg = ctx
								.getString(R.string.tap_the_screen_to_begin_qm);
						showMsg.longInstantMessage(msg, ctx);
					}
				}
			}.start();
		}
				
		return sAnswer;
	}
	
	public Button getNextButton(){
		Button button = new Button (ctx);
		return button;
	}
	
	public Button getBackButton(){
		Button button = new Button(ctx);
		return button;
	}
	
	public void setScanContent(String content){
		this.sScanContent = content;
		
		TextView textview = (TextView) view.findViewById(R.id.tvScan_content);
		textview.setText(content);
	}
	
	public void setScanFormat(String format){
		this.sScanFormat = format;
		
		view = mInflater.inflate(R.layout.bar_code_reader_layout, null);
		
		TextView textview = (TextView) view.findViewById(R.id.tvScan_format);
		textview.setText(format);
	}
	
	public String getScanContent(){
		return this.sScanContent;
	}
	
	public String getScanFormat(){
		return this.sScanFormat;
	}
}
