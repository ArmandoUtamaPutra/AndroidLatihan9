package com.android.androidlatihan9.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.androidlatihan9.R
import com.android.androidlatihan9.StartApp
import com.android.androidlatihan9.data.data_model.People
import kotlinx.android.synthetic.main.fragment_details.*

class DetailFragment: Fragment() {
    private lateinit var viewModel: PeopleDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(PeopleDetailViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id),0)
        val peopleId = arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewModel.getPeopleDetails(peopleId).observe(this, Observer { peopleDetails ->
                populatePeopleDetails(peopleDetails)
            })
        }

    }

    private fun populatePeopleDetails(people: People?){
        textViewNama.text = people?.name
        textViewMet.text = people?.metAt
        textViewContact.text = people?.contact
        textViewFacebook.text = people?.facebook
        textViewEmail.text = people?.email
        textViewTwitter.text = people?.twitter

    }
}