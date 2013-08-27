package org.questionnairemanager.engine.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import org.questionairemanager.engine.R;

public class LoadingDialog {
	/**
	 * @author josepablocabreragarcia
	 * It creates a Loading Dialog
	 */
	
	ProgressDialog pgProgressDialog;   
    Handler pro_handler;
    int progress;
	
    /**
     * Creates de Loading Dialog
     * @param ctCtx, Context, gets the Context(Activity) where it is going to be shown
     * @author josepablocabreragarcia
     */
	public LoadingDialog(Context ctCtx){
		pgProgressDialog = new ProgressDialog(ctCtx);
		pgProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);	
		pgProgressDialog.setMessage(ctCtx.getString(R.string.loading));
	}
	
	/**
	 * Starts the loading dialog
	 * @author josepablocabreragarcia
	 */
	public void showSpinnerLoading(){	
		pgProgressDialog.show();		
	}
	
	/**
	 * Stops the loading dialog
	 * @author josepablocabreragarcia
	 */
	public void stopSpinnerLoading(){
		pgProgressDialog.cancel();
	}
}
