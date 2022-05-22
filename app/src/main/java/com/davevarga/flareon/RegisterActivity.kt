package com.davevarga.flareon
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.davevarga.flareon.AuthHelper
import com.google.android.material.snackbar.Snackbar
import com.davevarga.flareon.User
import com.google.android.material.textfield.TextInputEditText


class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@RegisterActivity

    private lateinit var name : EditText
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var confirmPass :EditText
    private lateinit var btnRegist : Button
    private lateinit var databaseHelper: AuthHelper

//    private lateinit var linearLayout: LinearLayout
//
//    private lateinit var textInputLayoutName: TextInputLayout
//    private lateinit var textInputLayoutEmail: TextInputLayout
//    private lateinit var textInputLayoutPassword: TextInputLayout
//    private lateinit var textInputLayoutConfirmPassword: TextInputLayout
//
//    private lateinit var textInputEditTextName: TextInputEditText
//    private lateinit var textInputEditTextEmail: TextInputEditText
//    private lateinit var textInputEditTextPassword: TextInputEditText
//    private lateinit var textInputEditTextConfirmPassword: TextInputEditText
//
//    private lateinit var appCompatButtonRegister: AppCompatButton
    private lateinit var appCompatTextViewLoginLink: AppCompatTextView

    private lateinit var inputValidation: InputValidation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        // hiding the action bar
        supportActionBar?.hide()

        // initializing the views
        initViews()

        // initializing the listeners
        initListeners()

        // initializing the objects
        initObjects()
    }

    /**
     * This method is to initialize views
     */
    private fun initViews() {
        name = findViewById<TextInputEditText>(R.id.textInputEditTextName)
        email = findViewById<TextInputEditText>(R.id.textInputEditTextEmail)
        password = findViewById<TextInputEditText>(R.id.textInputEditTextPassword)
        confirmPass = findViewById<TextInputEditText>(R.id.textInputEditTextConfirmPassword)
        btnRegist = findViewById<AppCompatButton>(R.id.appCompatButtonRegister)

//        linearLayout = findViewById(R.id.linearView) as LinearLayout
//        textInputLayoutName = findViewById(R.id.textInputLayoutName) as TextInputLayout
//        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail) as TextInputLayout
//        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword) as TextInputLayout
//        textInputLayoutConfirmPassword = findViewById(R.id.textInputLayoutConfirmPassword) as TextInputLayout
//
//        textInputEditTextName = findViewById(R.id.textInputEditTextName) as TextInputEditText
//        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail) as TextInputEditText
//        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword) as TextInputEditText
//        textInputEditTextConfirmPassword = findViewById(R.id.textInputEditTextConfirmPassword) as TextInputEditText
//
//        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister) as AppCompatButton
//
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink) as AppCompatTextView

    }


    private fun initListeners() {

        val btnRegist = findViewById<AppCompatButton>(R.id.appCompatButtonRegister)
        btnRegist?.setOnClickListener(this)
        appCompatTextViewLoginLink!!.setOnClickListener(this)

    }
    private fun initObjects() {
        inputValidation = InputValidation(activity)
        databaseHelper = AuthHelper(this)
    }


    override fun onClick(v: View) {
        when (v.id) {

            R.id.appCompatButtonRegister -> {
                postDataToSQLite()
                val accountsIntent = Intent(this, com.davevarga.flareon.ui.MainActivity::class.java)
                startActivity(accountsIntent)
            }

            //R.id.appCompatTextViewLoginLink -> finish()

            R.id.appCompatTextViewLoginLink -> {
                val intentRegister = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intentRegister)
            }
        }
    }

    private fun postDataToSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(name ,"Enter Full Name")) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(email , "Enter Valid Email")) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(password ,  "Enter Valid Email")) {
            return
        }
        if (!inputValidation!!.isInputEditTextMatches(password ,
                confirmPass ,
                "Passwords Do Not Match")) {
            return
        }
        if (!databaseHelper!!.checkUser(email!!.text.toString().trim())) {
            var user = User(name = name!!.text.toString().trim(),
                email = email!!.text.toString().trim(),
                password = password!!.text.toString().trim())

            databaseHelper!!.addUser(user)
            emptyInputEditText()
        } else {
            Toast.makeText(this, "Email already exists", Toast.LENGTH_LONG).show()
        }
    }
    private fun emptyInputEditText() {
        name!!.text = null
        email!!.text = null
        password!!.text = null
        confirmPass!!.text = null
    }
}