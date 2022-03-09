package com.nbd.calculadora

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.nbd.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    primero activar view binding

     */
    private lateinit var binding:ActivityMainBinding
    var  firstvalue: Double = 0.0
    var operator: Char ='x'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.buttonAC.setOnClickListener {
           binding.editTextNumber.text.clear()
            Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show()

        }
        binding.buttonDel.setOnClickListener{
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }
        binding.buttonEquals.setOnClickListener {
            when(operator){
                '+' ->
                {
                    binding.editTextNumber.setText("${firstvalue+binding.editTextNumber.text.toString().toDouble()}")
                }
                '-' ->
                {
                    binding.editTextNumber.setText("${firstvalue-binding.editTextNumber.text.toString().toDouble()}")
                }
                '*' ->
                {
                    binding.editTextNumber.setText("${firstvalue*binding.editTextNumber.text.toString().toDouble()}")
                }
                '÷' ->
                {
                    binding.editTextNumber.setText("${firstvalue/binding.editTextNumber.text.toString().toDouble()}")
                }

                else-> {binding.editTextNumber.setText("SyntaxError xD")}
            }
        }
        binding.buttonPercent.setOnClickListener {
            binding.editTextNumber.setText(percent(operator))
        }

    }
    fun getOperator(view: View){
        val button=view as Button

        operator= button.text.get(0)
   /*     operator = when(button.id){
            binding.buttonSum.id -> {'+'}
            binding.buttonSubstraction.id -> {'-'}
            binding.buttonMultiplication.id ->{'x'}
            binding.buttonDivition.id ->{'/'}

            else ->{'0'}
        }
    */
        firstvalue=binding.editTextNumber.text.toString().toDouble() //traemos lo de pantalla -> text ->double
        binding.editTextNumber.text.clear()
    }
    fun percent(operatorToUse:Char):String{
        when(operatorToUse){
            '+'-> {
                return "${firstvalue + (firstvalue*binding.editTextNumber.text.toString().toDouble()/100)}"
            }
            '-'-> {
                return "${firstvalue - (firstvalue*binding.editTextNumber.text.toString().toDouble()/100)}"
            }
            '0' ->{
                return "${binding.editTextNumber.text.toString().toDouble()/100}"
            }
            else -> {
                return "SyntaxError xD"
            }
        }

        operator = '0'
        firstvalue=0.0
    }

    fun numberButtonClicked(view: View){
        val button =view as Button

       // binding.editTextNumber.text.append(button.text) 
        when (button.id ){
            binding.buttonDecimal.id -> {
                if(!binding.editTextNumber.text.contains(char = '.')){
                    binding.editTextNumber.text.append(".")
                }
            }
            binding.button0.id -> {binding.editTextNumber.text.append("0") }
            binding.button1.id -> {binding.editTextNumber.text.append("1") }
            binding.button2.id -> {binding.editTextNumber.text.append("2")}
            binding.button3.id -> {binding.editTextNumber.text.append("3")}
            binding.button4.id -> {binding.editTextNumber.text.append("4")}
            binding.button5.id -> {binding.editTextNumber.text.append("5")}
            binding.button6.id -> {binding.editTextNumber.text.append("6")}
            binding.button7.id -> {binding.editTextNumber.text.append("7")}
            binding.button8.id -> {binding.editTextNumber.text.append("8")}
            binding.button9.id -> {binding.editTextNumber.text.append("9")}


            else -> {
                Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()
            }
        }

    }
}