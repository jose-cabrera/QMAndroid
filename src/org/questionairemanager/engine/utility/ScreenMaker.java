package org.questionairemanager.engine.utility;

/**
 * This class is for making views dynamically for a fragment when need it.
 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
 */

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import org.questionairemanager.engine.R;

public class ScreenMaker {
	/**
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @var ctCtx, Context, its the activity or context where the views and
	 *      layouts are going to be add
	 * @var lyPrincipal, LinearLayout, its the layout that contains everything
	 *      created in this class, and it's going to be returned so it can be
	 *      used on the fragment
	 * @var lyContent, LinearLayout, its the layout that will contain all the
	 *      views
	 * @var svScroll, ScrollView, this will contain the lyContent, and will
	 *      allow to have an scroll on the screen if the views are bigger than
	 *      the device's screen
	 */
	private Context ctCtx;
	private LinearLayout lyPrincipal, lyContent;
	TableLayout tlDataTable;
	TableRow trDataRow;
	View vEmptySpace;
	TextView tvKey, tvValue, tvQuestion, tvText, tvLatitude, tvLongitude,
			tvAltitude, tvAccuraccy, tvNMEA, tvHelpText, tvCell,
			tvQuestionBarCode, tvContentBarCode, tvFormatBarCode;
	EditText etTextInput, etNumberInput, etDateTimeInput, etDecimalNumberInput,
			etTimeInput, etPhoneInput, etTextArea;
	android.widget.DatePicker etDateInput, etDTDateInput;
	android.widget.TimePicker tpTimeInput, tpDTTimeInput;
	RadioGroup rgRadioButtons;
	CheckBox cbCheckBoxs;
	Spinner spComboBox;
	Button btnGPS, btnScan;

