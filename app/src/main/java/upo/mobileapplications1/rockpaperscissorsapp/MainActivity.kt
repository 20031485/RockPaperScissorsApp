package upo.mobileapplications1.rockpaperscissorsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create a Computer object which extracts values from 0 to 2
        val computer = Computer()

        //get all radioButtons
        val rockButton = findViewById<RadioButton>(R.id.rock)           //0
        val paperButton = findViewById<RadioButton>(R.id.paper)         //1
        val scissorsButton = findViewById<RadioButton>(R.id.scissors)   //2

        val playButton = findViewById<Button>(R.id.playbutton)

        //implement playButton's listener
        playButton.setOnClickListener {

            //if no radioButton has been selected
            if(!rockButton.isChecked && !paperButton.isChecked && !scissorsButton.isChecked){

                //TODO: remember .show() at the end!!!
                Toast.makeText(this, getString(R.string.invalid), Toast.LENGTH_LONG).show()
            }

            //if an option has been selected
            else{
                val computersPick = findViewById<TextView>(R.id.computerschoice)

                //extract an integer from 0 to 2
                val computersChoice = computer.extract()
                when(computersChoice){
                    0 -> {
                        computersPick.text = getString(R.string.rock)
                    }
                    1 -> {
                        computersPick.text = getString(R.string.paper)
                    }
                    2 -> {
                        computersPick.text = getString(R.string.scissors)
                    }
                }

                //check which radioButton has been checked
                val choice = if(rockButton.isChecked){
                    0
                }
                else if(paperButton.isChecked){
                    1
                }
                else if(scissorsButton.isChecked){
                    2
                }
                else{
                    -1
                }

                val result = findViewById<TextView>(R.id.result)

                //tie
                if(choice == computersChoice){
                    result.setTextColor(Color.parseColor("#FFFF00"))
                    result.text = getString(R.string.tie)
                }
                //defeat
                else if((computersChoice == 1 && choice == 0)
                    || (computersChoice == 2 && choice == 1)
                    || (computersChoice == 0 && choice == 2)){
                    result.setTextColor(Color.parseColor("#FF0000"))
                    result.text = getString(R.string.loss)
                }
                //victory
                else{
                    result.setTextColor(Color.parseColor("#00FF00"))
                    result.text = getString(R.string.victory)
                }
            }
        }



    }
}