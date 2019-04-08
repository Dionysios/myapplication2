package com.example.myapplication2

import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker

class DialyWorker : Worker() {

    // Define the parameter keys:
    private val KEY_X_ARG = "X"
    private val KEY_Y_ARG = "Y"
    private val KEY_Z_ARG = "Z"

    // The result key:
    private val KEY_RESULT = "result"

    /**
     * This will be called whenever work manager run the work.
     */
    override fun doWork(): Result {
        Log.d("daniel", "performing 15 work now!")
//        // Fetch the arguments (and specify default values):
//        val x = inputData.getLong(KEY_X_ARG, 0)
//        val y = inputData.getLong(KEY_Y_ARG, 0)
//        val z = inputData.getLong(KEY_Z_ARG, 0)
//
//        val timeToSleep = x  + y + z
//        Thread.sleep(timeToSleep)
//
//        //...set the output, and we're done!
//        val output = Data.Builder()
//            .putInt(KEY_RESULT, timeToSleep.toInt())
//            .build()
//
//        outputData = output
        // Indicate success or failure with your return value.
        return Result.SUCCESS
    }
}