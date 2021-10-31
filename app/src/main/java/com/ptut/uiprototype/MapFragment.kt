package com.ptut.uiprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ptut.uiprototype.databinding.FragmentMapBinding
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.GeoPoint

class MapFragment : Fragment() {

    private val parentActivity: MainActivity by lazy { requireActivity() as MainActivity }
    private lateinit var binding: FragmentMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()

        binding.pickUpOptionsLayout.searchBtn.setOnClickListener {
            Navigation.findNavController(binding.root).run {
                navigate(R.id.action_mapFragment_to_searchFragment)
            }
        }

        binding.pickUpOptionsLayout.startingPointEditText.setOnClickListener {
            Navigation.findNavController(binding.root).run {
                navigate(R.id.action_mapFragment_to_searchFragment)
            }
        }

        binding.pickUpOptionsLayout.dateEditText.setOnClickListener {
            Navigation.findNavController(binding.root).run {
                navigate(R.id.action_mapFragment_to_searchFragment)
            }
        }

        binding.pickUpOptionsLayout.timeEditText.setOnClickListener {
            Navigation.findNavController(binding.root).run {
                navigate(R.id.action_mapFragment_to_searchFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume();
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    private fun initMap() {
        binding.mapView.setBuiltInZoomControls(true)
        binding.mapView.setMultiTouchControls(true)
        val myTile: OnlineTileSourceBase = XYTileSource(
            "cartodb",
            1,
            20,
            256,
            ".png",
            arrayOf("https://cartodb-basemaps-a.global.ssl.fastly.net/light_all/"),
            "© OpenStreetMap contributors"
        )
        binding.mapView.setTileSource(myTile);
        binding.mapView.controller.setZoom(12.5)
        val initPoint = GeoPoint(16.846249823565806, 96.19347393699604) //setting YGN
        binding.mapView.controller.setCenter(initPoint)

    }


}