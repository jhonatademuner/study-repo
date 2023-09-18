package com.jhonataplt.eletriccarapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jhonataplt.eletriccarapp.R
import com.jhonataplt.eletriccarapp.data.CarFactory
import com.jhonataplt.eletriccarapp.ui.adapter.CarAdapter

class CarFragment : Fragment() {

    private lateinit var calculateBtn: FloatingActionButton
    private lateinit var carsList : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        calculateBtn = view.findViewById(R.id.fab_calculate)
        carsList = view.findViewById(R.id.rv_cars_list)

        val adapter = CarAdapter(CarFactory.list)
        carsList.adapter = adapter

        calculateBtn.setOnClickListener {
            val intent = Intent(activity, CalculateActivity::class.java)
            startActivity(intent)
        }

        super.onViewCreated(view, savedInstanceState)


    }

}