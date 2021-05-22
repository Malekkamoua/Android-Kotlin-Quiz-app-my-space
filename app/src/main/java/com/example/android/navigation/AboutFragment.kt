/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DataModel
import com.example.myapplication.RecyclerViewAdapter

class AboutFragment : Fragment(), RecyclerViewAdapter.ClickListener {

    private lateinit var adapter: RecyclerViewAdapter
    val listData: ArrayList<DataModel> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_about, container, false)
        buildDisplayData()
        initRecyclerView(view)

        return view
    }
    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerViewAdapter(listData, this)
        recyclerView.adapter = adapter
    }

    private fun buildDisplayData(){
        listData.add(DataModel("Tunisia"))
        listData.add(DataModel("France"))
        listData.add(DataModel("Morocco"))
        listData.add(DataModel("Algeria"))
        listData.add(DataModel("Egypt"))
    }

    override fun onItemClick(dataModel: DataModel) {
        TODO("Not yet implemented")
    }

}
