package com.davevarga.flareon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.davevarga.flareon.AuthHelper
import com.davevarga.flareon.ui.MainActivity_GeneratedInjector
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.SignInButton
//import com.google.android.gms.common.api.ApiException
//import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


const val RC_SIGN_IN = 123

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@LoginActivity

//    val gsc: GoogleSignInClient? = null

    private lateinit var Email : EditText
    private lateinit var password : EditText

    private lateinit var btnLogin : Button
    private lateinit var btnReg : Button
    private lateinit var databaseHelper: AuthHelper

    private lateinit var dbHelper: AuthHelper

    private lateinit var linearView: LinearLayout

    private lateinit var textInputLayoutEmail: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout

    private lateinit var textInputEditTextEmail: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText

    private lateinit var appCompatButtonLogin: AppCompatButton

    private lateinit var textViewLinkRegister: AppCompatTextView

    private lateinit var googleButton: Button
    private lateinit var inputValidation: InputValidation

//    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val sign_in_button = findViewById<Button>(R.id.sign_in_button)
        setContentView(R.layout.activity_login)

        // hiding the action bar
        supportActionBar!!.hide()

        // initializing the views
        initViews()

        // initializing the listeners
        initListeners()

        // initializing the objects
        initObjects()

//        val gso =
//            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("678231256358-i7t29ea3ghu40gdpa5up1j0t0inplnl3.apps.googleusercontent.com")
//                .requestEmail()
//                .build()
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        val sign_in_button_google = findViewById<Button>(R.id.sign_in_button_google)
//
//        sign_in_button_google.setOnClickListener {
//            signIn()
//        }


    }
//    private fun signIn() {
//        val signInIntent = mGoogleSignInClient.signInIntent
//        startActivityForResult(
//            signInIntent, RC_SIGN_IN
//        )
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == RC_SIGN_IN) {
//            val task =
//                GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(
//                ApiException::class.java
//            )
//            // Signed in successfully
//            val googleId = account?.id ?: ""
//            Log.i("Google ID",googleId)
//
//            val googleFirstName = account?.givenName ?: ""
//            Log.i("Google First Name", googleFirstName)
//
//            val googleLastName = account?.familyName ?: ""
//            Log.i("Google Last Name", googleLastName)
//
//            val googleEmail = account?.email ?: ""
//            Log.i("Google Email", googleEmail)
//
//            val googleProfilePicURL = account?.photoUrl.toString()
//            Log.i("Google Profile Pic URL", googleProfilePicURL)
//
//            val googleIdToken = account?.idToken ?: ""
//            Log.i("Google ID Token", googleIdToken)
//
//
//            val myIntent = Intent(this, MainActivity::class.java)
//            myIntent.putExtra("google_id", googleId)
//            myIntent.putExtra("google_first_name", googleFirstName)
//            myIntent.putExtra("google_last_name", googleLastName)
//            myIntent.putExtra("google_email", googleEmail)
//            myIntent.putExtra("google_profile_pic_url", googleProfilePicURL)
//            myIntent.putExtra("google_id_token", googleIdToken)
//            this.startActivity(myIntent)
//        } catch (e: ApiException) {
//            // Sign in was unsuccessful
//            Log.e(
//                "failed code=", e.statusCode.toString()
//            )
//        }
//    }


//    fun initGmail(){
//        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        val account = GoogleSignIn.getLastSignedInAccount(this)
//        sign_in_button.visibility = View.VISIBLE
//
//        sign_in_button.setOnClickListener{
//            val signInIntent = mGoogleSignInClient.signInIntent
//            startActivityForResult(signInIntent, RC_SIGN_IN)
//        }
    //}
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }
//    }
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//
//            // Signed in successfully, show authenticated UI.
//            sign_in_button.visibility = View.GONE
//        } catch (e: ApiException) {
//            sign_in_button.visibility = View.VISIBLE
//        }
//    }


    private fun initViews() {

        linearView = findViewById(R.id.linearView) as LinearLayout

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail) as TextInputLayout
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword) as TextInputLayout

        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail) as TextInputEditText
        textInputEditTextPassword =
            findViewById(R.id.textInputEditTextPassword) as TextInputEditText

        appCompatButtonLogin = findViewById(R.id.appCompatButtonLogin) as AppCompatButton

        textViewLinkRegister = findViewById(R.id.textViewLinkRegister) as AppCompatTextView

        Email = textInputEditTextEmail
        password = textInputEditTextPassword
        btnReg = appCompatButtonLogin

        //googleButton = findViewById(R.id.sign_in_button) as SignInButton

    }


    private fun initListeners() {

        appCompatButtonLogin!!.setOnClickListener(this)
        textViewLinkRegister!!.setOnClickListener(this)
        //googleButton!!.setOnClickListener(this)
    }
    private fun initObjects() {

        databaseHelper = AuthHelper(activity)
        inputValidation = InputValidation(activity)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.appCompatButtonLogin -> verifyFromSQLite()
            R.id.textViewLinkRegister -> {
                // Navigate to RegisterActivity
                val intentRegister = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intentRegister)

            }
//            R.id.button_sign_out -> signOut()
            //R.id.sign_in_button -> signIn()
        }
    }
//    private fun signOut() {
//        mGoogleSignInClient.signOut()
//            .addOnCompleteListener(this) {
//                // ...
//            }
//    }

    private fun verifyFromSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(Email!!, "Enter Valid Email")) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(Email!!, "Enter Valid Email")) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(password!!, "Enter Valid Email")) {
            return
        }
        if (databaseHelper.checkUser(Email!!.text.toString().trim { it <= ' ' })) {
            val accountsIntent = Intent(this, com.davevarga.flareon.ui.MainActivity::class.java)
            accountsIntent.putExtra("EMAIL", Email!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            startActivity(accountsIntent)
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(linearView!!, "Wrong Email or Password", Snackbar.LENGTH_LONG)
                .show()
        }
    }
    private fun emptyInputEditText() {
        Email!!.text = null
        password!!.text = null
    }
}