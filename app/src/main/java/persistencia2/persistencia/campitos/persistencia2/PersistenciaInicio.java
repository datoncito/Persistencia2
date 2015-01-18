package persistencia2.persistencia.campitos.persistencia2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class PersistenciaInicio extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistencia_inicio);




        SharedPreferences preferencias=getSharedPreferences("misPreferencias", MODE_PRIVATE);
      String valor=  preferencias.getString("editTextPref","");
        if(valor.equals("pueco")) {


            Intent i = new Intent(this, ActividadRegistrado.class);
            startActivity(i);
            finish();
        }else {

            Intent i = new Intent("persistencia2.persistencia.campitos.persistencia2.AppPreferenceActivity");
            startActivity(i);
            finish();
        }

       // Toast.makeText(getBaseContext(),preferencias.getString("editTextPref",""), Toast.LENGTH_LONG).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_persistencia_inicio, menu);
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
}
