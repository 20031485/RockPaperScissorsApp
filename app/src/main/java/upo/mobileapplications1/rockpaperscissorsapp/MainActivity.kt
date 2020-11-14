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

        val computer = Computer()

        val rockButton = findViewById<RadioButton>(R.id.rock)           //0
        val paperButton = findViewById<RadioButton>(R.id.paper)         //1
        val scissorsButton = findViewById<RadioButton>(R.id.scissors)   //2

        val playButton = findViewById<Button>(R.id.playbutton)
        playButton.setOnClickListener {
            //se non è stato selezionato nulla
            if(!rockButton.isEnabled && !paperButton.isEnabled && !scissorsButton.isEnabled){
                Toast.makeText(this, R.string.invalid, Toast.LENGTH_LONG)
            }

            //se invece è stata selezionata una opzione
            else{
                val computersPick = findViewById<TextView>(R.id.computerschoice)

                //estraggo un valore da 0 a 2
                val computersChoice = computer.extract()
                when(computersChoice){
                    0 -> {
                        computersPick.text = R.string.rock.toString()
                    }
                    1 -> {
                        computersPick.text = R.string.paper.toString()
                    }
                    2 -> {
                        computersPick.text = R.string.scissors.toString()
                    }
                }

                val choice = if(rockButton.isEnabled){
                    0
                }
                else if(paperButton.isEnabled){
                    1
                }
                else {
                    2
                }

                val result = findViewById<TextView>(R.id.result)

                //pareggio
                if(choice == computersChoice){
                    result.setTextColor(Color.parseColor("#FFFF00"))
                    //result.text = R.string.tie.toString()
                    result.setText(R.string.tie.toString())
                }
                //sconfitta
                else if((computersChoice == 1 && choice == 0)
                    || (computersChoice == 2 && choice == 1)
                    || (computersChoice == 0 && choice == 2)){
                    result.setTextColor(Color.parseColor("#FF0000"))
                    result.setText(R.string.loss.toString())
                }
                //vittoria
                else{
                    result.setTextColor(Color.parseColor("#00FF00"))
                    //result.text = R.string.victory.toString()
                    result.setText(R.string.victory.toString())
                }
            }
        }



    }
}