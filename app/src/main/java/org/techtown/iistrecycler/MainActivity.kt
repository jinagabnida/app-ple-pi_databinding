package org.techtown.iistrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.techtown.iistrecycler.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var addBtn: Button
    private lateinit var recycler: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        addBtn = binding.mainButton
            //findViewById(R.id.main_button)
        recycler = binding.mainRecycler
            //findViewById(R.id.main_recycler)

        val list : ArrayList<Data> = ArrayList()

        recycler.adapter = ListAdapter(list){ data, position ->
            list.removeAt(position)
            Toast.makeText(this, data.itemNameText, Toast.LENGTH_SHORT).show()
            recycler.adapter?.notifyItemRemoved(position)
        }

        addBtn.setOnClickListener {
            val randomInt = Random.nextInt(100) // 0 ~ 99
            list.add(Data("밥","%02d".format(randomInt)))
            recycler.adapter?.notifyItemInserted(list.size-1)
        }

        val sum : (a : Int, b : Int) -> Int = {a, b ->
            a+b//람다 함수
        }
    }
}