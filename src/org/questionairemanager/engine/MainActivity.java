package org.questionairemanager.engine;

import java.util.Locale;

import org.questionnairemanager.engine.utility.ScreenManager;
import org.questionnairemanager.engine.utility.ShowMessage;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	ScreenManager smScreenManager;
	String iLayoutiId = null;
	ShowMessage showMsg = new ShowMessage();
	Locale lLanguage;
	String id;

	/**
	 * DUMMY
	 */
	String[] legalValues = new String[3], HelpText = new String[1], MainText = new String[1],
			Answered = null;
	int[] AnsweredIndex = null;
	Button btnNext, btnBack, btnNextGps, btnBackGps;
	int count = 0;
	LinearLayout llQuestion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.questions_layout);

		smScreenManager = new ScreenManager(this);

		MainText[0] = "This is an info screen. Since this screen is designed only to display information, it expands the text panel and doesn`t have an answer panel";
		HelpText[0] = "help text";

		llQuestion = (LinearLayout) findViewById(R.id.llQuestionsLayout);
		if(llQuestion.getChildCount() !=0){
			llQuestion.removeAllViewsInLayout();
		}
		llQuestion.addView(smScreenManager.drawScreen(ScreenManager.INFOSCREEN, legalValues,
				MainText, HelpText, Answered, AnsweredIndex));		

		btnNext = smScreenManager.getNextButton();
		btnBack = smScreenManager.getBackButton();

		btnNext.setOnClickListener(this);
		btnBack.setOnClickListener(this);

	}
	
	/**
	 * Activity Result of BAR CODE READER
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		String sScanContent;
		String sScanFormat;

		IntentResult scanningResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		if (scanningResult != null) {
			sScanContent = "FORMAT " + scanningResult.getContents();
			sScanFormat = "CONTENT " + scanningResult.getFormatName();

		} else {
			sScanContent = "No scan data received!";
			sScanFormat = "No scan data received!";
		}

		smScreenManager.setScanContent(sScanContent);
		smScreenManager.setScanFormat(sScanFormat);
	}

	@Override
	public void onClick(View v) {

		MainText[0] = "Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an.";
		
		switch (v.getId()) {

		case R.id.btnNext:
			switch(count){
			case 0:				
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.BARCODEREADER, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
			
			case 1:
				legalValues[0] = "option1";
				legalValues[1] = "option2";
				legalValues[2] = "option3";
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.CHECKBOX, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 6:
				legalValues[0] = "item1";
				legalValues[1] = "item2";
				legalValues[2] = "item3";
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.COMBOBOX, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 3:
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.DATE, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 4:
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.DATETIME, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 5:
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.DECIMALNUMBERINPUT, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 2:
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.GPS, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 7:
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.NUMBERINPUT, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 8:
				llQuestion.removeAllViewsInLayout();
				Answered = new String[1];
				Answered[0] = "2515135123";
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.PHONEINPUT, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 9:
				legalValues[0] = "Radio1";
				legalValues[1] = "Radio2";
				legalValues[2] = "Radio3";
				llQuestion.removeAllViewsInLayout();
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.RADIOBUTTONS, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 10:
				llQuestion.removeAllViewsInLayout();
				Answered[0] = "jdhfkjashdghashgdsagadhgjkadkjghakjdshdghasdhgjkashdgjkhasdkjghakjsdhgkjashdg";
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.TEXTAREA, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 11:
				llQuestion.removeAllViewsInLayout();
				Answered[0] = "jdhfkjashdghashgdsagadhgkjashdg";
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.TEXTBOX, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			case 12:		
				llQuestion.removeAllViewsInLayout();
				Answered = null;
				llQuestion.addView(smScreenManager.drawScreen(ScreenManager.TIME, legalValues,
						MainText, HelpText, Answered, AnsweredIndex));
				count++;
				break;
				
			}
			break;

		case R.id.btnBack:
			break;
		}
	}
}
