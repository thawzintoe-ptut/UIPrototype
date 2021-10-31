package com.ptut.uiprototype

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ptut.uiprototype.base.BaseRecyclerAdapter
import com.ptut.uiprototype.base.BaseViewHolder
import com.ptut.uiprototype.databinding.LayoutCarItemBinding

class SearchResultAdapter(
    private val context: Context,
    private val listener: SearchResultOnClickListener
) : BaseRecyclerAdapter<SearchResultVO, SearchResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(
            LayoutCarItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            ), listener
        )
    }
}

class SearchResultViewHolder(
    private val binding: LayoutCarItemBinding,
    private val listener: SearchResultOnClickListener
) : BaseViewHolder<SearchResultVO>(binding.root) {
    override fun setData(mData: SearchResultVO) {
        binding.carProfileIv.show(mData.carProfilePic)
        binding.carTypeTv.text = mData.carModel
        binding.carModelNumberTv.text = mData.carNumberPlate
        binding.carSeatTv.text =
            binding.root.context.getString(R.string.text_seats_count, mData.seater)
        binding.rentalFeeTv.text =
            binding.root.context.getString(R.string.text_rental_fee, mData.rentalFee.toString())
        binding.mileageFeeTv.text =
            binding.root.context.getString(R.string.text_mileage_fee, mData.mileageFee.toString())
        binding.carDistanceTv.text =
            binding.root.context.getString(R.string.text_distance_from_here, mData.distanceInKM.toString())

        binding.root.setOnClickListener {
            listener.onClickSearchResult(mData.id)
        }
    }

}

interface SearchResultOnClickListener {
    fun onClickSearchResult(searchResultID: String)
}