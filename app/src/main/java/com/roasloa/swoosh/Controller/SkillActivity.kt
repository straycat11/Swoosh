package com.roasloa.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.roasloa.swoosh.Utilities.EXTRA_LEAGUE
import com.roasloa.swoosh.R
import com.roasloa.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClick(view: View){
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onSkillFinishedClick(view: View) {
        if(skill != ""){
        val finishedActivity = Intent(this, FinishActivity::class.java)
            finishedActivity.putExtra(EXTRA_LEAGUE, league)
            finishedActivity.putExtra(EXTRA_SKILL,skill)
        startActivity(finishedActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.",Toast.LENGTH_SHORT).show()
        }
    }
}
