package android.example.mylocation

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

import android.widget.Toast

import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.*

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val button1: Button
        val button2: Button
        val username_: TextInputLayout
        val password_: TextInputLayout
        val firebase: FirebaseDatabase
        val refrence: DatabaseReference
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)
        button1 = findViewById(R.id.loginb)
        button2 = findViewById(R.id.signupb)
        username_ = findViewById(R.id.username_text_field_design)
        password_ = findViewById(R.id.password_text_field_design)


        button1.setOnClickListener(View.OnClickListener {

            // String varib=username_.text
            var user = username_.editText?.text.toString()
            var pass = password_.editText?.text.toString()

            if (!user.isEmpty()) {
                if (!pass.isEmpty()) {

                    val firebase = FirebaseDatabase.getInstance()
                    val reference = firebase.getReference("datauser")
                    // this is copy of checking username and password

                    reference.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                // Data exists
                                //  println("Data is stored in Firebase.")
                                val dataval = snapshot.child(user)?.child("password")?.getValue() as?String
                                Log.d(ContentValues.TAG, "Extracted text: $dataval")
                                if (dataval !=null && dataval == pass) {
                                    // Toast.makeText(this,"login succesfully",Toast.LENGTH_SHORT).
                                    Toast.makeText(
                                        applicationContext,
                                        "register succesfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    intent = Intent(applicationContext, HtmlMap::class.java)
                                    startActivity(intent)
                                    finish()
                                }

                            } else {

                                Toast.makeText(applicationContext,"password do not match",Toast.LENGTH_SHORT).show()

                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            println("Error: $error")
                        }
                    })


                } else {

                    Toast.makeText(applicationContext," enter password ",Toast.LENGTH_SHORT).show()
                    //   username_.isErrorEnabled()
                    //  password_.setError("enter password")
                }

            } else {
                Toast.makeText(applicationContext," enter username ",Toast.LENGTH_SHORT).show()
                //  username_.setError("wrong password")
            }


        })


        button2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
            finish()
        })

    }
}