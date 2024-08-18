package com.example.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SmsBroadCastreciver:BroadcastReceiver() {
var smsBroadCastRecuverListener:SmsBroadCastRecuverListener?=null

    override fun onReceive(context: Context?, intent: Intent?) {
       if(SmsRetriever.SMS_RETRIEVED_ACTION==intent?.action){
           val extras=intent.extras
           val smsRetrieverStatus=extras?.get(SmsRetriever.EXTRA_STATUS) as Status
           when(smsRetrieverStatus.statusCode){
CommonStatusCodes.SUCCESS->{

    val messagIntent=extras.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT)
     smsBroadCastRecuverListener?.onSuccess(messagIntent)
}


               CommonStatusCodes.TIMEOUT->{

smsBroadCastRecuverListener?.onFailure()
               }
           }
       }
    }

    interface SmsBroadCastRecuverListener{
        fun onSuccess(intent: Intent?)
        fun onFailure()
    }

}