package net.softglobe.contentprovidertutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.softglobe.contentprovidertutorial.databinding.ItemContactBinding

class ContactsAdapter : ListAdapter<Contact, ContactsAdapter.ContactsViewHolder>(ContactsDiffUtils()) {

    lateinit var binding : ItemContactBinding
    inner class ContactsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(contact: Contact) {
            binding.contactName.text = contact.name
            binding.contactNumber.text = contact.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_contact, parent, false)
        return ContactsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ContactsDiffUtils : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

    }
}