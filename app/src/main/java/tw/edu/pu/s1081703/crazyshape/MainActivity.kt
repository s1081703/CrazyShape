package tw.edu.pu.s1081703.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*


@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    var PictureNo:Int = 0  //目前顯示第幾張圖
    var TotalPictures:Int = 4 //總共幾張圖片(假設僅顯示pu0-pu3)
    var X: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(img)


        Toast.makeText(baseContext, "作者：楊婕語", Toast.LENGTH_LONG).show()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        })

        fun ShowPicture(){
            when (PictureNo){
                1 -> imgNext.setImageResource(R.drawable.triangle)
                2 -> imgNext.setImageResource(R.drawable.star)
                3 -> imgNext.setImageResource(R.drawable.square)
                4 -> imgNext.setImageResource(R.drawable.circle)
            }
        }

        imgNext.setOnClickListener {
            X= (1..4).random()
            PictureNo = X
            ShowPicture()
            true
        }


    }


}