	/**
	 * The ScreenMaker its the builder for the class, it creates the layouts and
	 * scroll view that will contain all the views that we add.
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param ctx
	 *            Context where its going to be applied.
	 */
	public ScreenMaker(Context ctx) {
		this.ctCtx = ctx;
		lyPrincipal = new LinearLayout(ctx);
		lyPrincipal.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		lyContent = new LinearLayout(ctx);
		lyContent.setOrientation(LinearLayout.VERTICAL);
		lyContent.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	public void CleanScreen() {
		if (lyContent.getChildCount() != 0) {
			lyContent.removeAllViewsInLayout();
		}
		if (lyPrincipal.getChildCount() != 0) {
			lyPrincipal.removeAllViewsInLayout();
		}
	}

	/**
	 * To add an Empty space on the layout measured by dependence pixels dp
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param iSize
	 *            int, it gets the size of the empty space you want
	 */
	public void EmptySapce(int iSize) {
		vEmptySpace = new View(ctCtx);
		vEmptySpace.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, iSize));
		lyContent.addView(vEmptySpace);
	}

	/**
	 * To add a Text
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param sText
	 *            String, it gets the content of the Text to display
	 */
	public void Text(String sText) {
		tvText = new TextView(ctCtx);
		tvText.setText(sText);
		tvText.setTextSize(23);
		tvText.setTextColor(Color.BLACK);
		tvText.setGravity(Gravity.CENTER);
		tvText.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvText);
	}
	
	/**
	 * To add the Content of the BarCode
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param sText
	 *            String, it gets the content of the Text to display
	 */
	public void TextContent(String sText){
		tvContentBarCode = new TextView(ctCtx);
		tvContentBarCode.setText(sText);
		tvContentBarCode.setTextSize(19);
		tvContentBarCode.setTextColor(Color.BLACK);
		tvContentBarCode.setGravity(Gravity.CENTER);
		tvContentBarCode.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvContentBarCode);
	}
		
	public TextView getTextViewContentBarCode() {
		return tvContentBarCode;
	}
	
	/**
	 * To add the Format of the barCode
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param sText
	 *            String, it gets the content of the Text to display
	 */
	public void TextFormat(String sText){
		tvFormatBarCode = new TextView(ctCtx);
		tvFormatBarCode.setText(sText);
		tvFormatBarCode.setTextSize(19);
		tvFormatBarCode.setTextColor(Color.BLACK);
		tvFormatBarCode.setGravity(Gravity.CENTER);
		tvFormatBarCode.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvFormatBarCode);
	}
	
	public TextView getTextViewFormatBarCode() {
		return tvFormatBarCode;
	}
	
	/**
	 * To add the Scan Button for the BarCode
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void ScanButton(){
		btnScan = new Button(ctCtx);
		btnScan.setGravity(Gravity.CENTER);
		btnScan.setText(R.string.btnScan);
		btnScan.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(btnScan);
	}
	
	public Button getButtonScanBarCode() {
		return btnScan;
	}

	/**
	 * Add a General Text input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void TextInput(String[] Answered) {
		etTextInput = new EditText(ctCtx);
		etTextInput.setInputType(InputType.TYPE_CLASS_TEXT);
		etTextInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etTextInput.setText(Answered[0].toString());
		}
		lyContent.addView(etTextInput);
	}

	public EditText getTextInputValue() {
		return etTextInput;
	}

	/**
	 * Add a General Text input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void TextArea(String[] Answered) {
		etTextArea = new EditText(ctCtx);
		etTextArea.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
		etTextArea.setLines(10);
		etTextArea.setGravity(Gravity.LEFT);
		etTextArea.setHorizontallyScrolling(false);
		etTextArea.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, 400));
		if (Answered != null) {
			etTextArea.setText(Answered[0].toString());
		}
		lyContent.addView(etTextArea);
	}

	public EditText getTextAreaValue() {
		return etTextArea;
	}

	/**
	 * Add a Only Number input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void NumberInput(String[] Answered) {
		etNumberInput = new EditText(ctCtx);
		etNumberInput.setInputType(InputType.TYPE_CLASS_NUMBER);
		etNumberInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etNumberInput.setText(Answered[0].toString());
		}
		lyContent.addView(etNumberInput);
	}

	public EditText getNumberInputValue() {
		return etNumberInput;
	}

	/**
	 * Add a Decimal Number input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void DecimalNumberInput(String[] Answered) {
		etDecimalNumberInput = new EditText(ctCtx);
		etDecimalNumberInput.setInputType(InputType.TYPE_CLASS_NUMBER
				| InputType.TYPE_NUMBER_FLAG_DECIMAL);
		etDecimalNumberInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etDecimalNumberInput.setText(Answered[0].toString());
		}
		lyContent.addView(etDecimalNumberInput);
	}

	public EditText getDecimalNumberInputValue() {
		return etDecimalNumberInput;
	}

	/**
	 * Add a Date Input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void DatePicker(String[] Answered) {//
		etDateInput = new android.widget.DatePicker(ctCtx);
		etDateInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etDateInput.updateDate(Integer.parseInt(Answered[0]),
					(Integer.parseInt(Answered[1]) - 1),
					Integer.parseInt(Answered[2]));
		}
		lyContent.addView(etDateInput);
	}

	public android.widget.DatePicker getDatePickerValue() {
		return etDateInput;
	}

	/**
	 * Add a Date and time selecter
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void DateTimePicker(String[] Answered) {
		etDTDateInput = new android.widget.DatePicker(ctCtx);
		etDTDateInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etDTDateInput.updateDate(Integer.parseInt(Answered[0]),
					(Integer.parseInt(Answered[1]) - 1),
					Integer.parseInt(Answered[3]));
		}
		lyContent.addView(etDTDateInput);
		vEmptySpace = new View(ctCtx);
		vEmptySpace.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, 15));
		lyContent.addView(vEmptySpace);
		tpDTTimeInput = new android.widget.TimePicker(ctCtx);
		tpDTTimeInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			tpDTTimeInput.setCurrentHour(Integer.parseInt(Answered[4]));
			tpDTTimeInput.setCurrentMinute(Integer.parseInt(Answered[5]));
		}
		lyContent.addView(tpDTTimeInput);
	}

	public android.widget.TimePicker getDateTimeValueTIME() {
		return tpDTTimeInput;
	}

	public android.widget.DatePicker getDateTimeValueDATE() {
		return etDTDateInput;
	}

	/**
	 * Add a Date and time selecter
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void TimePicker(String[] Answered) {
		tpTimeInput = new android.widget.TimePicker(ctCtx);
		tpTimeInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			tpTimeInput.setCurrentHour(Integer.parseInt(Answered[0]));
			tpTimeInput.setCurrentMinute(Integer.parseInt(Answered[1]));
		}
		lyContent.addView(tpTimeInput);
	}

	public android.widget.TimePicker getTimeInputValue() {
		return tpTimeInput;
	}

	/**
	 * Add a Phone input
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 */
	public void PhoneInput(String[] Answered) {
		etPhoneInput = new EditText(ctCtx);
		etPhoneInput.setInputType(InputType.TYPE_CLASS_PHONE);
		etPhoneInput.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		if (Answered != null) {
			etPhoneInput.setText(Answered[0].toString());
		}
		lyContent.addView(etPhoneInput);
	}

	public EditText getPhoneInputValue() {
		return etPhoneInput;
	}

	/**
	 * To Add a Combobox, and its items
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param iNumber
	 *            int, Get the number of item you want to add to the list
	 * @param alAnswers
	 *            (String)ArrayList, gets the values of the items you want on
	 *            the list
	 */
	public void ComboBox(String[] legalValues, int[] AnsweredIndex) {
		int iLength = legalValues.length, count = 0;
		spComboBox = new Spinner(ctCtx);
		List<String> lList = new ArrayList<String>();
		for (int i = 0; i < iLength; i++) {
			lList.add(legalValues[i].toString());
		}
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ctCtx,
				android.R.layout.simple_spinner_item, lList);
		spComboBox.setAdapter(dataAdapter);
		if (AnsweredIndex != null) {
			spComboBox.setSelection(AnsweredIndex[0]);
		}
		lyContent.addView(spComboBox);
	}

	public Spinner getComboBoxValue() {
		return spComboBox;
	}

	/**
	 * Add CheckBoxex
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param iNumber
	 *            int, the number of checkboxes you want
	 * @param alValues
	 *            (String)ArrayList, the values of the checkboxes
	 * @id the Ids from the Checkbox are registered with the 0001 plus the index
	 *     where its located 0001+i
	 */
	public void CheckBox(String[] legalValues, int[] AnsweredIndex) {
		int iLength = legalValues.length;
		for (int i = 0; i < iLength; i++) {
			cbCheckBoxs = new CheckBox(ctCtx);
			cbCheckBoxs.setId(0001 + i);
			cbCheckBoxs.setText(legalValues[i].toString());
			cbCheckBoxs.setTextSize(20);
			if (AnsweredIndex != null) {
				for (int j = 0; j < AnsweredIndex.length; j++) {
					if (AnsweredIndex[j] == i)
						cbCheckBoxs.setSelected(true);
				}
			}
			lyContent.addView(cbCheckBoxs);
		}
	}

	public CheckBox getCheckBoxValue() {
		return cbCheckBoxs;
	}

	/**
	 * Adds a radio button group
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @param iNumber
	 *            int, the number of radio buttons you want to have on the group
	 * @param alValues
	 *            (String)ArrayList, values of the radio buttons
	 * @id the Ids from the RadioButtons are registered with the 0010 plus the
	 *     index where its located 0010+i
	 */
	public void RadioButtons(String[] legalValues, int[] AnsweredIndex) {
		rgRadioButtons = new RadioGroup(ctCtx);
		int iLength = legalValues.length;
		for (int i = 0; i < iLength; i++) {
			RadioButton rbButton = new RadioButton(ctCtx);
			rbButton.setText(legalValues[i].toString());
			rbButton.setTextSize(20);
			if (AnsweredIndex != null) {
				if (AnsweredIndex[0] == i) {
					rbButton.setSelected(true);
				}
			}
			rgRadioButtons.addView(rbButton);
		}
		lyContent.addView(rgRadioButtons);
	}

	public RadioGroup getRadioButtonsValue() {
		return rgRadioButtons;
	}
	
	public void TextViewLatitude(String sText){
		tvLatitude = new TextView(ctCtx);
		tvLatitude.setText(sText);
		tvLatitude.setTextSize(19);
		tvLatitude.setTextColor(Color.BLACK);
		tvLatitude.setGravity(Gravity.CENTER);
		tvLatitude.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvLatitude);
	}
	
	public TextView getTextViewLatitude(){
		return tvLatitude;
	}
	
	public void TextViewLongitude(String sText){
		tvLongitude = new TextView(ctCtx);
		tvLongitude.setText(sText);
		tvLongitude.setTextSize(19);
		tvLongitude.setTextColor(Color.BLACK);
		tvLongitude.setGravity(Gravity.CENTER);
		tvLongitude.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(		tvLongitude);
	}
	
	public TextView getTextViewLongitude(){
		return tvLongitude;
	}
	
	public void TextViewAltitude(String sText){
		tvAltitude = new TextView(ctCtx);
		tvAltitude.setText(sText);
		tvAltitude.setTextSize(19);
		tvAltitude.setTextColor(Color.BLACK);
		tvAltitude.setGravity(Gravity.CENTER);
		tvAltitude.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvAltitude);
	}
	
	public TextView getTextViewAltitude(){
		return tvAltitude;
	}
	
	public void TextViewAccuraccy(String sText){
		tvAccuraccy = new TextView(ctCtx);
		tvAccuraccy.setText(sText);
		tvAccuraccy.setTextSize(19);
		tvAccuraccy.setTextColor(Color.BLACK);
		tvAccuraccy.setGravity(Gravity.CENTER);
		tvAccuraccy.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvAccuraccy);
	}
	
	public TextView getTextViewAccuraccy(){
		return tvAccuraccy;
	}
	
	public void TextViewNMEAString(String sText){
		tvNMEA = new TextView(ctCtx);
		tvNMEA.setText(sText);
		tvNMEA.setTextSize(19);
		tvNMEA.setTextColor(Color.BLACK);
		tvNMEA.setGravity(Gravity.CENTER);
		tvNMEA.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(tvNMEA);
	}
	
	public TextView getTextViewNMEA(){
		return tvNMEA;
	}
	
	public void GPSGetPositionButton(){
		btnGPS = new Button(ctCtx);
		btnGPS.setGravity(Gravity.CENTER);
		btnGPS.setText(R.string.get_position);
		btnGPS.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		lyContent.addView(btnGPS);
	}
	
	public Button getGPSButton(){
		return btnGPS;
	}

	/**
	 * It add the ScrollView with the lyContent that has all the views on it, to
	 * the lyPrincipal, wich is returned to used on the fragment
	 * 
	 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
	 * @return lyPrincial, it returns the layaout with the scroll view and the
	 *         content layout with all the view add to it
	 */
	public LinearLayout MakeScreen() {
		lyPrincipal.addView(lyContent);
		return lyPrincipal;
	}
}
