package org.questionairemanager.engine.utility;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowMessage {
	   
	   /**
	    * Shows a Toast for short time 	
	    * @param message, String, The message that will be display
	    * @param ctx, Context, the context (Activity) where it is going to be show
	    */	
	   public void instantMessage(final String message, final Context ctx) {
	        Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
	        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
	                msg.getYOffset() / 2);
	        msg.show();
	    }
	   
	   /**
	    * Shows a Toast for long time 	
	    * @param message, String, The message that will be display
	    * @param ctx, Context, the context (Activity) where it is going to be show
	    */	
	   public void longInstantMessage(final String message, final Context ctx) {
	        Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
	        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
	                msg.getYOffset() / 2);
	        msg.show();
	    }
}
