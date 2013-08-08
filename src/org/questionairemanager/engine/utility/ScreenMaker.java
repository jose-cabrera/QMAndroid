package org.questionairemanager.engine.utility;
/**
 * This class is for making views dynamically for a fragment when need it.
 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
 */

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScreenMaker {
    /**
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @var ctCtx, Context, its the activity or context where the views and layouts are going to be add
     * @var lyPrincipal, LinearLayout, its the layout that contains everything created in this class, and it's going to be returned so it can be used on the fragment
     * @var lyContent, LinearLayout, its the layout that will contain all the views
     * @var svScroll, ScrollView, this will contain the lyContent, and will allow to have an scroll on the screen if the views are bigger than the device's screen
     */
		private Context ctCtx;
		private LinearLayout lyPrincipal, lyContent;
		TableLayout  tlDataTable;
		TableRow trDataRow;
		View vEmptySpace;
		TextView tvKey, tvValue, tvQuestion, tvText, tvLatitude, tvLongitude, tvAltitude, tvBearing, tvSpeed, tvHelpText, tvCell;
		EditText etTextInput, etNumberInput, etDateTimeInput, etDecimalNumberInput, etTimeInput, etPhoneInput, etTextArea;
		android.widget.DatePicker etDateInput, etDTDateInput;
		android.widget.TimePicker tpTimeInput, tpDTTimeInput;
		RadioGroup rgRadioButtons;
		CheckBox cbCheckBoxs;
		Spinner spComboBox;
		Button btnGPS;
		
    /**
     * The ScreenMaker its the builder for the class, it creates the layouts and scroll view that will contain all the views that we add.
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param ctx Context where its going to be applied.
     */
		public ScreenMaker(Context ctx) {
			this.ctCtx = ctx;
			lyPrincipal = new LinearLayout(ctx);
			lyPrincipal.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			lyContent = new LinearLayout(ctx);
			lyContent.setOrientation(LinearLayout.VERTICAL);
			lyContent.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		}
		
		public void CleanScreen(){
			lyContent.removeAllViewsInLayout();
			lyPrincipal.removeAllViewsInLayout();
		}

    /**
     * To add an Empty space on the layout measured by dependence pixels dp
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param iSize int, it gets the size of the empty space you want
     */
		public void EmptySapce(int iSize) {
			vEmptySpace = new View(ctCtx);
			vEmptySpace.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,iSize));
			lyContent.addView(vEmptySpace);
		}

    /**
     * To Add the Question
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param sQuestion String, it gets the content of the question to display
     */
		
		/**
		 * To add a Text
		 * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
		 * @param sText String, it gets the content of the Text to display
		 */
		public void Text(String sText) {
			tvText =new TextView(ctCtx);
			tvText.setText(sText);
			tvText.setTextSize(23);
			tvText.setTextColor(Color.BLACK);
			tvText.setGravity(Gravity.CENTER);
			tvText.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyContent.addView(tvText);
		}
		
		public void HelpText(String sText) {
			tvHelpText =new TextView(ctCtx);
			tvHelpText.setText(sText);
			tvHelpText.setTextSize(23);
			tvHelpText.setTextColor(Color.BLACK);
			tvHelpText.setGravity(Gravity.CENTER);
			tvHelpText.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyContent.addView(tvHelpText);
		}	
    /**
     * Add a General Text input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
		public void TextInput(){
			 etTextInput = new EditText(ctCtx);
             etTextInput.setInputType(InputType.TYPE_CLASS_TEXT);
			 etTextInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			 lyContent.addView(etTextInput);
		}
		
		public TextView getTextInputValue(){
			return etTextInput;
		}
		
	/**
     * Add a General Text input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
		public void TextArea(){
			 etTextArea = new EditText(ctCtx);
             etTextArea.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
             etTextArea.setLines(10);
             etTextArea.setGravity(Gravity.LEFT);
             etTextArea.setHorizontallyScrolling(false);
			 etTextArea.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,400));
			 lyContent.addView(etTextArea);
		}
		
		public TextView getTextAreaValue(){
			return etTextArea;
		}	

    /**
     * Add a Only Number input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
		public void NumberInput(){
			etNumberInput = new EditText(ctCtx);
            etNumberInput.setInputType(InputType.TYPE_CLASS_NUMBER);
			etNumberInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyContent.addView(etNumberInput);
		}
		
		public TextView getNumberInputValue(){
			return etNumberInput;
		}

    /**
     * Add a Decimal Number input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
        public void DecimalNumberInput(){
            etDecimalNumberInput = new EditText(ctCtx);
            etDecimalNumberInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            etDecimalNumberInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDecimalNumberInput);
        }
        
        public TextView getDecimalNumberInputValue(){
			return etDecimalNumberInput;
		}

    /**
     * Add a Date Input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
		public void DatePicker(){//
			etDateInput = new android.widget.DatePicker(ctCtx);
            etDateInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDateInput);
		}
		public android.widget.DatePicker getDatePickerValue(){
			return etDateInput;
		}

    /**
     * Add a Date and time selecter
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
        public void DateTimePicker(){
        	etDTDateInput = new android.widget.DatePicker(ctCtx);
        	etDTDateInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDTDateInput);
            vEmptySpace = new View(ctCtx);
			vEmptySpace.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,15));
			lyContent.addView(vEmptySpace);
            tpDTTimeInput = new android.widget.TimePicker(ctCtx);
            tpDTTimeInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(tpDTTimeInput);
        }
        
        public android.widget.TimePicker getDateTimeValueTIME(){
			return tpDTTimeInput;
		}
        
        public android.widget.DatePicker getDateTimeValueDATE(){
        	return etDTDateInput;
        }
      
    /**
     * Add a Date and time selecter
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
        public void TimePicker(){
            tpTimeInput = new android.widget.TimePicker(ctCtx);
            tpTimeInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(tpTimeInput);
        }
        
        public TextView getTimeInputValue(){
			return etTimeInput;
		}

    /**
     * Add a Phone input
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     */
        public void PhoneInput(){
            etPhoneInput = new EditText(ctCtx);
            etPhoneInput.setInputType(InputType.TYPE_CLASS_PHONE);
            etPhoneInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etPhoneInput);
        }
        
        public TextView getPhoneInputValue(){
			return etPhoneInput;
		}

    /**
     * To Add a Combobox, and its items
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param iNumber int, Get the number of item you want to add to the list
     * @param alAnswers (String)ArrayList, gets the values of the items you want on the list
     * @id the Ids from the ComboBox items are registered with the 0000 plus the index where its located 0000+i
     */
		public void ComboBox(String[] alAnswers) {
			int iLength = alAnswers.length;
            spComboBox = new Spinner(ctCtx);
            List<String> lList = new ArrayList<String>();
            for(int i=0; i<iLength; i++){
                lList.add((String) alAnswers[i]);
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ctCtx, android.R.layout.simple_spinner_item, lList);
            spComboBox.setAdapter(dataAdapter);
            lyContent.addView(spComboBox);
		}
		
		public Spinner getComboBoxValue(){
			return spComboBox;
		}

    /**
     * Add CheckBoxex
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param iNumber int, the number of checkboxes you want
     * @param alValues (String)ArrayList, the values of the checkboxes
     * @id the Ids from the Checkbox are registered with the 0001 plus the index where its located 0001+i
     */
		public void CheckBox(String[] alValues){
			int iLength = alValues.length;
			for(int i=0; i<iLength; i++){
                cbCheckBoxs = new CheckBox(ctCtx);
                cbCheckBoxs.setId(0001+i);
                cbCheckBoxs.setText((String) alValues[i]);
                cbCheckBoxs.setTextSize(20);
                lyContent.addView(cbCheckBoxs);
            }
		}
		
		public CheckBox getCheckBoxValue(){
			return cbCheckBoxs;
		}

    /**
     * Adds a radio button group
     * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
     * @param iNumber int, the number of radio buttons you want to have on the group
     * @param alValues (String)ArrayList, values of the radio buttons
     * @id the Ids from the RadioButtons are registered with the 0010 plus the index where its located 0010+i
     */
		public void RadioButtons(String[] alValues){
            rgRadioButtons = new RadioGroup(ctCtx);
            int iLength = alValues.length;
            for(int i=0; i<iLength; i++){
                RadioButton rbButton = new RadioButton(ctCtx);
                rbButton.setId(0010+i);
                rbButton.setText((String) alValues[i]);
                rbButton.setTextSize(20);
                rgRadioButtons.addView(rbButton);
            }
            lyContent.addView(rgRadioButtons);
		}

        public RadioGroup getRadioButtonsValue(){
            return rgRadioButtons;
        }        
        /**
         * 
         * @param asColumns
         * @param asValues
         */
       /*public void DataTable(String[] asColumns, String[][] asValues){
    	   tlDataTable = (TableLayout) new TableLayout(ctCtx);
    	   trDataRow = (TableRow) new TableRow(ctCtx);
    	   tvCell = (TextView) new TextView(ctCtx);
    	   
    	   TableRow.LayoutParams llParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
    	   llParams.setMargins(0, 0, 2, 0);
    	   
    	   LinearLayout llCell = (LinearLayout) new LinearLayout(ctCtx);
    	   llCell.setBackgroundColor(Color.WHITE);
    	   llCell.setLayoutParams(llParams);    	   
    	   
    	   for(int i=0; i<=asColumns.length; i++){
    		   tvCell.setText(asColumns[i].toString());
    		   tvCell.setPadding(0, 0, 4, 3);
    		   llCell.addView(tvCell);
    	   }
    	   trDataRow.addView(llCell);
    	   tlDataTable.addView(trDataRow);
    	   
    	   for(int i=0; i<=asValues.length; i++){
    		   for(int j=0; j<=asValues[i].length; j++){
    			   tvCell.setText(asValues[i][j]);
    			   tvCell.setPadding(0, 0, 4, 3);
        		   llCell.addView(tvCell);
    		   }
    		   trDataRow.addView(llCell);
    		   tlDataTable.addView(trDataRow);
    	   }    	 
    	   lyContent.addView(tlDataTable);
       } 
       
       public TableLayout getDataTable(){
    	   return tlDataTable;
       }*/
       
       /**
        * It add the ScrollView with the lyContent that has all the views on it, to the lyPrincipal, wich is returned to used on the fragment
        * @author Jose Cabrera <email>jose.cabrera@centrikal.com</email>
        * @return lyPrincial, it returns the layaout with the scroll view and the content layout with all the view add to it
        */
       public LinearLayout MakeScreen(){
			lyPrincipal.addView(lyContent);
			return lyPrincipal;
       }
}
