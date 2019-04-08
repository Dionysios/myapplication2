package com.example.myapplication2

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

   // private val min_INTERVAL = (15 * 60 * 1000).toLong() // 1 Day
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .build()
        val interval= timeTillFutureJob()
        val downloadWork = OneTimeWorkRequestBuilder<StoryDownloadWork>()
            .setInitialDelay(interval, TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance().enqueue(downloadWork)

        WorkManager.getInstance().getStatusById(downloadWork.id).observe(this, Observer {
            d("daniel", "value? ${it?.state}")
        })
    }

    fun timeTillFutureJob(): Long {
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_MONTH, 0)
        c.set(Calendar.HOUR_OF_DAY, 15)
        c.set(Calendar.MINUTE, 20)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        val howMany = c.timeInMillis - System.currentTimeMillis()
        d("daniel","In how many millisecond I should run$howMany")
        return howMany
    }

    fun intervals():Long {
        val internalii : Long =  15 * 60 * 1000
        return internalii
    }
}
