package persistencia2.persistencia.campitos.persistencia2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import persistencia2.persistencia.campitos.persistencia2.R;

/**
 * Created by campitos on 3/01/15.
 */
public class AppPreferenceActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        PreferenceManager prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("misPreferencias");
        PreferenceManager.setDefaultValues(this, R.xml.myappreferences, false);
        addPreferencesFromResource(R.xml.myappreferences);




        Preference button = (Preference)findPreference("button");
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference arg0) {
                Intent i=new Intent(getApplicationContext(),ActividadRegistrado.class);
                startActivity(i);
                finish();
                return true;
            }
        });

    }

    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }


    /*
    El siguiente metodo, junto con onResume onPause, hace que cuando selecciones en el xml de preferencias el valor,
    este cambie al asignarle un valor, si no pusieras estos tres metodos, de todos modos si haria el cambio, pero la gente pensaria
    que no lo hizo por que no se visualizaria ninguan cambio enb la pantalla
     */

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference pref = findPreference(key);
        if (pref instanceof EditTextPreference) {
            EditTextPreference etp = (EditTextPreference) pref;
            pref.setSummary(etp.getText());
        }
    }
}
