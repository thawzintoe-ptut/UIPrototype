package com.ptut.uiprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ptut.uiprototype.databinding.FragmentSearchResultBinding

class SearchResultFragment : Fragment(), SearchResultOnClickListener {
    private val searchAdapter: SearchResultAdapter by lazy {
        SearchResultAdapter(
            requireContext(),
            this
        )
    }
    private lateinit var binding: FragmentSearchResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.addBackNavButton(requireActivity() as AppCompatActivity,R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.title = getString(R.string.title_search_result)

        with(binding.contentMoviesDetailsLayout.searchResultsRv) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
        binding.contentMoviesDetailsLayout.searchResultCountTv.text =
            SearchResultVO.getTestData().size.toString()

        searchAdapter.appendNewData(SearchResultVO.getTestData())
    }

    override fun onClickSearchResult(searchResultID: String) {
        findNavController().navigate(R.id.detailsFragment)
    }

}