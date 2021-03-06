package virbac.virbacapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;

import virbac.virbacapp.tables.Users;

/**
 * Created by omar on 28/09/15.
 */
public class RegisterActivity extends Activity {
    ButtonFloat btnRegister;
    EditText inputFullName;
    EditText inputEmail;
    EditText inputPassword;
    EditText input2Password;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        /********************************/
    /* Définit le nom de l'Activity */
        /********************************/

        setTitle("Créer un nouveau compte");
        inputFullName = (EditText) findViewById(R.id.registerName);
        inputEmail = (EditText) findViewById(R.id.registerEmail);
        inputPassword = (EditText) findViewById(R.id.registerPassword);
        input2Password = (EditText) findViewById(R.id.registerPasswordValid);
        btnRegister = (ButtonFloat) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String name = inputFullName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String password2 = input2Password.getText().toString();
                boolean cancel = false;
                View focusView = null;

                // Check for a valid password, if the user entered one.

                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError(getString(R.string.error_field_required));
                    focusView = inputPassword;
                    cancel = true;
                } else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
                    inputPassword.setError(getString(R.string.error_invalid_password));
                    focusView = inputPassword;
                    cancel = true;
                } else if (!password.equals(password2)) {
                    inputPassword.setError("Check your password again !");
                    focusView = inputPassword;
                    cancel = true;
                }
                // Check for a valid email address.
                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError(getString(R.string.error_field_required));
                    focusView = inputEmail;
                    cancel = true;
                } else if (!isEmailValid(email)) {
                    inputEmail.setError(getString(R.string.error_invalid_email));
                    focusView = inputEmail;
                    cancel = true;
                }

                if (cancel) {
                    // There was an error; don't attempt login and focus the first
                    // form field with an error.
                    focusView.requestFocus();
                } else {
                    // Show a progress spinner, and kick off a background task to
                    // perform the user login attempt.
                    saveUser(name, email, password);

                    Log.i("Add user:", "nom : " + name + " , email : " + email + " mot de passe :" + password);
                    finish();

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public void saveUser(String name, String emailUsr, String motdepasseUsr) {

        final ContentValues values = new ContentValues();

        String email = emailUsr;
        String motdepasse = motdepasseUsr;
        String nom = name;

        if (email.length() == 0) {
            Toast.makeText(getApplicationContext(), "User email should not be empty", Toast.LENGTH_LONG).show();
            return;
        }

        if (motdepasse.length() == 0) {
            Toast.makeText(getApplicationContext(), "User motdepasse should not be empty", Toast.LENGTH_LONG).show();
            return;
        }
        values.put(Users.NAME, nom);
        values.put(Users.EMAIL, email);
        values.put(Users.MOTDEPASSE, motdepasse);
        getContentResolver().insert(VirbacContentProvider.USER_CONTENT_URI, values);

        Toast.makeText(getApplicationContext(), "This compte has been successfully added", Toast.LENGTH_LONG).show();


        Log.i("test database:", "nom : " + name + " , email : " + email);
    }
}