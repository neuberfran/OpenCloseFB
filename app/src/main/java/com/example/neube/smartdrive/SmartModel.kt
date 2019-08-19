package com.example.neube.smartdrive

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.firestore.IgnoreExtraProperties

class SmartModel {

    companion object Factory {
        fun create(): SmartModel = SmartModel()
    }

    var DirecaoDois: Int = 1
    var PararDois: Int = 0
    var DirecaoUm: Int = 1
    var PararUm: Int = 0
    var fcmotordoisa: Int = 0
    var fcmotordoisb: Int = 0
    var fcmotoruma: Int = 0
    var fcmotorumb: Int = 0
    var BaixaTemperatura: Boolean = false
    var Chovendo: Boolean = false

//            override fun(): String {
//        return "{SmartModel DirecaoDois=$DirecaoUm ticker PararUm=$PararUm}"
//    }

}


//@IgnoreExtraProperties
//data class SmartModel(
//        var DirecaoDois: Int = 1,
//    val PararDois: Int = 0,
//    val DirecaoUm: Int = 1,
//    val PararUm: Int = 0,
//    val fcmotordoisa: Int = 0,
//    val fcmotordoisb: Int = 0,
//    val fcmotoruma: Int = 0,
//    val fcmotorumb: Int = 0,
//    val BaixaTemperatura: Boolean = false,
//    val Chovendo: Boolean = false
//)