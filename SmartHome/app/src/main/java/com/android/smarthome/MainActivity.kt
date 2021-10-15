package com.android.smarthome


import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.smarthome.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


class MainActivity : AppCompatActivity() {

    private val baseUrl ="http://10.0.2.2:3000/"
    private var resp:String?="empty"

    private var service: RetrofitApi?=null
    private var runnable : Runnable= Runnable {  }
    var handler : Handler = Handler()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initRetrofit()

        runnable=object: Runnable{
            override fun run() {
                stringReq("status")
                handler.postDelayed(this,100)
            }

        }
        handler.post(runnable)
    }

    private fun initRetrofit() {
        val retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(ScalarsConverterFactory.create()).build()
        service=retrofit.create(RetrofitApi::class.java)

    }


    private fun changeImg(resp: String) {
        if(resp=="0"){
            binding.imageView.setImageResource(R.drawable.off)
        }

        if(resp=="1"){
            binding.imageView.setImageResource(R.drawable.on)
        }

    }

    fun turnOnClick(view: View){
        stringReq("on")
    }

    fun turnOffClick(view: View){
        stringReq("off")
    }



    private fun stringReq(reqType:String){
        lateinit var call: Call<String>

        if(reqType=="status"){
            call= service!!.getStatus()
        }
        else if(reqType=="on"){
            call= service!!.setOn()
        }
        else if(reqType=="off"){
            call= service!!.setOff()
        }

        call.enqueue(object :Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        resp=it
                        if(resp!=null && reqType=="status"){
                            changeImg(resp!!)
                        }
                    }

                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

}





