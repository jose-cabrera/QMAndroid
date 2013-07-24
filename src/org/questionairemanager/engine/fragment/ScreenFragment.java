package org.questionairemanager.engine.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.questionairemanager.engine.utility.ScreenMaker;

@SuppressLint("NewApi")
public class ScreenFragment extends Fragment {

	ScreenMaker smScreen;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
		smScreen = new ScreenMaker(getActivity());
		smScreen.Text("This is an info scree. Since this screen is designed only to display information, it expands the text panel and doesn`t have an answer panel");
		smScreen.EmptySapce(20);
		smScreen.Text("You can type as much text as you want");
		smScreen.EmptySapce(30);
		String[] valores = {"item1", "item2", "item3", "item4", "item5"};
		smScreen.CheckBox(valores);
		smScreen.ComboBox(valores);
		smScreen.RadioButtons(valores);
		return smScreen.MakeScreen();
	}

} 
