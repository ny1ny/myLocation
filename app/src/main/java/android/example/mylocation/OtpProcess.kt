package android.example.mylocation
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class OtpProcess : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.otp_process)
//
//
//    }
//}

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class OtpProcess : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_process)

        auth = FirebaseAuth.getInstance()
//  val EditTextnumber = mobil.editText?.text.toString()
        val phoneNumber = "+919028162859" // User's phone number with country code

        // Start the phone verification process
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,
            60,
            TimeUnit.SECONDS,
            this,
            object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    // Automatically handle verification if possible
                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // User signed in successfully
                            } else {
                                // Verification failed
                            }
                        }
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    // Handle verification failure
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    // Save verification ID and send token to user for later use
                }
            }
        )
    }
}
