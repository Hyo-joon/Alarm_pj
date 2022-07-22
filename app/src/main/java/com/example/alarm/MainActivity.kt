package com.example.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.NumberPicker
import com.example.alarm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.timeHour.minValue = 0
        binding.timeHour.maxValue = 12

        binding.timeMinute.maxValue= 59
        binding.timeMinute.minValue = 0

        binding.timeAmpm.maxValue=1
        binding.timeAmpm.minValue=0

    }
}