package virbac.virbacapp;

import android.app.Fragment;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

import virbac.virbacapp.tables.Users;

/**
 * Created by omar on 03/10/15.
 */
public class Fragmentubdate extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Bundle b;
    String nom, email, pasword, id;
    EditText mdp, cmdp;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public Fragmentubdate() {
    }

    public static Fragmentubdate newInstance(String param1, String param2) {
        Fragmentubdate fragment = new Fragmentubdate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ubdateuser, container, false);
        TextView nomU = (TextView) rootView.findViewById(R.id.textView2);
        TextView emailU = (TextView) rootView.findViewById(R.id.textView3);
        mdp = (EditText) rootView.findViewById(R.id.editText);
        cmdp = (EditText) rootView.findViewById(R.id.editText2);
        getActivity().setTitle(Main.tagTitles[10]);
        b = getActivity().getIntent().getExtras();
        id = b.getString("id");
        nom = b.getString("name");
        email = b.getString("email");
        pasword = b.getString("password");
        Log.i("id", id);
        Log.i("nom", nom);
        Log.i("password", pasword);
        Log.i("email", email);
        nomU.setText(nom);
        emailU.setText(email);
        ButtonRectangle mEmailSignInButton = (ButtonRectangle) rootView.findViewById(R.id.modifier);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String password = mdp.getText().toString();
                String Cpassword = cmdp.getText().toString();
                boolean cancel = false;
                View focusView = null;
                if (TextUtils.isEmpty(password)) {
                    mdp.setError(getString(R.string.error_field_required));
                    focusView = mdp;
                    cancel = true;
                } else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
                    mdp.setError(getString(R.string.error_invalid_password));
                    focusView = mdp;
                    cancel = true;
                }
                if (TextUtils.isEmpty(Cpassword)) {
                    cmdp.setError(getString(R.string.error_field_required));
                    focusView = cmdp;
                    cancel = true;
                } else if (!TextUtils.isEmpty(Cpassword) && !isPasswordValid(password)) {
                    cmdp.setError(getString(R.string.error_invalid_password));
                    focusView = cmdp;
                    cancel = true;
                }
                // Check for a valid password, if the user entered one.


                if (cancel) {
                    // There was an error; don't attempt login and focus the first
                    // form field with an error.
                    focusView.requestFocus();
                } else {
                    // Show a progress spinner, and kick off a background task to
                    // perform the user login attempt.

                    Log.i("mdp", password);
                    Log.i("mdp", Cpassword);

                    if (!password.equals(Cpassword)) {
                        Toast.makeText(getActivity().getBaseContext(), "Check your password", Toast.LENGTH_LONG).show();

                    } else {

                        if (password.equals(pasword) && password.equals(Cpassword)) {
                            Toast.makeText(getActivity().getBaseContext(), "Password is the same", Toast.LENGTH_LONG).show();

                        } else {
                            ContentValues values = new ContentValues();
                            values.put(Users.NAME, nom);
                            values.put(Users.EMAIL, email);
                            values.put(Users.MOTDEPASSE, password);

                            getActivity().getContentResolver().update(VirbacContentProvider.USER_CONTENT_URI,
                                    values, Users._ID + " = " + Integer.parseInt(id), null);
                            Toast.makeText(getActivity().getBaseContext(), "Your profile is successfully changed", Toast.LENGTH_LONG).show();

                            Fragment fragment = new Fragment1House();
                            android.app.FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                            getActivity().setTitle(Main.tagTitles[0]);
                        }

                    }
                }
            }
        });
        return rootView;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}