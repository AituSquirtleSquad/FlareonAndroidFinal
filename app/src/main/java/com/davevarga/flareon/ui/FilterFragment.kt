package com.davevarga.flareon.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.davevarga.flareon.R
import com.davevarga.flareon.adapter.GenreAdapter
import com.davevarga.flareon.adapter.GenreAdapter.Companion.filledIdList
import com.davevarga.flareon.databinding.FragmentFilterBinding
import com.davevarga.flareon.models.GenreString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : BaseFragment<FragmentFilterBinding>() {

    private var newGenreString: GenreString = GenreString(0, "27")
    private val viewModelAdapter = GenreAdapter(emptyList())
    private val genreViewModel: GenreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = getString(R.string.filterfragment)
        filledIdList.clear()
        observe()
        setRecyclerview()
        bindButtons()
    }

    private fun bindButtons() {
        binding.saveButton.setOnClickListener { view: View ->
            newGenreString.genres = filledIdList.joinToString("|")
            genreViewModel.insert(newGenreString)
            val toDisplay = newGenreString.genres

            val filterByYearAction = FilterFragmentDirections.actionFilterFragmentToListFragment(
                minYear = binding.minYearValue.text.toString(),
                maxYear = binding.maxYearValue.text.toString(),
                genres = toDisplay
            )
            view.findNavController().navigate(filterByYearAction)
        }
    }

    private fun setRecyclerview() {
        binding.genreRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = viewModelAdapter
        }
    }

    private fun observe() {
        genreViewModel.genreList.observe(viewLifecycleOwner, {
            if (it != null) {
                viewModelAdapter.items = it
                binding.genreRecyclerView.adapter = viewModelAdapter
            }
        })
    }

    override fun getFragmentView() = R.layout.fragment_filter
}