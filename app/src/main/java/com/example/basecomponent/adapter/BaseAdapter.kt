package com.example.basecomponent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

open class BaseAdapter<T : Any, T2 : ViewBinding>(
    var list: ArrayList<T>,
    private val viewBindingClass: KClass<T2>,
    private val bindFunction: (T, T2) -> Unit
) : RecyclerView.Adapter<BaseAdapter<T, T2>.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layout = parent.inflateBinding(viewBindingClass)
        return BaseViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.holderBind(list[position])
    }

    inner class BaseViewHolder(private val layout: T2) : RecyclerView.ViewHolder(layout.root) {
        fun holderBind(data: T) {
            bindFunction(data, layout)
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun <T : ViewBinding> ViewGroup.inflateBinding(viewBindingClass: KClass<T>): T {
    val method = viewBindingClass.java.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
    return method.invoke(null, LayoutInflater.from(context), this, false) as T
}
