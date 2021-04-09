package net.alerok.tripexpenses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener() {
            calculate()
        }
    }

    private fun calculate() {
        if (validate()) {
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val total = (distance * price) / autonomy
                textResult.text = "R$ ${"%.2f".format(total)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.inform_valid_value),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                getString(R.string.fill_all_fields),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validate(): Boolean {
        return (editDistance.text.toString() != "" && editAutonomy.text.toString() != "" && editPrice.text.toString() != "" && editAutonomy.text.toString() != "0")
    }
}