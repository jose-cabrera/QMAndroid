package org.questionairemanager.engine.utility;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScreenMaker {//Create screen dynamically
		private Context ctCtx;
		private LinearLayout lyPrincipal, lyContent;
		private ScrollView svScroll;
		
		public ScreenMaker(Context ctx) {
			this.ctCtx = ctx;
			lyPrincipal = new LinearLayout(ctx);
			lyPrincipal.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			lyContent = new LinearLayout(ctx);
			
			lyContent.setOrientation(LinearLayout.VERTICAL);
			lyContent.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
			svScroll = new ScrollView(ctx);
			svScroll.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		}
		
		public void EmptySapce(int iSize) {//To add an Empty space on the layout measured by dependence pixels dp  
			View vEmptySpace = new View(ctCtx);
			vEmptySpace.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,iSize));
			lyContent.addView(vEmptySpace);
		}
		
		public void DrawQuestionInfo (String sName, String sNumber){ //To add the question Info (Name, Number on QS) 
			TextView tvKey, tvValue;
			LinearLayout lyLinear = new LinearLayout(ctCtx);
			lyLinear.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyLinear.setWeightSum(2); 
			tvKey = new TextView(ctCtx);
			tvValue = new TextView(ctCtx);
			tvKey.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			tvValue.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			tvKey.setTextColor(Color.BLACK);
			tvValue.setTextColor(Color.BLACK);
			tvKey.setBackgroundColor(Color.WHITE);
			tvValue.setBackgroundColor(Color.WHITE);
			tvKey.setText(sName);
			tvValue.setText(sNumber);
			lyLinear.addView(tvKey);
			lyLinear.addView(tvValue);
			lyContent.addView(lyLinear);
		}
		
		public void Question(String sQuestion) {//To Add the Question
			TextView tvQuestion =new TextView(ctCtx);
			tvQuestion.setText(sQuestion);
			tvQuestion.setBackgroundColor(Color.WHITE);
			tvQuestion.setTextColor(Color.BLACK);
			tvQuestion.setGravity(Gravity.CENTER);
			tvQuestion.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyContent.addView(tvQuestion);
		}
		
		public void TextInput(){//Add a Text input
			 EditText etTextInput = new EditText(ctCtx);
             etTextInput.setInputType(1);
			 etTextInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			 lyContent.addView(etTextInput);
		}
		
		public void NumberInput(){//Add a Number input
			EditText etNumberInput = new EditText(ctCtx);
            etNumberInput.setInputType(24);
			etNumberInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			lyContent.addView(etNumberInput);
		}

        public void DecimalNumberInput(){//Add a Number input
            EditText etDecimalNumberInput = new EditText(ctCtx);
            etDecimalNumberInput.setInputType(26);
            etDecimalNumberInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDecimalNumberInput);
        }
		
		public void DateInput(){//Add a Date selecter
            EditText etDateInput = new EditText(ctCtx);
            etDateInput.setInputType(30);
            etDateInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDateInput);
		}

        public void DateTimeInput(){//Add a Date and time selecter
            EditText etDateTimeInput = new EditText(ctCtx);
            etDateTimeInput.setInputType(29);
            etDateTimeInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etDateTimeInput);
        }

        public void TimeInput(){//Add a Date and time selecter
            EditText etTimeInput = new EditText(ctCtx);
            etTimeInput.setInputType(31);
            etTimeInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etTimeInput);
        }

        public void PhoneInput(){
            EditText etPhoneInput = new EditText(ctCtx);
            etPhoneInput.setInputType(28);
            etPhoneInput.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            lyContent.addView(etPhoneInput);
        }
		
		public void ComboBox(String sQuestion) {//To Add a Combobox
			
		}
		
		public void CheckBox(int iNumber, ArrayList aValues){//Add a CheckBox
			
		}
		
		public void RadioButtons(int iNumber, ArrayList aValues){//Add a radio button
			
		}
		
		public LinearLayout MakeScreen(){
			svScroll.addView(lyPrincipal);
			lyPrincipal.addView(svScroll);
			return lyPrincipal;
		}
		
		
		
		
		
}
