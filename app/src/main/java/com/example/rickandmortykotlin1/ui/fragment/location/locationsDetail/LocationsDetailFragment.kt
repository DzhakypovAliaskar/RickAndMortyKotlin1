package com.example.rickandmortykotlin1.ui.fragment.location.locationsDetail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortykotlin1.common.base.BaseFragment
import com.example.rickandmortykotlin1.R
import com.example.rickandmortykotlin1.databinding.FragmentLocationsDetailBinding
import com.example.rickandmortykotlin1.ui.state.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsDetailFragment :
    BaseFragment<LocationsDetailViewModel, FragmentLocationsDetailBinding>(
        R.layout.fragment_locations_detail
    ) {

    override val viewModel: LocationsDetailViewModel by viewModel()
    override val binding by viewBinding(FragmentLocationsDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchLocation(LocationsDetailFragmentArgs.fromBundle(requireArguments()).id)
    }

    override fun setupRequests() = with(binding) {
        viewModel.locationState.subscribe {
            progressBar.isVisible = it is UIState.Loading
            characterGroup.isVisible = it !is UIState.Loading
            when (it) {
                is UIState.Error -> {
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    it.data?.let { data ->
                        detailName.text = data.name
                        detailType.text = data.type
                        detailDimension.text = data.dimension
                        detailUrl.text = data.url
                    }
                }
            }
        }
    }
}