package com.example.myapplication2

import android.util.Log.d
import androidx.work.*
import java.util.concurrent.TimeUnit

class StoryDownloadWork : Worker() {
    

    override fun doWork(): Result {
        d("daniel", "performing work now!")
        val request = PeriodicWorkRequestBuilder<DialyWorker>(15*60*1000, TimeUnit.MILLISECONDS)
            //.Builder(DailyWorker::class.java, 15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance().enqueue(request)

        return Result.SUCCESS
    }
}