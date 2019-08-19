package com.example.neube.smartdrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.neube.smartdrive.SmartModel
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.set

class MainActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    var janela1 = db.collection("smartmodel").document("motores")
    val pararRef = db.collection("smartmodel").document("motores")

    var fcmotordoisa: SmartModel? = null
    var PararUm: SmartModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //updateText(janela1,textView1);


        janela1.get().addOnSuccessListener { documentSnapshot ->

            var fcmotordoisa = documentSnapshot.toObject(SmartModel::class.java)

    //        if ("fcmotordoisa", "==" , "1") {
            if (fcmotordoisa!!.equals(1)) {
    //            fecharJanela1.background = resource.getDrawable(R.mipmap.jesqpretae)
                fecharJanela1.background = getDrawable(R.mipmap.jesqpretae)
                fecharJanela1.isEnabled = false
                pararButton.isEnabled = false
            } else if (fcmotordoisa.equals(0)) {
                fecharJanela1.isEnabled = true
                pararButton.isEnabled = true
            }
        }


        pararRef.get().addOnSuccessListener { documentSnapshot ->

            PararUm = documentSnapshot.toObject(SmartModel::class.java)

            if (PararUm!!.equals(1) && fecharJanela1.isEnabled) {
                fecharJanela1.background = getDrawable(R.mipmap.janelafrentee)
                pararButton.background = getDrawable(R.mipmap.stopbb)
            } else if (PararUm!!.equals(0) && fecharJanela1.isEnabled) {
                pararButton.background = getDrawable(R.mipmap.stopaa)
                fecharJanela1.background = getDrawable(R.mipmap.jesqpretae)
            }
        }


        fecharJanela1.setOnClickListener {

            Thread(Runnable {

            var task: Task<DocumentSnapshot> = pararRef.get()

            var snap: DocumentSnapshot= Tasks.await(task)

            var PararUm = snap.toObject(SmartModel::class.java)?.PararUm

            if (PararUm!!.equals(1))  {

                var data = hashMapOf("DirecaoUm" to 1)

                var data2 = hashMapOf("PararUm" to 0)

                db.collection("smartmodel").document("motores").set(data, SetOptions.merge())
                db.collection("smartmodel").document("motores").set(data2, SetOptions.merge())

//                myRef.child("smartmodel/DirecaoUm").setValue(1)
//                myRef.child("smartmodel/PararUm").setValue(0)
                
                

            }

            }).start()

        }

        pararButton.setOnClickListener {


            var data3 = hashMapOf("PararUm" to 1
            )
            db.collection("smartmodel").document("motores").set(data3, SetOptions.merge())

            //     myRef.child("smartmodel/PararUm").setValue(1)

            pararButton.background = getDrawable(R.mipmap.stopbb)

        }
    }
}
