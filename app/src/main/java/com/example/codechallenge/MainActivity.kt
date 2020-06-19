package com.example.codechallenge

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val arr = mutableListOf<Int>()
    private val arr2 = mutableListOf<Int>()
    private val arr3 = mutableListOf<Int>()
    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loop = 0

        submit.setOnClickListener {
            val str = search.text.toString()
            loop = Integer.parseInt(str)
            textView.visibility = GONE
            search.visibility = GONE
            submit.visibility = GONE
            textView2.visibility = VISIBLE
            search2.visibility = VISIBLE
            submit2.visibility = VISIBLE
        }

        submit2.setOnClickListener {
            if (loop > 0) {
                val str = search2.text.toString()
                arr.add(Integer.parseInt(str))
                Log.d("arrr", arr.toString())
                loop--
                search2.text.clear()
            }
            if (loop == 0) {
                textView2.visibility = GONE
                search2.visibility = GONE
                submit2.visibility = GONE

                calc()

                val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

                val adapter = RecycleViewAdapter(
                    this, arr as ArrayList<Int>?,
                    arr2 as ArrayList<Int>?, arr3 as ArrayList<Int>?, count
                )
                recyclerView.adapter = adapter
                recyclerView.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
            }
        }


    }

    private fun calc() {

        var larger = arr[0]
        arr2.add(arr[0])
        arr3.add(1)

        var i = 0
        while (i < arr.size - 1) {
            if (arr[i + 1] > larger) {
                arr2.add(arr[i + 1])
                larger = arr[i + 1]
                count++
                arr3.add(1)
            } else {
                arr3.add(0)
            }
            i++
        }

/*        i = 0
        var j = 0
        while (i < arr.size && j < arr2.size) {
            if (arr[i] == arr2[j]) {
                arr3.add(1)
                j++
            } else {
                arr3.add(0)
            }
            i++
        }*/
        print("$count --> $arr2")

        Log.d("ehtie", arr.toString())
        Log.d("ehtie", arr2.toString())
        Log.d("ehtie", arr3.toString())

        arr.reverse()
        arr2.reverse()
        arr3.reverse()

    }
}
