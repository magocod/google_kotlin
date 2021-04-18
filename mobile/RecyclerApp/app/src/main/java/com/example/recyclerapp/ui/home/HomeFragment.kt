package com.example.recyclerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    lateinit var contacts: ArrayList<Contact>
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // MethodHandles.Lookup the recyclerview in activity layout
        val rvContacts = root.findViewById<View>(R.id.rvContacts) as RecyclerView
        // Initialize contacts
        contacts = Contact.createContactsList(10)
        // Create adapter passing in the sample user data
        val adapter = ContactsAdapter(contacts)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(requireContext())

        // add to the existing list
        contacts.addAll(Contact.createContactsList(5))

        val addButton = root.findViewById<Button>(R.id.button)

        addButton.setOnClickListener() {
            // record this value before making any changes to the existing list
            val curSize = adapter.itemCount
            val newItems = Contact.createContactsList(5)
            contacts.addAll(newItems)
            // curSize should represent the first element that got added
            // newItems.size() represents the itemCount
            adapter.notifyItemRangeInserted(curSize, newItems.size)
        }

        root.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener() {
            adapter.notifyDataSetChanged()
        }

        return root
    }
}