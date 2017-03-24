package iterator.ir.a050;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class MyTask extends AsyncTask<Void,Integer,String> {

    private Context context;
    private Button buttonDownload;
    private TextView textViewDownload;

    ProgressDialog progressDialog;

    public void setButtonDownload(Button button)
    {
        this.buttonDownload=button;
    }

    public void setTextViewDownload(TextView textView)
    {
        this.textViewDownload=textView;
    }

    public MyTask(Context context)
    {
        this.context=context;
    }

    @Override
    protected String doInBackground(Void... params) {

        int i=0;

        synchronized (this)
        {
            while (i<101)
            {
                try {
                    wait(100);
                    i++;
                    this.publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        return "Download Completed.";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        buttonDownload.setEnabled(false);
        textViewDownload.setText("Downloading...");

        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Downloading ....");
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        textViewDownload.setText(s);
        buttonDownload.setEnabled(true);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Integer progress=values[0];
        progressDialog.setProgress(progress);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);

        if (s.isEmpty())
        {
            textViewDownload.setText("Download Canceled.");
        }
    }
}
