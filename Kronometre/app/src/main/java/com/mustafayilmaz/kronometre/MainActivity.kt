 package com.mustafayilmaz.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.mustafayilmaz.kronometre.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)
        setContentView(binding.root)

        var zamaniYonlendir: Long = 0
        binding.btnstart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniYonlendir
            binding.kronometre.start()
            binding.btnstart.visibility = View.GONE
            binding.btnpause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.btnpause.setOnClickListener {
            zamaniYonlendir = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnpause.visibility = View.GONE
            binding.btnstart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        binding.btnreset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniYonlendir = 0
            binding.btnpause.visibility = View.GONE
            binding.btnstart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}