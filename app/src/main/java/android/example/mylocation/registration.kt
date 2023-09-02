package android.example.mylocation

import android.content.ContentValues.TAG
import android.content.Intent
import android.example.mylocation.databinding.OtpProcessBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import kotlin.math.log

class registration : AppCompatActivity() {

    lateinit var namm: TextInputLayout
    lateinit var usernamm: TextInputLayout
    lateinit var emaill: TextInputLayout
    lateinit var mobil: TextInputLayout
    lateinit var pas: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        namm = findViewById(R.id.name)
//        val nammEditText = namm.editText
//        val nammText = nammEditText?.text.toString()
        usernamm = findViewById(R.id.username)
        emaill = findViewById(R.id.email)
        mobil = findViewById(R.id.phone)
        pas = findViewById(R.id.password)

    }

    fun funforlogin(view: View) {
        val intent = Intent(this, loginpage::class.java)
        startActivity(intent)
        finish()
    }

    fun registerclicking(view: View) {
        //  val nammEditText = namm.editText
        //    val namm1 = nammEditText?.text.toString()
        val nammEditText = namm.editText?.text.toString()
        val EditTextuser = usernamm.editText?.text.toString()
        val EditTextemail = emaill.editText?.text.toString()
        val EditTextnumber = mobil.editText?.text.toString()
        val EditTextpassword = pas.editText?.text.toString()
        //  val nammText = nammEditText?.text.toString()
        //  val namm1 = namm.editText?.text.toString()
        // val usernamm1 = usernamm.editText.toString()
        // val emaill1 = emaill.editText.toString()
        //  val mobil1 = mobil.editText.toString()
        //  val pas1 = pas.editText.toString()

        if (!nammEditText.isEmpty()) {
            if (!EditTextuser.isEmpty()) {
                if (!EditTextemail.isEmpty()) {
                    if (!EditTextnumber.isEmpty()) {
                        if (!EditTextpassword.isEmpty()) {

                            val firebase = FirebaseDatabase.getInstance()
                            val reference = firebase.getReference("datauser")
                            val nammEditText = namm.editText?.text.toString()
                            val EditTextuser = usernamm.editText?.text.toString()
                            val EditTextemail = emaill.editText?.text.toString()
                            val EditTextnumber = mobil.editText?.text.toString()
                            val EditTextpassword = pas.editText?.text.toString()

//

                            Log.d(TAG, "Extracted text: $nammEditText")
                            Log.d(TAG, "Extracted text: $EditTextnumber")

                            Log.d(TAG, "pass1: $EditTextpassword")
                            var storingData: dataforfirebase =
                                dataforfirebase(
                                    nammEditText,
                                    EditTextuser,
                                    EditTextemail,
                                    EditTextnumber,
                                    EditTextpassword
                                )
                            reference.child(EditTextuser).setValue(storingData)
                            Toast.makeText(this, "register succesfully", Toast.LENGTH_SHORT).show()
                            intent = Intent(this, OtpProcess::class.java)
                            startActivity(intent)
                            finish()


                        } else {

                        }
                    } else {

                    }
                } else {

                }

            } else {

            }
        } else {

        }

    }
}