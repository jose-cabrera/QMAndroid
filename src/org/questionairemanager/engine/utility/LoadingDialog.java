package org.questionairemanager.engine.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import org.questionairemanager.engine.R;

public class LoadingDialog {
	
	ProgressDialog pgProgressDialog;   
    Handler pro_handler;
    int progress;
	
	public LoadingDialog(Context ctCtx){
		pgProgressDialog = new ProgressDialog(ctCtx);
		pgProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);	
		pgProgressDialog.setMessage(ctCtx.getString(R.string.loading));
	}
	
	public void showSpinnerLoading(){	
		pgProgressDialog.show();		
	}
}
