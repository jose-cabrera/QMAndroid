package org.questionairemanager.engine.utility;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowMessage {
	   public void instantMessage(final String message, final Context ctx) {
	        Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
	        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
	                msg.getYOffset() / 2);
	        msg.show();
	    }
}
