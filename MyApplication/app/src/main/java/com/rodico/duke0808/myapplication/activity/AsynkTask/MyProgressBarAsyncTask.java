package com.rodico.duke0808.myapplication.activity.AsynkTask;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * Created by duke0808 on 17.10.15.
 */
public class MyProgressBarAsyncTask extends AsyncTask<Void,Integer,String> {
    private int progressBarVal = 0;

     /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected String doInBackground(Void... params) {
        while (progressBarVal<100){
            progressBarVal++;
            publishProgress(progressBarVal);
            SystemClock.sleep(100);
            if (isCancelled()){
                progressBarVal=0;
                publishProgress(progressBarVal);
                break;
            }
        }
        return "Result message";
    }

    /**
     * Runs on the UI thread before {@link #doInBackground}.
     *
     * @see #onPostExecute
     * @see #doInBackground
     */
    @Override
    protected void onPreExecute() {
        Toast.makeText(AsyncTaskActivity.context, "Started process", Toast.LENGTH_SHORT).show();
        super.onPreExecute();
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * <p/>
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param aVoid The result of the operation computed by {@link #doInBackground}.
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object)
     */
    @Override
    protected void onPostExecute(String aVoid) {
        Toast.makeText(AsyncTaskActivity.context, "End of Process", Toast.LENGTH_SHORT).show();
        AsyncTaskActivity.resTV.setText(aVoid);
        super.onPostExecute(aVoid);
    }

    /**
     * Runs on the UI thread after {@link #publishProgress} is invoked.
     * The specified values are the values passed to {@link #publishProgress}.
     *
     * @param values The values indicating progress.
     * @see #publishProgress
     * @see #doInBackground
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        AsyncTaskActivity.progressBar.setProgress(progressBarVal);
        AsyncTaskActivity.textView.setText(progressBarVal+"%");
        super.onProgressUpdate(values);
    }

    public int getProgressBarVal() {
        return progressBarVal;
    }

    /**
     * <p>Runs on the UI thread after {@link #cancel(boolean)} is invoked and
     * {@link #doInBackground(Object[])} has finished.</p>
     * <p/>
     * <p>The default implementation simply invokes {@link #onCancelled()} and
     * ignores the result. If you write your own implementation, do not call
     * <code>super.onCancelled(result)</code>.</p>
     *
     * @param s The result, if any, computed in
     *          {@link #doInBackground(Object[])}, can be null
     * @see #cancel(boolean)
     * @see #isCancelled()
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCancelled(String s) {
        super.onCancelled("RES = Canselled");
        Toast.makeText(AsyncTaskActivity.context, "Task cancelled", Toast.LENGTH_SHORT).show();
    }
}
