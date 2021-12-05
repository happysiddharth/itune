package com.example.basetemplate.ui.main.addresses

import android.view.View
import android.widget.TextView
import com.example.basetemplate.R
import com.example.basetemplate.data.model.ItuneResponse
import com.example.basetemplate.di.component.ViewHolderComponent
import com.example.basetemplate.ui.base.BaseItemViewHolder

class AddressViewHolder(view: View) : BaseItemViewHolder<ItuneResponse.Result,AddressViewModel>(view){
    private lateinit var addressLine:TextView
    private lateinit var city:TextView
    override fun setUpObservers() {
        viewModel.data.observe(this){
            addressLine.text = it.artistName
            city.text = it.artistViewUrl
        }
    }

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setUpView(view: View) {
        addressLine = view.findViewById(R.id.address)
        city = view.findViewById(R.id.city)

    }
}