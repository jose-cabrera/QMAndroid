package org.questionairemanager.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.questionairemanager.engine.utility.LoadingDialog;
import org.questionairemanager.engine.utility.ScreenMaker;
import org.questionairemanager.engine.utility.ShowMessage;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class QuestionsActivity extends Activity {

	ShowMessage showMsg = new ShowMessage();
	ScreenMaker smScreen;
	MenuItem miItem;
	int iTools = 0, contador = 0, IdOriginQuestion=2;
	InputMethodManager imm;
	EditText etTextInputValue, etPhoneInputValue, etNumberInputValue, etTextAreaValue;
	Button btnBack, btnNext;
	
	LoadingDialog ldLoader;
	
	String[] alValues = {"Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an.", "item2", "Homero salutatus suscipiantur eum id, tamquam voluptaria expetendis ad sed, nobis feugiat similique usu ex.", "item4", "Legere expetenda pertinacia ne pro, et pro impetus persius assueverit.", "Pro ex putant deleniti repudiare, vel an aperiam sensibus suavitate.", "Eos mutat ullum forensibus ex, wisi perfecto urbanitas cu eam, no vis dicunt impetus.", "At has veri feugait placerat, in semper offendit praesent his. Omnium impetus facilis sed at, ex viris tincidunt ius. Unum eirmod dignissim id quo. Sit te atomorum quaerendum neglegentur, his primis tamquam et."};
	
	final int iGps_Menu_Item = Menu.FIRST;
	final int iTimer_Menu_Item = iGps_Menu_Item + 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions_layout);
		
		TextView tvSubjectNumber = (TextView) findViewById(R.id.tvSubjectNumber);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnBack = (Button) findViewById(R.id.btnBack);
		ldLoader = new LoadingDialog(this);
		
		tvSubjectNumber.setText(getIntent().getExtras().getString("SubjectId"));
		try{
			IdOriginQuestion = Integer.parseInt(getIntent().getExtras().getString("IdOriginQuestion"));
		}
		catch(Exception e){
			IdOriginQuestion = 2;
		}
	    if(IdOriginQuestion == 0){
	    	Intent iIntent = new Intent(QuestionsActivity.this, BarCodeReaderActivity.class);
			iIntent.putExtra("IdOrigin", ""+1);
;	        startActivity(iIntent);
			contador=10;
	    }
	    if(IdOriginQuestion == 1){
	    	smScreen = new ScreenMaker(QuestionsActivity.this);
			smScreen.Text("This is a Final Screen");
			smScreen.EmptySapce(20);
			smScreen.Text("The end of the questionarie");
			contador=11;
	    }
	    else{
	    	smScreen = new ScreenMaker(QuestionsActivity.this);
			smScreen.Text("This is an info screen. Since this screen is designed only to display information, it expands the text panel and doesn`t have an answer panel");
			smScreen.EmptySapce(20);
			smScreen.Text("You can type as much text as you want");	
	    }
				
		final LinearLayout llQuestion = (LinearLayout) findViewById(R.id.llQuestionsLayout);
		final ScrollView svScrollView = (ScrollView) findViewById(R.id.svQuestionScroll);
		
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		
		
	    btnBack.setOnClickListener(new OnClickListener(){

	        	@Override 
	        	public void onClick(View v){
	        		svScrollView.scrollTo(0, 0);
	        		switch(contador){
	        		
	        		case 0://Back
	        			QuestionsActivity.super.onBackPressed();
	        			break;
	        			
	        		case 1:
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	        			smScreen.Text("This is an info screen. Since this screen is designed only to display information, it expands the text panel and doesn`t have an answer panel");
	        			smScreen.EmptySapce(20);
	        			smScreen.Text("You can type as much text as you want");
	        			llQuestion.addView(smScreen.MakeScreen());
	        			contador=0;
	        			break;
	        				
	        		case 2://RadioButtons
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 0. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
	            		smScreen.EmptySapce(20);
	            		smScreen.RadioButtons(alValues);	
	            		llQuestion.addView(smScreen.MakeScreen());
	            		contador--;
	        			break;
	        			
	        		case 3://Checkbox
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 1. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
	            		smScreen.EmptySapce(20);
	            		smScreen.CheckBox(alValues);
	            		llQuestion.addView(smScreen.MakeScreen());
	            		contador--;
	        			break;
	        				        		
	        		case 4://DatePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 3 DatePicker. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
	            		smScreen.EmptySapce(20);
	            		smScreen.DatePicker();
	            		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
	            		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;
	        		
	        		case 5://PhoneInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 4 PhoneInput");
	            		smScreen.EmptySapce(20);
	            		smScreen.PhoneInput();
	            		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
	            		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;
	        			
	        		case 6://NumberInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 5 NumberInput");
	            		smScreen.EmptySapce(20);
	            		smScreen.NumberInput();
	            		etNumberInputValue = (EditText) smScreen.getNumberInputValue();
	            		imm.hideSoftInputFromWindow(etNumberInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;
	        			
	        		case 7://TextInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 6 TextInput");
	            		smScreen.EmptySapce(20);
	            		smScreen.TextInput();
	            		etTextInputValue = (EditText) smScreen.getTextInputValue();
	            		imm.hideSoftInputFromWindow(etTextInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;	
	        			
	        		case 8://TimePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 7 Time");
	            		smScreen.EmptySapce(20);
	            		smScreen.TimePicker();
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;	
	        			
	        		case 9://DateTimePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
	            		smScreen.Text("Question number 8 DateTime");
	            		smScreen.EmptySapce(20);
	            		smScreen.DateTimePicker();
	            		etTextAreaValue = (EditText) smScreen.getTextAreaValue();
		        		imm.hideSoftInputFromWindow(etTextAreaValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	            		llQuestion.addView(smScreen.MakeScreen());
	        			contador--;
	        			break;		
	        			
	        		case 10://GPS
	        			Intent iIntent = new Intent(QuestionsActivity.this, GPSActivity.class);
	        			iIntent.putExtra("IdOrigin", ""+1);
	        			startActivity(iIntent);
	        			contador--;
	        			break;
	        			
	        		case 11://BarCodeReader
	        			Intent iIntentBarCode = new Intent(QuestionsActivity.this, BarCodeReaderActivity.class);
	        			iIntentBarCode.putExtra("IdOrigin", ""+1);
	        			startActivity(iIntentBarCode);
	        			contador--;
	        			break;
	        		
	        		}
	        	}
	        } );
	    	    
	    btnNext.setOnClickListener(new OnClickListener(){
	        	
	        	@Override 
	        	public void onClick(View v){//	 
	        		svScrollView.scrollTo(0, 0);
	        		switch(contador){
	        		
	        		case 0://RadioButtons
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 0. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
		        		smScreen.EmptySapce(20);
		        		smScreen.RadioButtons(alValues);	
		        		 llQuestion.addView(smScreen.MakeScreen());		    
		        		contador++;
	        			break;
	        			
	        		case 1://CheckBox
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 1. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
		        		smScreen.EmptySapce(20);
		        		smScreen.CheckBox(alValues);
		        		 llQuestion.addView(smScreen.MakeScreen());

		        		contador++;
	        			break;
	        			
	        		case 2://DatePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 3 DatePicker. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
		        		smScreen.EmptySapce(20);
		        		smScreen.DatePicker();
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador++;
	        			break;
	        		


	        		case 3://PhoneInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 4 PhoneInput");
		        		smScreen.EmptySapce(20);
		        		smScreen.PhoneInput();
		        		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
		        		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador++;
	        			break;
	        		

	        		case 4://NumberInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 5 NumberInput");
		        		smScreen.EmptySapce(20);
		        		smScreen.NumberInput();
		        		etNumberInputValue = (EditText) smScreen.getNumberInputValue();
		        		imm.hideSoftInputFromWindow(etNumberInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador++;
	        			break;
	        			
	        		case 5://TextInput
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 6 TextInput");
		        		smScreen.EmptySapce(20);
		        		smScreen.TextInput();
		        		etTextInputValue = (EditText) smScreen.getTextInputValue();
		        		imm.hideSoftInputFromWindow(etTextInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		        		llQuestion.addView(smScreen.MakeScreen());		        		
	        			contador++;
	        			break;	
	        			
	        		case 6://TimePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 7 Time");
		        		smScreen.EmptySapce(20);
		        		smScreen.TimePicker();
		        		etTextInputValue = (EditText) smScreen.getTextInputValue();
		        		imm.hideSoftInputFromWindow(etTextInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador++;
	        			break;	
	        			
	        		case 7://DateTimePicker
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 8 DateTime");
		        		smScreen.EmptySapce(20);
		        		smScreen.DateTimePicker();
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador++;
	        			break;	
	        			
	        		case 8://TextArea
	        			llQuestion.removeAllViewsInLayout();
	        			smScreen.CleanScreen();
		        		smScreen.Text("Question number 9 TextArea. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
		        		smScreen.EmptySapce(20);
		        		smScreen.TextArea();		      
		        		etTextAreaValue = (EditText) smScreen.getTextAreaValue();
		        		imm.hideSoftInputFromWindow(etTextAreaValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		        		llQuestion.addView(smScreen.MakeScreen());
	        			contador=9;
	        			break;		
	        		
	        		case 9://GPS
	        			Intent iIntent = new Intent(QuestionsActivity.this, GPSActivity.class);
	        			iIntent.putExtra("IdOrigin", ""+1);
	        			startActivity(iIntent);
	        			contador=10;
	        			break;
	        			
	        		case 10:
	        			Intent iIntentBarCode = new Intent(QuestionsActivity.this, BarCodeReaderActivity.class);
	        			iIntentBarCode.putExtra("IdOrigin", ""+1);
	        			startActivity(iIntentBarCode);
	        			contador=11;
	        			break;
	        			
	        		case 11:
	        			ldLoader.showSpinnerLoading();
	        			break;
	        		
	        		}
	        		
	        	}
	        } );
	    
	    llQuestion.addView(smScreen.MakeScreen());
	         
	}
	
	public void hideKeybord(){
		etTextAreaValue = (EditText) smScreen.getTextAreaValue();
		imm.hideSoftInputFromWindow(etTextAreaValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		etTextInputValue = (EditText) smScreen.getTextInputValue();
		imm.hideSoftInputFromWindow(etTextInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		etNumberInputValue = (EditText) smScreen.getNumberInputValue();
		imm.hideSoftInputFromWindow(etNumberInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}
	
	public void paintScreenTemplates(int iIdTemplate, String sPregunta){
		LinearLayout llQuestion = (LinearLayout) findViewById(R.id.llQuestionsLayout);
		String sPreguntaWithVariableValue = getVariableValue(sPregunta);
		
		switch(iIdTemplate){
			case 1://InfoScreen
				llQuestion.removeAllViewsInLayout();
				smScreen.CleanScreen();
				smScreen.Text(sPreguntaWithVariableValue);
				smScreen.EmptySapce(20);
				hideKeybord();
				llQuestion.addView(smScreen.MakeScreen());
				break;
			
			case 2://TextArea
				llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.TextArea();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 3://DatePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.DatePicker();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 4://TimePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.TimePicker();         	
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 5://DateTimePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.DateTimePicker();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 6://TextInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.TextInput();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());		     
				break; 
				
			case 7://NumberInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.NumberInput();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 8://PhoneInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.PhoneInput();
        		hideKeybord();
        		llQuestion.addView(smScreen.MakeScreen());
				break;
				
			case 9://DecimalNumber
				break;
		}
		
	}
	
	public void paintScreenTemplates(int iIdTemplate, String sPregunta, String[] saRespuestas){
		LinearLayout llQuestion = (LinearLayout) findViewById(R.id.llQuestionsLayout);
		String sPreguntaWithVariableValue = getVariableValue(sPregunta);
		
		switch(iIdTemplate){
			case 10:
				//RadioButtons
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.RadioButtons(saRespuestas);	
        		hideKeybord();
        		 llQuestion.addView(smScreen.MakeScreen());		   
				break;
				
			case 11://CheckBox
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text(sPreguntaWithVariableValue);
        		smScreen.EmptySapce(20);
        		smScreen.CheckBox(saRespuestas);
        		hideKeybord();
        		 llQuestion.addView(smScreen.MakeScreen());
				break;
		
			case 12:
				break;
				
			case 13:
				break;
			
		}
		
	}
	
	/**
	 * Finds Variable Names after the "@" that means its a Questionnaire Variable Before it is painted on the Screen
	 * @param sValue, String,  Is the Complete String where its going to find for the @ and the String after it
	 * @return String, it has the value of the Variable, concatenated to the String that will be Pur on the Screen 
	 */
	public String getVariableValue(String sValue){
		String sValuesPlusVariableValue = null;
		String sVariableValue = null;
		Pattern p = Pattern.compile("@(.*?) ");
		Matcher m = p.matcher(sValue);
		if (m.find()) {
			  Log.d("VARIABLEAFTER@",m.group(1));
			  // sVariableValue = Send to Engine Method that gets the Value that returns the String
			  sValuesPlusVariableValue = sValue.replace("@"+m.group(1), sVariableValue);
		}
		
		return sValuesPlusVariableValue;
	}
	
	@Override
    public void onBackPressed() {
		final LinearLayout llQuestion = (LinearLayout) findViewById(R.id.llQuestionsLayout);
		ScrollView svScrollView = (ScrollView) findViewById(R.id.svQuestionScroll);
		svScrollView.scrollTo(0, 0);
		switch(contador){

    		case 0://Back
    			QuestionsActivity.super.onBackPressed();
    			break;
    			
    		case 1:
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
    			smScreen.Text("This is an info screen. Since this screen is designed only to display information, it expands the text panel and doesn`t have an answer panel");
    			smScreen.EmptySapce(20);
    			smScreen.Text("You can type as much text as you want");
    			llQuestion.addView(smScreen.MakeScreen());
    			contador=0;
    			break;
    				
    		case 2://RadioButtons
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 0. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
        		smScreen.EmptySapce(20);
        		smScreen.RadioButtons(alValues);	
        		llQuestion.addView(smScreen.MakeScreen());
        		contador--;
    			break;
    			
    		case 3://Checkbox
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 1. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
        		smScreen.EmptySapce(20);
        		smScreen.CheckBox(alValues);
        		llQuestion.addView(smScreen.MakeScreen());
        		contador--;
    			break;
    				        		
    		case 4://DatePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 3 DatePicker. Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per. Ius id vidit volumus mandamus, vide veritus democritum te nec, ei eos debet libris consulatu. No mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam cum cu, sit summo dolor essent te.");
        		smScreen.EmptySapce(20);
        		smScreen.DatePicker();
        		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
        		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;
    		
    		case 5://PhoneInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 4 PhoneInput");
        		smScreen.EmptySapce(20);
        		smScreen.PhoneInput();
        		etPhoneInputValue = (EditText) smScreen.getPhoneInputValue();
        		imm.hideSoftInputFromWindow(etPhoneInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;
    			
    		case 6://NumberInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 5 NumberInput");
        		smScreen.EmptySapce(20);
        		smScreen.NumberInput();
        		etNumberInputValue = (EditText) smScreen.getNumberInputValue();
        		imm.hideSoftInputFromWindow(etNumberInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;
    			
    		case 7://TextInput
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 6 TextInput");
        		smScreen.EmptySapce(20);
        		smScreen.TextInput();
        		etTextInputValue = (EditText) smScreen.getTextInputValue();
        		imm.hideSoftInputFromWindow(etTextInputValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;	
    			
    		case 8://TimePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 7 Time");
        		smScreen.EmptySapce(20);
        		smScreen.TimePicker();
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;	
    			
    		case 9://DateTimePicker
    			llQuestion.removeAllViewsInLayout();
    			smScreen.CleanScreen();
        		smScreen.Text("Question number 8 DateTime");
        		smScreen.EmptySapce(20);
        		smScreen.DateTimePicker();
        		etTextAreaValue = (EditText) smScreen.getTextAreaValue();
        		imm.hideSoftInputFromWindow(etTextAreaValue.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        		llQuestion.addView(smScreen.MakeScreen());
    			contador--;
    			break;		
    			
    		case 10://GPS
    			Intent iIntent = new Intent(QuestionsActivity.this, GPSActivity.class);
    			iIntent.putExtra("IdOrigin", ""+1);
    			startActivity(iIntent);
    			contador--;
    			break;
    			
    		case 11://BarCodeReader
    			Intent iIntentBarCode = new Intent(QuestionsActivity.this, BarCodeReaderActivity.class);
    			iIntentBarCode.putExtra("IdOrigin", ""+1);
    			startActivity(iIntentBarCode);
    			contador--;
    			break;
		
		}
        return;
    }  
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem miItem){
    	
    	switch (miItem.getItemId()) {
        case R.id.menu_gps:
        	Intent iIntent = new Intent(QuestionsActivity.this, GPSActivity.class);
    		startActivity(iIntent);
    		return true;
         
        case R.id.menu_timer:
        	Intent iIntentTimer = new Intent(QuestionsActivity.this, TimerActivity.class);
    		startActivity(iIntentTimer);
    		return true;
    		
        case R.id.menu_barcodereader:
        	Intent iIntentBarCode = new Intent(QuestionsActivity.this, BarCodeReaderActivity.class);
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
        	Intent iIntentReport = new Intent(QuestionsActivity.this, ReportsActivity.class);
    		startActivity(iIntentReport);
        	return true;		
       
        default:
        	return super.onOptionsItemSelected(miItem);
         
        }
    }
}
