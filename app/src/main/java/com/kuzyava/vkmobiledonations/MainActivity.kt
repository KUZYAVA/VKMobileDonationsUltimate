package com.kuzyava.vkmobiledonations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kuzyava.vkmobiledonations.db.DonationDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        DonationDatabase.donations.clear()
    }
}