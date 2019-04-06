package com.android.androidlatihan9.views.views_add

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.android.androidlatihan9.R
import com.android.androidlatihan9.StartApp
import com.android.androidlatihan9.data.data_model.People
import kotlinx.android.synthetic.main.fragment_add_people.*

class FragmentAddPeople : android.support.v4.app.Fragment () {
    lateinit var btn_: Button
    private lateinit var viewModel: AddPeopleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater.inflate(
            R.layout.fragment_add_people,
            container, false)
        btn_=view.findViewById(R.id.btn_)

        return view
    }

    private fun savePeopleInfo() {
        val people = People(
            textInputNama.editText?.text.toString(),
            textInputMetat.editText?.text.toString(),
            textInputcontact.editText?.text.toString(),
            textInputEmail.editText?.text.toString(),
            textInputFacebook.editText?.text.toString(),
            textInputTwitter.editText?.text.toString()
        )
//        (activity?.application as StartApp).getPeopleRepo().insertPeople(people)
//        activity?.finish()
        viewModel.addpeople(people)
        activity?.finish()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleInfo()
            Toast.makeText(context," "+ textInputNama.editText?.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
