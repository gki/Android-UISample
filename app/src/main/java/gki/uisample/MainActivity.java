package gki.uisample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Switch showTitleSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTitleSwitch = (Switch) findViewById(R.id.switch1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickShowErrorAlert(View v) {
        String title = null;
        if (showTitleSwitch.isChecked()) {
            title = "エラー";
        }

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage("新しいパスワードを入力してください。少なくとも、６文字以上で、大文字、小文字、数字を含めてください。")
                .setPositiveButton("OK", null)
                .show();
    }

    public void onClickShowConfirmationAlert(View v) {
        String title = null;
        if (showTitleSwitch.isChecked()) {
            title = "Confirmation";
        }

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage("Pairing Coaching Sensors Can Be Done by Settings on Type-R.")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .show();
    }

    public void onClickIndicatorFullScreen(View v){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
            }
        }, 5000);
    }

    public void onClickShowToast(View v) {
        Toast.makeText(this, "Analyzing your uploaded data is finished.", Toast.LENGTH_LONG).show();
    }
}
