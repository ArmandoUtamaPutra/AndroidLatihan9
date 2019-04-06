package com.android.androidlatihan9.data.data_net

import com.android.androidlatihan9.data.data_model.People

class PeopleListInfo {
    companion object {
        var PeopleList = initPeopleList()
        /**
         * add dummy data
         */

        private fun initPeopleList () : MutableList<People>{
            var po_peoples = mutableListOf<People>()
            po_peoples.add(People(
                "arman",
                "Tangerang1",
                "085215304624",
                "huwgfwugwbyhuwgh@gmail.com",
                "ArmandoUtamaPutra",
                "twitter.com",
                1))
            po_peoples.add(People(
                "panjul",
                "Tangerang2",
                "085215304624",
                "huwgfwugwbyhuwgh@gmail.com",
                "ArmandoUtamaPutra",
                "twitter.com",
                2))
            po_peoples.add(People(
                "rizky",
                "Tangerang3",
                "085215304624",
                "huwgfwugwbyhuwgh@gmail.com",
                "ArmandoUtamaPutra",
                "twitter.com",
                3))

            return po_peoples

        }
    }
}