package com.ihsan.introsliderpage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.ihsan.introsliderpage.R
import com.ihsan.introsliderpage.databinding.ActivitySecondBinding
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    private var player1: Int = -1
    private var player2: Int = -2

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("nama") ?: "not found"
        binding.tvP1.text = nama
        val mode = intent.getStringExtra("mode") ?: "not found"
        val snack = Snackbar.make(
            binding.btnReset,
            "Selamat Main $nama..",
            Snackbar.LENGTH_SHORT
        )
        snack.show()

        if (mode == "pvp") {
            playModePvp()
        } else {
            playModeVscom()
        }
        binding.btnExit.setOnClickListener {
            val dialog = DialogFragment()
            dialog.show(supportFragmentManager, "")
        }
    }

    private fun playModePvp() {
        binding.tvP2.text = "Player 2"
        binding.ivBatu.setOnClickListener {
            player1 = 0
            toastLog()

            btnDisabler()
            resultProcess()
        }
        binding.ivP2Batu.setOnClickListener {
            player2 = 0
            toastLogP2()

            btnDisablerP2()
            resultProcess()
        }
        binding.ivGunting.setOnClickListener {
            player1 = 1
            toastLog()

            btnDisabler()
            resultProcess()
        }
        binding.ivP2Gunting.setOnClickListener {
            player2 = 1
            toastLogP2()

            btnDisablerP2()
            resultProcess()
        }
        binding.ivKertas.setOnClickListener {
            player1 = 2
            toastLog()

            btnDisabler()
            resultProcess()
        }
        binding.ivP2Kertas.setOnClickListener {
            player2 = 2
            toastLogP2()

            btnDisablerP2()
            resultProcess()
        }
        binding.btnReset.setOnClickListener {
            btnReseter()
            btnEnablerAll()
        }
    }

    private fun toastLog() {
        Toast.makeText(applicationContext, "Player 1 telah memilih", Toast.LENGTH_SHORT).show()
        when (player1) {
            0 -> Log.e("Player 1 memilih", "Batu")
            1 -> Log.e("Player 1 memilih", "Gunting")
            2 -> Log.e("Player 1 memilih", "Kertas")
        }
    }

    private fun toastLogP2() {
        Toast.makeText(applicationContext, "Player 2 telah memilih", Toast.LENGTH_SHORT).show()
        when (player2) {
            0 -> Log.e("Player 2 memilih", "Batu")
            1 -> Log.e("Player 2 memilih", "Gunting")
            2 -> Log.e("Player 2 memilih", "Kertas")
        }
    }

    private fun playModeVscom() {
        binding.tvP2.text = "CPU"
        btnDisablerP2()
        binding.ivBatu.setOnClickListener {
            player1 = 0
            Log.e("Player 1 memilih", "Batu")

            btnDisabler()
            cpuPlay()
            resultProcess()
        }
        binding.ivGunting.setOnClickListener {
            player1 = 1
            Log.e("Player 1 memilih", "Gunting")

            btnDisabler()
            cpuPlay()
            resultProcess()
        }
        binding.ivKertas.setOnClickListener {
            player1 = 2
            Log.e("Player 1 memilih", "Kertas")

            btnDisabler()
            cpuPlay()
            resultProcess()
        }
        binding.btnReset.setOnClickListener {
            btnReseter()
            btnEnablerP1()
        }
    }

    private fun btnReseter() {
        binding.tvHasilSeri.isVisible = false
        binding.tvHasil.isVisible = false
        binding.tvHasil2.isVisible = false
        binding.ivBatu.setImageResource(R.drawable.batu)
        binding.ivP2Batu.setImageResource(R.drawable.batu)
        binding.ivGunting.setImageResource(R.drawable.gunting)
        binding.ivP2Gunting.setImageResource(R.drawable.gunting)
        binding.ivKertas.setImageResource(R.drawable.kertas)
        binding.ivP2Kertas.setImageResource(R.drawable.kertas)
        player1 = -1
        player2 = -2
    }

    private fun cpuPlay() {
        player2 = Random.nextInt(3)
        when (player2) {
            0 -> {binding.ivP2Batu.setImageResource(R.drawable.batu_x)
                Log.e("CPU memilih", "Batu")}
            1 -> {binding.ivP2Gunting.setImageResource(R.drawable.gunting_x)
                Log.e("CPU memilih", "Gunting")}
            2 -> {binding.ivP2Kertas.setImageResource(R.drawable.kertas_x)
                Log.e("CPU memilih", "Kertas")}
        }
    }

    private fun resultProcess() {
        if (player1 == player2) {
            binding.tvHasilSeri.isVisible = true
            resultRevealer()
        } else if (
            (player1 == 0 && player2 == 1) ||
            (player1 == 1 && player2 == 2) ||
            (player1 == 2 && player2 == 0)
        ) {
            binding.tvHasil.isVisible = true
            resultRevealer()
        } else if (
            (player1 == 1 && player2 == 0) ||
            (player1 == 2 && player2 == 1) ||
            (player1 == 0 && player2 == 2)
        ) {
            binding.tvHasil2.isVisible = true
            resultRevealer()
        }
    }

    private fun resultRevealer() {
        when (player1) {
            0 -> binding.ivBatu.setImageResource(R.drawable.batu_x)
            1 -> binding.ivGunting.setImageResource(R.drawable.gunting_x)
            2 -> binding.ivKertas.setImageResource(R.drawable.kertas_x)
        }
        when (player2) {
            0 -> binding.ivP2Batu.setImageResource(R.drawable.batu_x)
            1 -> binding.ivP2Gunting.setImageResource(R.drawable.gunting_x)
            2 -> binding.ivP2Kertas.setImageResource(R.drawable.kertas_x)
        }
    }

    private fun btnDisabler() {
        binding.ivBatu.isClickable = false
        binding.ivGunting.isClickable = false
        binding.ivKertas.isClickable = false
    }

    private fun btnDisablerP2() {
        binding.ivP2Batu.isClickable = false
        binding.ivP2Gunting.isClickable = false
        binding.ivP2Kertas.isClickable = false
    }

    private fun btnEnablerAll() {
        binding.ivBatu.isClickable = true
        binding.ivP2Batu.isClickable = true
        binding.ivGunting.isClickable = true
        binding.ivP2Gunting.isClickable = true
        binding.ivKertas.isClickable = true
        binding.ivP2Kertas.isClickable = true
    }

    private fun btnEnablerP1() {
        binding.ivBatu.isClickable = true
        binding.ivGunting.isClickable = true
        binding.ivKertas.isClickable = true
    }

}