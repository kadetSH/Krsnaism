package com.example.krsnaism

import android.os.Bundle
import com.example.krsnaism.view.authorization.auth.fragment.RegistrationFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.messaging.FirebaseMessaging
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    object Crashlytics {
        fun log(e: Throwable) {
            FirebaseCrashlytics.getInstance().recordException(e)
        }
    }

    private var token: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        //Без этого лога не отправляется отчет об ошибках
        Crashlytics.log(IllegalArgumentException())

//        throw IllegalArgumentException()


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            token = task.result.toString()
        })



        if (savedInstanceState == null) {
            isActivation()
        }

    }


    private fun isActivation() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameLayoutContainer, RegistrationFragment.newInstance(token))
            .addToBackStack(null)
            .commit()
    }

}