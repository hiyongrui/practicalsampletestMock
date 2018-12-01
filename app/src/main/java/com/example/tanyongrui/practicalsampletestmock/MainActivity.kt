package com.example.tanyongrui.practicalsampletestmock

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maleRadioBtn.setOnClickListener() {
            femaleRadioBtn.isChecked = false
        }

        femaleRadioBtn.setOnClickListener() {
            maleRadioBtn.isChecked = false
        }

    }

    fun registerPerson(v: View) {
        var radioText: String = getRadioText()
        var personObject = PersonEntity()
        personObject.name = nameEdit.text.toString()
        personObject.phone = phoneEdit.text.toString()
        personObject.gender = radioText

        Toast.makeText(this,
            "Name: " + personObject.name + "\nPhone: " + personObject.phone +
                    "\nGender: " + personObject.gender,

            Toast.LENGTH_LONG).show()
    }

    fun getRadioText(): String {
        var genderText = "Male"
        if (femaleRadioBtn.isChecked) {
            genderText = "Female"
        }
        return genderText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.save_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.save) {
            var radioText: String = getRadioText()
            Toast.makeText(this,
                "Name: " + nameEdit.text + "\nPhone: " + phoneEdit.text + "\nGender: " + radioText,

                Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
