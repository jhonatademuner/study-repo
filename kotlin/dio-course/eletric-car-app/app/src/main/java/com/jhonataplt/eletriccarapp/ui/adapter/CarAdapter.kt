package com.jhonataplt.eletriccarapp.ui.adapter;

import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jhonataplt.eletriccarapp.R;
import com.jhonataplt.eletriccarapp.domain.Car

class CarAdapter(private val cars : List<Car>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.price.text = cars[position].price
        holder.battery.text = cars[position].battery
        holder.potency.text = cars[position].potency
        holder.recharge.text = cars[position].recharge
    }

    override fun getItemCount(): Int = cars.size


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val price : TextView = view.findViewById(R.id.tv_price_value)
        val battery : TextView = view.findViewById(R.id.tv_battery_value)
        val potency : TextView = view.findViewById(R.id.tv_potency_value)
        val recharge : TextView = view.findViewById(R.id.tv_recharge_value)
    }

}

