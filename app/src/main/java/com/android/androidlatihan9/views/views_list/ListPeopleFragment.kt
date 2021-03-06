package com.android.androidlatihan9.views.views_list

import android.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.android.androidlatihan9.R
import com.android.androidlatihan9.StartApp
import com.android.androidlatihan9.data.data_model.People
import com.android.androidlatihan9.views.views_add.AddPeopleData
import com.android.androidlatihan9.views.views_details.DetailAct
import kotlinx.android.synthetic.main.fragment_for_list_people.*
import kotlinx.android.synthetic.main.mainlayout.*

class ListPeopleFragment : android.support.v4.app.Fragment(), ListPeopleAdapter.OnItemClickListener {

    private lateinit var viewModel: PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
//            Toast.makeText(activity.applicationContext, "Text Click FAB", Toast.LENGTH_SHORT)
//                .show()
//            val detailIntent = Intent(context, AddPeopleData::class.java)
//            detailIntent.putExtra(getString(R.string.people_id),people.id)
//            startActivity(detailIntent)

            view.findNavController().navigate(R.id.action_listPeopleFragment_to_fragmentAddPeople)

        }

        viewModel.getPeopleList().observe(this, Observer<List<People>> {
            peoples -> peoples?.let {
            populatePeopleList(peoples)
        }
        })

        }
    override fun OnItemClick(people: People, itemView: View) {
//        Toast.makeText(context, "test click list",
//            Toast.LENGTH_SHORT
//        ).show()
//        val detailIntent=Intent(context,DetailAct::class.java)
//        detailIntent.putExtra(getString(R.string.people_id),people.id)
//        startActivity(detailIntent)
        val detailBundle = Bundle().apply {
            putInt("PEOPLE_ID", people.id)
        }
        view?.findNavController()?.navigate(R.id.action_listPeopleFragment_to_fragmentAddPeople,detailBundle)
    }
    private fun populatePeopleList(peopleList:List<People>){
        peopleRecyclerView.adapter=ListPeopleAdapter(peopleList,this)
    }

//    override fun onResume() {
//        super.onResume()
//
////        val people=(activity?.application as StartApp).getPeopleRepo().getAllPeople()
////        populatePeopleList(people)
////
//        val peopleRepo = (activity?.application as StartApp).getPeopleRepo()
//        peopleRepo.getAllPeople().observe(this, Observer {
//            peopleList -> populatePeopleList(peopleList!!)
//        })
//    }
}