package net.ichigotake.colorfulsweets.lib.ui;

import android.os.AsyncTask;

/**
 * API level 3
 *
 * Run the task in background with {@link java.lang.Runnable}.
 */
public class AsyncRunnableTask extends AsyncTask<Runnable, Void, Void> {

	@Override
	protected Void doInBackground(Runnable... listeners) {
		for (Runnable listener : listeners) {
            listener.run();
        }
		return null;
	}


}
