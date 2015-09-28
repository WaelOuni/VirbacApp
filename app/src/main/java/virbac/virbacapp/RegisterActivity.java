package virbac.virbacapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by omar on 28/09/15.
 */
public class RegisterActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        /********************************/
    /* Définit le nom de l'Activity */
        /********************************/

        setTitle("Créer un nouveau compte");
    }
}
